package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel.ProductDetailsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    navController: NavHostController,
    categoryName: String,
    viewModel: ProductDetailsViewModel = koinViewModel(),
) {
    val products by viewModel.products.collectAsState(initial = emptyList())
    val favorites by viewModel.favorites.collectAsState(initial = emptyList())

    LaunchedEffect(categoryName) {
        viewModel.fetchProductsByCategory(categoryName)
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Produtos: $categoryName") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                }
            }
        )    }) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(products) { product ->
                val favoriteIds = favorites.map { it.id }

                ProductItem(
                    product = product,
                    isFavorite = favoriteIds.contains(product.id),
                    onFavoriteClick = { viewModel.toggleFavorite(product) },
                    onItemClick = { id -> navController.navigate("product_detail_rout/$id") }
                )
            }
        }
    }
}
