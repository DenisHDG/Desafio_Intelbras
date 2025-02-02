package br.com.denis.desafio_intelbras.feature.products.domain.usecases

import br.com.denis.desafio_intelbras.feature.products.domain.data.ProductsRepository
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product


class FetchProductsByCategoryUseCase(
    private val productsRepository: ProductsRepository
) {

    suspend fun execute(category: String): List<Product> {
        return productsRepository.getProductsByCategory(category)
    }
}
