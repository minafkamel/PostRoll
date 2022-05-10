package com.minafkamel.postroll

import android.app.Application
import com.minafkamel.postroll.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PostRollApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@PostRollApplication)
            modules(
                listOf(
                    networkModule,
                    apiModule,
                    dataSourcesModule,
                    repositoryModule,
                    domainModule,
                    viewModelModule
                )
            )
        }
    }
}
