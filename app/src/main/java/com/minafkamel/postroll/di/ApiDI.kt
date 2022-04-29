package com.minafkamel.postroll.di

import com.apollographql.apollo3.ApolloClient
import com.minafkamel.postroll.data.models.PostApi
import org.koin.dsl.module

val apiModule = module {

    fun providesApi(apolloClient: ApolloClient): PostApi {
        return PostApi(apolloClient)
    }

    single { providesApi(get()) }
}
