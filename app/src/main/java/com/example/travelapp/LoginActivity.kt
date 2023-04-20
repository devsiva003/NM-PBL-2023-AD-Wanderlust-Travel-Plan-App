package com.example.travelapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.travelapp.ui.theme.TravelAppTheme

class LoginActivity : ComponentActivity() {
    private lateinit var databaseHelper: UserDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databaseHelper = UserDatabaseHelper(this)
        setContent {
            TravelAppTheme {
                Surface(
                    color = MaterialTheme.colors.surface,
                    contentColor = MaterialTheme.colors.onSurface,
                ) {
                    LoginScreen(this, databaseHelper)
                }
            }
        }
    }
}

@Composable
fun LoginScreen(context: Context, databaseHelper: UserDatabaseHelper) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }

    val fm = LocalFocusManager.current

    val handleLogin = {
        if (username.isNotEmpty() && password.isNotEmpty()) {
            val user = databaseHelper.getUserByUsername(username)

            if (user != null && user.password == password) {
                error = "Successfully log in"
                context.startActivity(
                    Intent(
                        context, MainActivity::class.java
                    )
                )
                //onLoginSuccess()
            } else {
                error = "Invalid username or password"
            }

        } else {
            error = "Please fill all fields"
        }
    }

    val handleRegisterClick = {
        context.startActivity(
            Intent(
                context, RegisterActivity::class.java
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome Back !",
            style = MaterialTheme.typography.h2,
        )
        Text(
            text = "Let's plan a new journey",
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(10.dp))

        Image(painterResource(id = R.drawable.login_graphic), contentDescription = "")
        Text(
            text = "Login", style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            placeholder = { Text("Enter username here") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { fm.moveFocus(FocusDirection.Down) }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "Username"
                )
            })

        OutlinedTextField(value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = if (!isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            placeholder = { Text("Enter password here") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onNext = { fm.clearFocus() }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock, contentDescription = "Password"
                )
            },
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (!isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Password",

                        )
                }
            }

        )

        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        Button(
            onClick = { handleLogin() }, modifier = Modifier.padding(top = 5.dp)
        ) {
            Text(text = "Login")

        }

        Row {
            TextButton(onClick = { handleRegisterClick() }) { Text(text = "Register") }
            TextButton(onClick = {/*handleForgotPassword()*/ })

            {
                Spacer(modifier = Modifier.width(60.dp))
                Text(text = "Forget password?")
            }
        }
    }
}

/*
private fun startMainPage(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    ContextCompat.startActivity(context, intent, null)
}
*/

/*
@Composable
private fun LoginScreenNew() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }

    val fm = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Welcome Back !",
            style = MaterialTheme.typography.h2,
        )
        Text(
            text = "Let's plan a new journey",
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(10.dp))

        Image(painterResource(id = R.drawable.trav), contentDescription = "")
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            placeholder = { "Enter username here" },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { fm.moveFocus(FocusDirection.Down) }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Username"
                )
            }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = if (!isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            placeholder = { "Enter password here" },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { fm.moveFocus(FocusDirection.Down) }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )
            },
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (!isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Password",

                        )
                }
            }

        )

        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        Button(
            onClick = { *//*handleLogin()*//* },

            modifier = Modifier.padding(top = 5.dp)
        ) {
            Text(text = "Login")


        }
        Row {
            TextButton(onClick = {*//*handleRegisterClick()*//* }
            )
            { Text(text = "Register") }
            TextButton(onClick = {*//*handleForgotPassword()*//* })

            {
                Spacer(modifier = Modifier.width(60.dp))
                Text(text = "Forget password?")
            }
        }
    }

}*/
