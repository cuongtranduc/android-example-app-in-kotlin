package com.cuongtd.dessertpusher

import android.app.Application
import timber.log.Timber

class PusherApplication : Application() {
    companion object {
        fun getDessertsSold() : Int = 0
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}