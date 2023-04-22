package com.example.travelapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.travelapp.R
import com.example.travelapp.User
import com.example.travelapp.UserDatabaseHelper

@Composable
fun RegisterScreen(goToLogin: () -> Unit) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }
    var errMsg by remember { mutableStateOf("") }

    val databaseHelper = UserDatabaseHelper(LocalContext.current)
    val fm = LocalFocusManager.current

    fun handleRegister() {
        if (firstName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            errMsg = "Please fill all required fields"
            return
        }

        if (password != confirmPassword) {
            errMsg = "Password & Confirm Password must be same"
            return
        }

        val isExists = databaseHelper.getUserByUsername(username)
        if (isExists !== null) {
            errMsg = "User exists"
            return
        }

        val user = User(
            id = null,
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password
        )
        databaseHelper.insertUser(user)
        errMsg = "User registered successfully"
        goToLogin()

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
            text = "Hello, Welcome !",
            style = MaterialTheme.typography.h2,
        )
        Text(
            text = "Let's Plan Your Dream Trip",
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(10.dp))

        Image(painterResource(id = R.drawable.register_graphic), contentDescription = "")
        Text(
            style = MaterialTheme.typography.h3, text = "Register"
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First name*") },
            singleLine = true,
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { fm.moveFocus(FocusDirection.Down) }),
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last name") },
            singleLine = true,
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { fm.moveFocus(FocusDirection.Down) }),
        )

        OutlinedTextField(value = username,
            onValueChange = { username = it },
            label = { Text("Username*") },
            singleLine = true,
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { fm.moveFocus(FocusDirection.Down) }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "Username"
                )
            })

        OutlinedTextField(value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { fm.moveFocus(FocusDirection.Down) }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email, contentDescription = "Email"
                )
            })

        OutlinedTextField(value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (!isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { fm.moveFocus(FocusDirection.Down) }),
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
            })

        OutlinedTextField(value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            singleLine = true,
            visualTransformation = if (!isConfirmPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier
                .padding(10.dp)
                .width(280.dp),
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
                IconButton(onClick = {
                    isConfirmPasswordVisible = !isConfirmPasswordVisible
                }) {
                    Icon(
                        imageVector = if (!isConfirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Password Visibility",

                        )
                }
            })


        if (errMsg.isNotEmpty()) {
            Text(
                text = errMsg,
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        Button(
            onClick = { handleRegister() }, modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Text(
                modifier = Modifier.padding(top = 14.dp), text = "Have an account?"
            )
            TextButton(onClick = {
                goToLogin()
            })

            {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Log in")
            }
        }
    }

}