package com.minafkamel.postroll.di

import com.minafkamel.postroll.domain.GetPostDetails
import com.minafkamel.postroll.domain.GetPostsWithTitleAndBody
import org.koin.dsl.module

val domainModule = module {
    factory { GetPostsWithTitleAndBody(get()) }
    factory { GetPostDetails(get()) }
}