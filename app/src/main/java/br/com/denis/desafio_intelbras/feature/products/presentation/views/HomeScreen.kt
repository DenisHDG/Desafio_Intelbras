package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.denis.desafio_intelbras.ui.component.MyScreenContent

@Composable
fun HomeScreen() {

    MyScreenContent()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Tela Principal")
    }
}