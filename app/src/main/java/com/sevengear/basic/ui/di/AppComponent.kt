package com.sevengear.basic.ui.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Component
import com.sevengear.basic.App
import com.sevengear.basic.core.error.ErrorHandler
import com.sevengear.basic.core.thread.Executor
import com.sevengear.basic.data.api.LottoApi
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, NetworkModule::class]
)
interface AppComponent {
    fun inject(app: App)

    fun lottoApi(): LottoApi
    fun context(): Context
    fun errorHandler(): ErrorHandler
    fun executor(): Executor
    fun sharedPreferences(): SharedPreferences
}