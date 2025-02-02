package br.com.denis.desafio_intelbras.core.remote

import br.com.denis.desafio_intelbras.feature.products.framework.api.ServiceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://fakestoreapi.com/"

object RetrofitInstance {
    val api: ServiceAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ServiceAPI::class.java)
}