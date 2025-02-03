package br.com.denis.desafio_intelbras.feature.products.domain.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.denis.desafio_intelbras.feature.products.domain.entites.FavoriteProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteProductDao {

    @Query("SELECT * FROM favorite_products")
    fun getFavorites(): Flow<List<FavoriteProduct>>

    @Query("SELECT * FROM favorite_products WHERE id = :id LIMIT 1")
    fun getFavoriteById(id: Int): FavoriteProduct?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(product: FavoriteProduct): Long

    @Delete
    suspend fun deleteFavorite(product: FavoriteProduct): Int
}
