package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import br.com.denis.desafio_intelbras.feature.products.domain.entites.FavoriteProduct
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product
import br.com.denis.desafio_intelbras.feature.products.framework.models.Rating
import br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel.ProductDetailsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(
    navController: NavHostController,
    viewModel: ProductDetailsViewModel = koinViewModel()
) {
    // Coletando os favoritos e os produtos de forma reativa
    val favorites by viewModel.favorites.collectAsState(initial = emptyList())  // Coleta os favoritos do ViewModel
    val products by viewModel.products.collectAsState(initial = emptyList())  // Coleta os produtos

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favoritos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { padding ->
        if (favorites.isEmpty()) {
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Nenhum produto favorito.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(favorites) { favoriteProduct ->
                    // Aqui converte FavoriteProduct para Product antes de passar para ProductItem
                    ProductItem(
                        product = favoriteProduct.toProduct(),
                        isFavorite = true,
                        onFavoriteClick = { viewModel.toggleFavorite(favoriteProduct.toProduct()) },
                        onItemClick = { navController.navigate("product_detail_rout/${favoriteProduct.id}") }
                    )
                }
            }
        }
    }
}


fun FavoriteProduct.toProduct(): Product {
    return Product(
        id = this.id,
        title = this.title,
        description = this.description,
        price = this.price,
        category = this.category,
        image = this.image,
        rating = Rating(
            rate = null,  // Substitua por valores reais, se necessário
            count = null  // Substitua por valores reais, se necessário
        )
    )
}
