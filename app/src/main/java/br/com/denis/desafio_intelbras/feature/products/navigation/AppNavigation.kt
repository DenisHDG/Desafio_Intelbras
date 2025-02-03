package br.com.denis.desafio_intelbras.feature.products.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product
import br.com.denis.desafio_intelbras.feature.products.presentation.views.CategoryListScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.HomeScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.ProductDetailScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.ProductListScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.SplashScreen
import br.com.denis.desafio_intelbras.feature.products.presentation.views.WishlistScreen

const val ROUT_SPLASH = "splash_rout"
const val ROUT_HOME = "home_rout"
const val ROUT_CATEGORIES = "categories_rout"
const val ROUT_WISHLIST = "wishlist_rout"
const val ROUT_PRODUCT_LIST = "product_list_rout/{category}"
const val ROUT_PRODUCT_DETAIL = "product_detail_rout/{productId}"
const val CATEGORY = "category"
const val PRODUCT_ID = "productId"

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
            CategoryListScreen(
                navController = navController,
                onItemClick = { category ->
                    navController.navigate("product_list_rout/$category")
                }
            )
        }
        composable(ROUT_WISHLIST) {
            WishlistScreen(navController)
        }

        composable(ROUT_PRODUCT_LIST) { backStackEntry ->
            val category = backStackEntry.arguments?.getString(CATEGORY)
            category?.let { categoryName ->
                ProductListScreen(
                    navController = navController,
                    categoryName = categoryName
                )
            }
        }

        composable(ROUT_PRODUCT_DETAIL) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString(PRODUCT_ID)?.toInt()
            productId?.let { id ->
                ProductDetailScreen(
                    navController = navController,
                    productId = id
                )
            }
        }
    }
}
