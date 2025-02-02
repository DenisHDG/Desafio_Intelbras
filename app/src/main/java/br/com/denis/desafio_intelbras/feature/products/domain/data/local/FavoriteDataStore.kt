package br.com.denis.desafio_intelbras.feature.products.domain.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("favorites_prefs")

class FavoriteDataStore(private val context: Context) {
    private val FAVORITES_KEY = stringSetPreferencesKey("favorites")

    // Fluxo que converte o Set<String> em Set<Int>
    val favorites: Flow<Set<Int>> = context.dataStore.data.map { preferences ->
        preferences[FAVORITES_KEY]?.map { it.toInt() }?.toSet() ?: emptySet()
    }

    // Função para adicionar/remover favoritos
    suspend fun toggleFavorite(productId: Int) {
        context.dataStore.edit { preferences ->
            val currentFavorites = preferences[FAVORITES_KEY]?.toMutableSet() ?: mutableSetOf()
            val idAsString = productId.toString()

            if (currentFavorites.contains(idAsString)) {
                currentFavorites.remove(idAsString)
            } else {
                currentFavorites.add(idAsString)
            }
            preferences[FAVORITES_KEY] = currentFavorites
        }
    }
}
