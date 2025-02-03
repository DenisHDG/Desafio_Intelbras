package br.com.denis.desafio_intelbras.feature.products.domain.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.denis.desafio_intelbras.feature.products.domain.entites.FavoriteProduct

@Database(
    entities = [FavoriteProduct::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteProductDao(): FavoriteProductDao
}
