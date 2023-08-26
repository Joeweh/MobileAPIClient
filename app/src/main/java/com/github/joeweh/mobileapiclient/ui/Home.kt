package com.github.joeweh.mobileapiclient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.github.joeweh.mobileapiclient.ui.theme.AppTheme

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    AppTheme(
        useDarkTheme = true
    ) {
        Surface {
            HomeScreen(navController = rememberNavController())
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Home",
            fontSize = 40.sp,
        )
    }
}