package br.com.denis.desafio_intelbras.feature.products.domain.data

import br.com.denis.desafio_intelbras.feature.products.domain.data.local.FavoriteProductDao
import br.com.denis.desafio_intelbras.feature.products.domain.entites.FavoriteProduct
import kotlinx.coroutines.flow.Flow


class FavoriteRepositoryRoom(private val dao: FavoriteProductDao) {

    fun getFavorites(): Flow<List<FavoriteProduct>> = dao.getFavorites()

    suspend fun toggleFavorite(product: FavoriteProduct) {
        val existing = dao.getFavoriteById(product.id)

        if (existing == null) {
            dao.insertFavorite(product)
        } else {
            dao.deleteFavorite(existing)
        }
    }
}



