package br.com.denis.desafio_intelbras.feature.products.domain.data

import br.com.denis.desafio_intelbras.feature.products.framework.api.ServiceAPI

class CategoryRepository(private val apiService: ServiceAPI) {
    suspend fun getCategories(): List<String> = apiService.getCategories()
}