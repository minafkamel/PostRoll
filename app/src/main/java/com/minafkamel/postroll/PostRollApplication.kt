package com.minafkamel.postroll

import android.app.Application
import com.minafkamel.postroll.di.apiModule
import com.minafkamel.postroll.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PostRollApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@PostRollApplication)
            printLogger()
            modules(listOf(networkModule, apiModule))
        }
    }
}
