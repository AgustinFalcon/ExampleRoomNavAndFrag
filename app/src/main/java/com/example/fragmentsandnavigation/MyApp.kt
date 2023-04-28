package com.example.fragmentsandnavigation

import android.app.Application
import com.example.fragmentsandnavigation.data.UserDB

class MyApp: Application() {

    //val database: MyApp by lazy { this }

    companion object {
        lateinit var instance: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}