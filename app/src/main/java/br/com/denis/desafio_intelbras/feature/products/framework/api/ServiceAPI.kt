package br.com.denis.desafio_intelbras.feature.products.framework.api

import br.com.denis.desafio_intelbras.feature.products.framework.models.Product
import retrofit2.http.GET
import retrofit2.http.Path

const val GET_CATEGORIES = "products/categories"
const val GET_PRODUCTS = "products/category/"

interface ServiceAPI {

    @GET(GET_CATEGORIES)
    suspend fun getCategories(): List<String>

    @GET("$GET_PRODUCTS{category}")
    suspend fun getProductsByCategory(@Path("category") category: String): List<Product>
}