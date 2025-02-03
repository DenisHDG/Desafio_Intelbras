package br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.denis.desafio_intelbras.feature.products.domain.entites.FavoriteProduct
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.FavoriteUseCaseRoom
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.FetchProductsByCategoryUseCase
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.GetProductDetailUseCase
import br.com.denis.desafio_intelbras.feature.products.framework.models.Product
import br.com.denis.desafio_intelbras.feature.products.framework.models.toFavoriteProduct
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDetailsViewModel(
    private val fetchProductsByCategoryUseCase: FetchProductsByCategoryUseCase,
    private val getProductDetailUseCase: GetProductDetailUseCase,
    private val favoriteUseCase: FavoriteUseCaseRoom
) : ViewModel() {

    private val _productDetail = MutableStateFlow<Product?>(null)
    val productDetail: StateFlow<Product?> = _productDetail

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _favorites = MutableStateFlow<List<FavoriteProduct>>(emptyList())
    val favorites: StateFlow<List<FavoriteProduct>> = _favorites

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favoriteUseCase.getFavorites().first()
            withContext(Dispatchers.Main) {
                _favorites.value = result
            }
        }
    }

    fun fetchProductsByCategory(category: String) {
        viewModelScope.launch {
            try {
                val fetchedProducts = fetchProductsByCategoryUseCase.execute(category)
                _products.value = fetchedProducts
            } catch (e: Exception) {
                // Trate erros aqui
            }
        }
    }

    fun toggleFavorite(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteUseCase.toggleFavorite(product.toFavoriteProduct())
            getFavorites()
        }
    }

    fun isFavorite(product: Product): Boolean {
        return favorites.value.any { it.id == product.id }
    }

    fun fetchProductDetails(productId: Int) {
        viewModelScope.launch {
            try {
                val product = getProductDetailUseCase.invoke(productId)
                _productDetail.value = product
            } catch (e: Exception) {
                // Trate erros aqui
            }
        }
    }
}
