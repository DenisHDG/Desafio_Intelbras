package br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.FavoriteUseCase
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.FetchProductsByCategoryUseCase
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val fetchProductsByCategoryUseCase: FetchProductsByCategoryUseCase,
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    val favorites = favoriteUseCase.getFavorites()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptySet())

    fun fetchProductsByCategory(category: String) {
        viewModelScope.launch {
            val fetchedProducts = fetchProductsByCategoryUseCase.execute(category)
            _products.value = fetchedProducts
        }
    }

    fun toggleFavorite(productId: Int) {
        viewModelScope.launch {
            favoriteUseCase.toggleFavorite(productId)
        }
    }
}
