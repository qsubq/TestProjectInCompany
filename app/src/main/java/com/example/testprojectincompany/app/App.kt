package com.example.testprojectincompany.app

import android.app.Application
import android.util.Log
import com.example.testprojectincompany.app.di.AppComponent
import com.example.testprojectincompany.app.di.DaggerAppComponent

class App : Application(){

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        Log.e("maksim", "Application created")

        appComponent = DaggerAppComponent.builder().context(this).build()
    }
}
