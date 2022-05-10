package com.minafkamel.postroll.di

import com.minafkamel.postroll.data.posts.PostApi
import com.minafkamel.postroll.data.users.UsersApi
import org.koin.dsl.module

val apiModule = module {

    single { PostApi(get()) }
    single { UsersApi(get()) }
}
