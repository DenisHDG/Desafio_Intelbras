package br.com.denis.desafio_intelbras.feature.products.domain.data


import br.com.denis.desafio_intelbras.feature.products.framework.api.ServiceAPI
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product

class ProductsRepository(
    private val productApi: ServiceAPI
) {
    suspend fun getProductsByCategory(category: String): List<Product> {
        return productApi.getProductsByCategory(category)
    }
}
