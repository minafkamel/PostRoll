package com.minafkamel.postroll.di

import com.minafkamel.postroll.data.posts.PostsRemoteDataSource
import com.minafkamel.postroll.data.posts.PostsRepository
import org.koin.dsl.module


val repositoryModule = module {

    single { PostsRepository(get()) }
}

val dataSourcesModule = module {

    single { PostsRemoteDataSource(get()) }
}
