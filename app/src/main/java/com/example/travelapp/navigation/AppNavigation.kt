package com.example.travelapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.components.TravelAppTopBar
import com.example.travelapp.screens.*
import com.example.travelapp.ui.theme.TravelAppTheme

enum class Routes { Register, Login, Home, Bali, Paris, Singapore }

@Composable
fun AppNavigation() {
    val navCtrl = rememberNavController()
    val currBackStack by navCtrl.currentBackStackEntryAsState()
    val currDest = currBackStack?.destination?.route.toString()

    TravelAppTheme {
        Scaffold(topBar = {
            if (currDest in listOf(
                    Routes.Home,
                    Routes.Bali,
                    Routes.Paris,
                    Routes.Singapore
                ).map { it.name }
            ) TravelAppTopBar(logout = {
                navCtrl.navigate(Routes.Login.name) {
                    popUpTo(currDest) { inclusive = true }
                }
            })
        }) { contentPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                color = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface
            ) {

                NavHost(navController = navCtrl, startDestination = Routes.Login.name) {
                    composable(Routes.Register.name) {
                        RegisterScreen(goToLogin = {
                            navCtrl.navigate(Routes.Login.name) {
                                popUpTo(Routes.Register.name) {
                                    inclusive = true
                                }
                            }
                        })
                    }
                    composable(Routes.Login.name) {
                        LoginScreen(goToHome = {
                            navCtrl.navigate(Routes.Home.name) {
                                popUpTo(Routes.Login.name) {
                                    inclusive = true
                                }
                            }
                        }, goToRegister = {
                            navCtrl.navigate(Routes.Register.name) {
                                popUpTo(Routes.Login.name) {
                                    inclusive = true
                                }
                            }
                        })
                    }
                    composable(Routes.Home.name) {
                        HomeScreen(goToPlace = { place -> navCtrl.navigate(place) })
                    }
                    composable(Routes.Bali.name) {
                        BaliScreen()
                    }
                    composable(Routes.Paris.name) {
                        ParisScreen()
                    }
                    composable(Routes.Singapore.name) {
                        SingaporeScreen()
                    }
                }
            }
        }
    }
}

