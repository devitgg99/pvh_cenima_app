package com.example.pvh_cenima.di

import com.example.pvh_cenima.common.constant.BaseUrl
import com.example.pvh_cenima.network.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    @Singleton
    @Provides
    fun provideBaseURL(): String {
        return BaseUrl.BaseUrl
    }

    /**
     * Provide Header interceptor for custom header
     */
    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return AuthInterceptor()
    }

    /**
     * Provides OkHttpClient with interceptors
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(
        headerInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
            .readTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }

    /**
     * Provides converter factory for retrofit
     */
    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    /**
     * Provides Retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofitClient(
        baseUrl: String,
        okhttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }
}