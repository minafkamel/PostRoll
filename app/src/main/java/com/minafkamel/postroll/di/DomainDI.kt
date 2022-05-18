package com.minafkamel.postroll.di

import org.koin.dsl.module

val domainModule = module {
    factory { com.minafkamel.postroll.domain.GetPosts(get()) }
    factory { com.minafkamel.postroll.domain.GetPostDetails(get()) }
}