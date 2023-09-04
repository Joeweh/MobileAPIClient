package com.github.joeweh.mobileapiclient.ui.register

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.github.joeweh.mobileapiclient.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Preview(showSystemUi = true)
@Composable
fun RegisterPreview() {
    AppTheme(
        useDarkTheme = true
    ) {
        Surface {
            RegisterScreen(navController = rememberNavController())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {

    var emailFieldState by remember {
        mutableStateOf("")
    }

    var pwFieldState by remember {
        mutableStateOf("")
    }

    var confirmPwFieldState by remember {
        mutableStateOf("")
    }

    val viewModel = viewModel { RegisterViewModel() }

    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Sign Up",
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

        OutlinedTextField(
            value = confirmPwFieldState,
            label = {
                Text("Confirm Password")
            },
            onValueChange = {
                confirmPwFieldState = it
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
                viewModel.viewModelScope.launch {
                    viewModel.register(emailFieldState, pwFieldState)
                }

                navController.navigate("home")
            },
            contentPadding = PaddingValues(horizontal = 50.dp, vertical = 20.dp)
        ) {
            Text(
                "Sign Up",
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
            Text("Already Have An Account?")
            TextButton(onClick = {
                navController.navigate("login")
            },
            ) {
                Text(
                    "Sign In",
                    fontSize = 15.sp,
                    letterSpacing = 1.5.sp
                )
            }
        }
    }
}
