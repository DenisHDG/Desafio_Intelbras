package br.com.denis.desafio_intelbras.feature.products.di

import br.com.denis.desafio_intelbras.feature.products.domain.data.CategoryRepository
import br.com.denis.desafio_intelbras.feature.products.domain.data.ProductsRepository
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.FetchProductsByCategoryUseCase
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.GetCategoriesUseCase
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.GetProductDetailUseCase
import br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel.CategoryViewModel
import br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel.ProductDetailViewModel
import br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel.ProductDetailsViewModel
import br.com.denis.desafio_intelbras.core.remote.RetrofitInstance
import br.com.denis.desafio_intelbras.feature.products.domain.data.FavoriteRepository
import br.com.denis.desafio_intelbras.feature.products.domain.data.ProductDetailRepository
import br.com.denis.desafio_intelbras.feature.products.domain.data.local.FavoriteDataStore
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.FavoriteUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val dataModule = module {

    single { RetrofitInstance.api }

    single { CategoryRepository(get()) }
    single { ProductsRepository(get()) }
    single { ProductDetailRepository(get()) }
    single { FavoriteRepository(get()) }
    single { FavoriteDataStore(androidContext()) }


}

private val useCaseModule = module {

    single { GetCategoriesUseCase(get()) }
    single { FetchProductsByCategoryUseCase(get()) }
    single { GetProductDetailUseCase(get()) }
    single { FavoriteUseCase(get()) }

}

private val presentationModule = module {

    viewModel { CategoryViewModel(get()) }
    viewModel { ProductDetailsViewModel(get(), get()) }
    viewModel { ProductDetailViewModel(get()) }
}

fun getProductsAppModule() = listOf(dataModule, useCaseModule, presentationModule)