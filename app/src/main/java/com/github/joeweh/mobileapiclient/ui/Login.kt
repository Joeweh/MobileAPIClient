package com.github.joeweh.mobileapiclient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.github.joeweh.mobileapiclient.ui.theme.AppTheme
import com.github.joeweh.mobileapiclient.utils.HttpTest

@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    AppTheme(
        useDarkTheme = true
    ) {
        Surface {
            LoginScreen(navController = rememberNavController())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var emailFieldState by remember {
        mutableStateOf("")
    }

    var pwFieldState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Sign In",
            fontSize = 40.sp,
        )

        Spacer(
            modifier = Modifier
                .height(25.dp)
        )

        OutlinedTextField(
            value = emailFieldState,
            label = {
                Text("Email")
            },
            onValueChange = {
                emailFieldState = it
            },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        OutlinedTextField(
            value = pwFieldState,
            label = {
                Text("Password")
            },
            onValueChange = {
                pwFieldState = it
            },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
        )

        Spacer(
            modifier = Modifier
                .height(25.dp)
        )

        Button(
            onClick = {
                HttpTest.login(emailFieldState, pwFieldState)
                navController.navigate("home")
            },
            contentPadding = PaddingValues(horizontal = 50.dp, vertical = 20.dp)
        ) {
            Text(
                "Login",
                fontSize = 20.sp,
                letterSpacing = 1.5.sp
            )
        }

        Spacer(
            modifier = Modifier
                .height(25.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Don't Have An Account?")
            TextButton(onClick = {
                navController.navigate("createaccount")
            },
            ) {
                Text(
                    "Sign Up",
                    fontSize = 15.sp,
                    letterSpacing = 1.5.sp
                )
            }
        }
    }
}