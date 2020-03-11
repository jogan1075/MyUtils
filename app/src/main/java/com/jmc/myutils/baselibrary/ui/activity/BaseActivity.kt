package com.jmc.myutils.baselibrary.ui.activity

import android.os.Bundle
import com.jmc.myutils.baselibrary.common.AppManger
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity


open class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManger.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManger.instance.finishActivity(this)
    }
}