package br.com.denis.desafio_intelbras.feature.products.domain.usecases

import br.com.denis.desafio_intelbras.feature.products.domain.data.FavoriteRepositoryRoom
import br.com.denis.desafio_intelbras.feature.products.domain.entites.FavoriteProduct
import kotlinx.coroutines.flow.Flow

class FavoriteUseCaseRoom(private val repository: FavoriteRepositoryRoom) {

    fun getFavorites(): Flow<List<FavoriteProduct>> = repository.getFavorites()

    suspend fun toggleFavorite(product: FavoriteProduct) {
        repository.toggleFavorite(product)
    }
}