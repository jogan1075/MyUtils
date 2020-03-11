package com.jmc.myutils.baselibrary.injection.component

import android.content.Context
import com.jmc.myutils.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}