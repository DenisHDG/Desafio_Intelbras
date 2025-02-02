package br.com.denis.desafio_intelbras.feature.products.domain.data

import br.com.denis.desafio_intelbras.feature.products.framework.api.ServiceAPI
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product

class ProductDetailRepository(private val apiService: ServiceAPI) {
    suspend fun getProductDetail(productId: Int): Product {
        return apiService.getProductDetail(productId)
    }
}