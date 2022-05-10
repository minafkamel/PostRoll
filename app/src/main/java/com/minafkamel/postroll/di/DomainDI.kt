package com.minafkamel.postroll.di

import com.minafkamel.postroll.domain.GetPostDetails
import com.minafkamel.postroll.domain.GetPosts
import org.koin.dsl.module

val domainModule = module {
    factory { GetPosts(get()) }
    factory { GetPostDetails(get()) }
}