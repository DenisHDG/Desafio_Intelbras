package br.com.denis.desafio_intelbras.feature.products.framework.api

import br.com.denis.desafio_intelbras.feature.products.framework.models.Product
import retrofit2.http.GET
import retrofit2.http.Path

const val GET_CATEGORIES = "products/categories"
const val GET_PRODUCTS = "products/category/"
const val GET_DETAILS_PRODUCT = "products/"

const val ITEM_CATEGORY = "{category}"
const val ITEM_PRODUCT_ID = "{id}"

const val categoryPath = "category"
const val idProductPath = "id"

interface ServiceAPI {

    @GET(GET_CATEGORIES)
    suspend fun getCategories(): List<String>

    @GET("$GET_PRODUCTS$ITEM_CATEGORY")
    suspend fun getProductsByCategory(@Path(categoryPath) category: String): List<Product>

    @GET("$GET_DETAILS_PRODUCT$ITEM_PRODUCT_ID")
    suspend fun getProductDetail(@Path(idProductPath) productId: Int): Product

}