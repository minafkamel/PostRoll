package com.minafkamel.postroll.di

import android.os.Looper
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient
import org.koin.dsl.module

val networkModule = module {

    fun providesApolloClient(): ApolloClient {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Only the main thread can get the apolloClient instance"
        }
        val okHttpClient = OkHttpClient.Builder().build()
        return ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }
    single { providesApolloClient() }
}

const val BASE_URL = "https://graphqlzero.almansi.me/api"
