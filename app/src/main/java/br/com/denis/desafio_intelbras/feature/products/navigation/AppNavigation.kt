package br.com.denis.desafio_intelbras.feature.products.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.denis.desafio_intelbras.feature.products.presentation.views.HomeScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("home") {
            HomeScreen()
        }
    }
}