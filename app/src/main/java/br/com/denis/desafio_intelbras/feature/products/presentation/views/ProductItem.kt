package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product

@Composable
fun ProductItem(
    product: Product,
    isFavorite: Boolean,
    onFavoriteClick: (Int) -> Unit, // ou (Int) ou (Product) dependendo da sua assinatura
    onItemClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onItemClick(product.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = product.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { onFavoriteClick(product.id) }) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Favorite Icon"
            )
        }
    }
    HorizontalDivider()
}

