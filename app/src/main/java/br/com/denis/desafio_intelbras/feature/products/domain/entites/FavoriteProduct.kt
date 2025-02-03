package br.com.denis.desafio_intelbras.feature.products.domain.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "favorite_products")
data class FavoriteProduct(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val category: String,
    val image: String
)
