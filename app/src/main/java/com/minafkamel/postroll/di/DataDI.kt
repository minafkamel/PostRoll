package com.minafkamel.postroll.di

import com.minafkamel.postroll.data.PostsRemoteDataSource
import com.minafkamel.postroll.data.PostsRepository
import org.koin.dsl.module


val repositoryModule = module {

    single { PostsRepository(get()) }
}

val dataSourcesModule = module {

    single { PostsRemoteDataSource(get()) }
}
