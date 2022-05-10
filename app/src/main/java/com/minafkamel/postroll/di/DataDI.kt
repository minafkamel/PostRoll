package com.minafkamel.postroll.di

import com.minafkamel.postroll.data.posts.PostsRemoteDataSource
import com.minafkamel.postroll.data.posts.PostsRepository
import com.minafkamel.postroll.data.users.UsersRemoteDataSource
import com.minafkamel.postroll.data.users.UsersRepository
import org.koin.dsl.module


val repositoryModule = module {

    single { PostsRepository(get()) }
    single { UsersRepository(get()) }
}

val dataSourcesModule = module {

    single { PostsRemoteDataSource(get()) }
    single { UsersRemoteDataSource(get()) }
}
