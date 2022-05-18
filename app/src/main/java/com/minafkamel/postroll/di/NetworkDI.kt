package com.minafkamel.postroll.di

import android.os.Looper
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val networkModule = module {

    fun providesApolloClient(loggingInterceptor: HttpLoggingInterceptor): ApolloClient {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Only the main thread can get the apolloClient instance"
        }

        val cacheFactory = MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        return ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .normalizedCache(cacheFactory)
            .build()
    }

    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    single { providesApolloClient(get()) }
    single { providesLoggingInterceptor() }

}

const val BASE_URL = "https://graphqlzero.almansi.me/api"
