package com.jmc.myutils.baselibrary.ui.activity

import android.os.Bundle
import com.jmc.myutils.baselibrary.common.BaseApplication
import com.jmc.myutils.baselibrary.injection.component.ActivityComponent
import com.jmc.myutils.baselibrary.injection.module.ActivityModule
import com.jmc.myutils.baselibrary.injection.module.LifecycleProviderModule
import com.jmc.myutils.baselibrary.presenter.BasePresenter
import com.jmc.myutils.baselibrary.presenter.view.BaseView

import lrvik.xin.base.widget.ProgressLoading
import javax.inject.Inject

open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text: String) {
        toast(text)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        mLoadingDialog = ProgressLoading.create(this)
    }

    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }

}