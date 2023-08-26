package com.github.joeweh.mobileapiclient

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.joeweh.mobileapiclient.ui.CreateAccountScreen
import com.github.joeweh.mobileapiclient.ui.HomeScreen
import com.github.joeweh.mobileapiclient.ui.LoginScreen
import com.github.joeweh.mobileapiclient.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme(

            ) {
                Surface {
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") { LoginScreen(navController) }
                        composable("createaccount") { CreateAccountScreen(navController) }
                        composable("home") { HomeScreen(navController) }
                    }
                }
            }
        }
    }
}