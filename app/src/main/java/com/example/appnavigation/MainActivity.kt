package com.example.appnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appnavigation.ui.theme.AppNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigationTheme {
                //Navegação gerenciada pelo NavHost
                NavigationApp()
            }
        }
    }
}


@Composable
fun NavigationApp(){
    // criar NavController para controlar a navegação
    val navController = rememberNavController()

    //Define o NavHost com os Destinos
    NavHost(navController = navController, startDestination = "home"){
        composable("home") { HomeScreen(navController)  }
        composable("details") { DetailsScreen(navController)  }
    }
}

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Tela Inicial", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("details/123") }) {
            Text(text = "Avançar")
        }
    }
}

@Composable
fun DetailsScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {

        Text(text = "Tela de detalhes", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    AppNavigationTheme {
        HomeScreen(navController = rememberNavController())
    }
}