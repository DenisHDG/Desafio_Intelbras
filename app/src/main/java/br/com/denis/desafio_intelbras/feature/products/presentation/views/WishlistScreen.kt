package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.denis.desafio_intelbras.ui.component.MyScreenContent

@Composable
fun WishlistScreen(navController: NavController) {
    MyScreenContent()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Lista de Desejos")
    }
}