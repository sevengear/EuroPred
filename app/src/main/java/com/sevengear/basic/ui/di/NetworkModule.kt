package com.sevengear.basic.ui.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import com.sevengear.basic.data.api.LottoApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideLottoApi(retrofit: Retrofit): LottoApi = retrofit.create(LottoApi::class.java)

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(getLogInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.loteriasyapuestas.es/servicios/")
            .client(client)
            .addCallAdapterFactory(getRetrofitCallAdapter())
            .addConverterFactory(getRetrofitConverter(gson))
            .build()

    private fun getLogInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = //if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        /*} else {
            HttpLoggingInterceptor.Level.NONE
        }*/
    }

    private fun getRetrofitCallAdapter() = RxJava2CallAdapterFactory.create()

    private fun getRetrofitConverter(gson: Gson) = GsonConverterFactory.create(gson)
}