package br.com.denis.desafio_intelbras.feature.products.domain.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


const val FAVORITE_KEY = "favorites"
const val FAVORITE_PREFS = "favorites_prefs"

private val Context.dataStore by preferencesDataStore(FAVORITE_PREFS)

class FavoriteDataStore(private val context: Context) {
    private val key = stringSetPreferencesKey(FAVORITE_KEY)

    val favorites: Flow<Set<Int>> = context.dataStore.data.map { preferences ->
        preferences[key]?.map { it.toInt() }?.toSet() ?: emptySet()
    }

    suspend fun toggleFavorite(productId: Int) {
        context.dataStore.edit { preferences ->
            val currentFavorites = preferences[key]?.toMutableSet() ?: mutableSetOf()
            val idAsString = productId.toString()

            if (currentFavorites.contains(idAsString)) {
                currentFavorites.remove(idAsString)
            } else {
                currentFavorites.add(idAsString)
            }
            preferences[key] = currentFavorites
        }
    }
}
