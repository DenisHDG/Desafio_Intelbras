package br.com.denis.desafio_intelbras.feature.products.domain.usecases

import br.com.denis.desafio_intelbras.feature.products.domain.data.ProductDetailRepository
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product

class GetProductDetailUseCase(
    private val productRepository: ProductDetailRepository
) {
    suspend operator fun invoke(productId: Int): Product {
        return productRepository.getProductDetail(productId)
    }
}
