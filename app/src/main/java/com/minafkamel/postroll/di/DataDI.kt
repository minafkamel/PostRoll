package com.minafkamel.postroll.di

import com.minafkamel.postroll.data.posts.PostsMemoryDataSource
import com.minafkamel.postroll.data.posts.PostsRemoteDataSource
import com.minafkamel.postroll.data.posts.PostsRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { PostsRepository(get(), get()) }
}

val dataSourcesModule = module {

    single { com.minafkamel.postroll.data.Cache() }

    single { PostsRemoteDataSource(get()) }
    single { PostsMemoryDataSource(get()) }
}

