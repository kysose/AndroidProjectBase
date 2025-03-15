// This is a working 2 window navigation project in kotlin using Jetpack Compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teht4_webrev2.Screen2

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background // huom! colorScheme (monessa ohjeessa oli colors.background)
    ) {
        NavHost(navController = navController, startDestination = "screen1") {
            composable("screen1") {
                Screen1(onNavigateToScreen2 = {
                    navController.navigate("screen2")
                })
            }
            composable("screen2") {
                Screen2(onNavigateBack = {
                    navController.navigateUp()
                })
            }
        }
    }
}

@Composable
fun Screen1(onNavigateToScreen2: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 1")
        Button(
            onClick = onNavigateToScreen2,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Go to Screen 2")
        }
    }
}

// ----------- Second Page -----------
//- In this example, the 2nd window function is located on separate .kt file 

package com.example.* // * = project name, you don't have to change this line, if you don't copy/paste over this line, after creating a new .kt file

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen2(onNavigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 2")
        Button(
            onClick = onNavigateBack,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Go Back")
        }
    }
}