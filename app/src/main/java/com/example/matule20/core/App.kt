package com.example.matule20.core

import android.app.Application
import com.my.tracker.MyTracker
import dagger.hilt.android.HiltAndroidApp

private const val MY_TRACKER = "5236578263578327"
@HiltAndroidApp
class App: Application() {
    override fun onCreate(){
        super.onCreate()
        MyTracker.initTracker(MY_TRACKER, this)
        MyTracker.getTrackerConfig().bufferingPeriod = 30
    }
}