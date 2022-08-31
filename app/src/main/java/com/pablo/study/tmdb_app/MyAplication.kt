package com.pablo.study.tmdb_app

import android.app.Application
import com.pablo.study.tmdb_app.di.listmodules.listModule
import com.pablo.study.tmdb_app.di.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyAplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin with moduleA & moduleB
        startKoin {
            // declare used Android context
            androidContext(this@MyAplication)
            // declare modules
            modules(
                networkModule,
                listModule
            )
        }
    }
}