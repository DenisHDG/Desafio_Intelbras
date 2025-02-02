package br.com.denis.desafio_intelbras.feature.products.domain.usecases

import br.com.denis.desafio_intelbras.feature.products.domain.data.CategoryRepository

class GetCategoriesUseCase(private val repository: CategoryRepository) {
    suspend operator fun invoke(): List<String> = repository.getCategories()
}