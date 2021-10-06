package com.sevengear.basic

import android.app.Application
import com.sevengear.basic.ui.di.AppComponent
import com.sevengear.basic.ui.di.AppModule
import com.sevengear.basic.ui.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        val appModule = AppModule(this)
        DaggerAppComponent
            .builder()
            .appModule(appModule)
            .build()
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
    }

}