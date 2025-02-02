package br.com.denis.desafio_intelbras

import android.app.Application
import br.com.denis.desafio_intelbras.feature.products.di.getProductsAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(getProductsAppModule())
        }
    }
}