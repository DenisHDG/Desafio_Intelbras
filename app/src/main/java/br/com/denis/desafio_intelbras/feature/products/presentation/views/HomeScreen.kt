package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.denis.desafio_intelbras.feature.products.navigation.ROUT_CATEGORIES
import br.com.denis.desafio_intelbras.feature.products.navigation.ROUT_WISHLIST
import br.com.denis.desafio_intelbras.ui.component.MyScreenContent

@Composable
fun HomeScreen(navController: NavController) {

    MyScreenContent()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate(ROUT_CATEGORIES) }) {
                Text(text = "Listar Categorias")
            }

            Button(onClick = { navController.navigate(ROUT_WISHLIST) }) {
                Text(text = "Lista de Desejos")
            }
        }
    }
}