package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    // Coletando os favoritos e produtos
    val products by viewModel.products.collectAsState(initial = emptyList())  // Lista de produtos
    val favorites by viewModel.favorites.collectAsState(initial = emptyList())  // Lista de favoritos

    LaunchedEffect(categoryName) {
        viewModel.fetchProductsByCategory(categoryName)  // Fetch dos produtos com base na categoria
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Produtos: $categoryName") })
    }) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            // Iterando sobre os produtos e mostrando a lista
            items(products) { product ->
                // Aqui, a lista de favoritos é mapeada para os IDs para facilitar a comparação
                val favoriteIds = favorites.map { it.id }

                ProductItem(
                    product = product,
                    isFavorite = favoriteIds.contains(product.id),  // Verifica se o produto está nos favoritos
                    onFavoriteClick = { viewModel.toggleFavorite(product) },
                    onItemClick = { id -> navController.navigate("product_detail_rout/$id") }
                )
            }
        }
    }
}
