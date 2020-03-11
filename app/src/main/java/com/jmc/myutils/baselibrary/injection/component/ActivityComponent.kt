package com.jmc.myutils.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.jmc.myutils.baselibrary.injection.ActivityScope
import com.jmc.myutils.baselibrary.injection.module.ActivityModule
import com.jmc.myutils.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component



@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class,
    LifecycleProviderModule::class))
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
    fun providesLifecycleProvider(): LifecycleProvider<*>
}