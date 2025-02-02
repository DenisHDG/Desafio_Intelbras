package br.com.denis.desafio_intelbras.feature.products.di

import br.com.denis.desafio_intelbras.feature.products.domain.data.CategoryRepository
import br.com.denis.desafio_intelbras.feature.products.domain.data.ProductsRepository
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.FetchProductsByCategoryUseCase
import br.com.denis.desafio_intelbras.feature.products.domain.usecases.GetCategoriesUseCase
import br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel.CategoryViewModel
import br.com.denis.desafio_intelbras.feature.products.presentation.viewmodel.ProductViewModel
import br.com.denis.desafio_intelbras.remote.RetrofitInstance
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val dataModule = module {

    single { RetrofitInstance.api }

    single { CategoryRepository(get()) }
    single { ProductsRepository(get()) }

}

private val useCaseModule = module {

    single { GetCategoriesUseCase(get()) }
    single { FetchProductsByCategoryUseCase(get()) }

}

private val presentationModule = module {

    viewModel { CategoryViewModel(get()) }
    viewModel { ProductViewModel(get()) }
}

fun getProductsAppModule() = listOf(dataModule, useCaseModule, presentationModule)