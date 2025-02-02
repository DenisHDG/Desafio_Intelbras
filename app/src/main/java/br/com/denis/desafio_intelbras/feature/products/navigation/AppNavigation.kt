package br.com.denis.desafio_intelbras.feature.products.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.denis.desafio_intelbras.feature.products.presentation.views.CategoryListScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.HomeScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.SplashScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.WishlistScreen

const val ROUT_SPLASH = "splash_rout"
const val ROUT_HOME = "home_rout"
const val ROUT_CATEGORIES = "categories_rout"
const val ROUT_WISHLIST = "wishlist_rout"


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUT_SPLASH) {
        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }
        composable(ROUT_CATEGORIES) {
            CategoryListScreen(navController)
        }
        composable(ROUT_WISHLIST) {
            WishlistScreen(navController)
        }
    }
}