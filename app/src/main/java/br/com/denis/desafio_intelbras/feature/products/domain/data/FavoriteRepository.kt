package br.com.denis.desafio_intelbras.feature.products.domain.data

import br.com.denis.desafio_intelbras.feature.products.domain.data.local.FavoriteDataStore
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val dataStore: FavoriteDataStore) {

    fun getFavorites(): Flow<Set<Int>> = dataStore.favorites

    suspend fun toggleFavorite(productId: Int) {
        dataStore.toggleFavorite(productId)
    }
}
