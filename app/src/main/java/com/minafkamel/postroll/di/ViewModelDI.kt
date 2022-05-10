package com.minafkamel.postroll.di

import com.minafkamel.postroll.ui.allposts.AllPostsViewModel
import com.minafkamel.postroll.ui.allposts.PostMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AllPostsViewModel(get(), get()) }

    single { PostMapper() }
}
