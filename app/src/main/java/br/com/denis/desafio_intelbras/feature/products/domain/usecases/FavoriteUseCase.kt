package br.com.denis.desafio_intelbras.feature.products.domain.usecases

import br.com.denis.desafio_intelbras.feature.products.domain.data.FavoriteRepository


class FavoriteUseCase(private val repository: FavoriteRepository) {
    fun getFavorites() = repository.getFavorites()
    suspend fun toggleFavorite(productId: Int) = repository.toggleFavorite(productId)
}