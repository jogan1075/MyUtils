package com.jmc.myutils.baselibrary.ui.fragment

import android.os.Bundle
import com.jmc.myutils.baselibrary.common.BaseApplication
import com.jmc.myutils.baselibrary.injection.component.ActivityComponent
import com.jmc.myutils.baselibrary.injection.module.ActivityModule
import com.jmc.myutils.baselibrary.injection.module.LifecycleProviderModule
import com.jmc.myutils.baselibrary.presenter.BasePresenter
import com.jmc.myutils.baselibrary.presenter.view.BaseView

import lrvik.xin.base.widget.ProgressLoading
import javax.inject.Inject

open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

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

        mLoadingDialog = ProgressLoading.create(activity!!)
    }

    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((activity!!.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity!!))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }

}