package com.jmc.myutils.baselibrary.common

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.jmc.myutils.baselibrary.injection.component.AppComponent
import com.jmc.myutils.baselibrary.injection.module.AppModule


class BaseApplication : MultiDexApplication() {

    lateinit var appComponent: AppComponent

    companion object {
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        context=this
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}