package com.sevengear.basic.ui.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import com.sevengear.basic.App
import com.sevengear.basic.core.error.AndroidErrorHandler
import com.sevengear.basic.core.error.ErrorHandler
import com.sevengear.basic.core.thread.AndroidExecutor
import com.sevengear.basic.core.thread.Executor
import javax.inject.Singleton

@Module
class AppModule(private val application: App) {
    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler = AndroidErrorHandler(application)

    @Provides
    @Singleton
    fun provideExecutor(): Executor = AndroidExecutor()

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().serializeNulls().create()

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = EncryptedSharedPreferences.create(
        "secret_shared_prefs",
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
        provideContext(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}