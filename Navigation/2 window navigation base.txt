// This is a working 2 window navigation project in kotlin using Jetpack Compose
package com.example.*project_name_here // * = project name, you don't have to change this line, if you don't copy/paste over this line, after creating a new .kt file

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
// import com.example.*project_name_here.ui.theme.*Project_Name_HereTheme   // Android studio should create a working version of this automatically when you update Project_Name_HereTheme on MainActivity, 
                                                                            //but if not, you have to fix this manually

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project_Name_HereTheme { // HOX! Change the theme name to your project name
                Navigation() // Call Navigation funcion
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, onNavigateToGreeting2: () -> Unit) {
    rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Data App") },
                navigationIcon = {
                    Button(onClick = onNavigateToGreeting2) {
                        Text(text = "Next")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue, // TopAppBar background color
                    titleContentColor = Color.White // Title text color
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Welcome to $name!")
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") {
            Greeting(
                name = "First",
                onNavigateToGreeting2 = {
                    navController.navigate("screen2")
                }
            )
        }
        composable("screen2") {
            Greeting2(
                name = "Android",
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project_Name_HereTheme { // HOX! Change the theme name to your project name
        Greeting(
            "First",
            onNavigateToGreeting2 = {} // Empty lambda fixes red squiggly line
        )
    }
}

// ----------- Second Page -----------
//- In this example, the 2nd window function is located on separate .kt file 

package com.example.*project_name_here.ui.theme // * = project name, you don't have to change this line, if you don't copy/paste over this line, after creating a new .kt file

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2(name: String, onNavigateBack: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Data App") },
                navigationIcon = {
                    Button(onClick = onNavigateBack) {
                        Text(text = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue, // TopAppBar background color
                    titleContentColor = Color.White // Title text color
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hello, $name!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting2Preview() {
    Project_Name_HereTheme { // HOX! Change the theme name to your project name
        Greeting2(
            "Second",
            onNavigateBack = {}
        )
    }
}