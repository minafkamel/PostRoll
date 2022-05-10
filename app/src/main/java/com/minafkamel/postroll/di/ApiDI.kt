package com.minafkamel.postroll.di

import com.minafkamel.postroll.data.PostApi
import org.koin.dsl.module

val apiModule = module {

    single { PostApi(get()) }
}
