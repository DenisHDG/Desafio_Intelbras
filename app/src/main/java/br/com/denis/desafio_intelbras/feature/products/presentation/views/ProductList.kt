package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product
import br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel.ProductViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    categoryName: String,
    viewModel: ProductViewModel = koinViewModel(),
) {
    // Coleta os dados de produtos da ViewModel
    val products by viewModel.products.collectAsState()

    // Aciona a busca de produtos para a categoria selecionada
    LaunchedEffect(categoryName) {
        viewModel.fetchProductsByCategory(categoryName)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Produtos: $categoryName") })
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { /* Navegar para a tela de detalhes do produto */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = product.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Arrow Icon",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
    Divider()
}
