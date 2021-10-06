package com.sevengear.basic.core.mvp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment

abstract class MvpDialog(
    @LayoutRes private val layoutResId: Int
) : DialogFragment(), MvpView {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDependencies()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(layoutResId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUi()
        initPresenter()
    }

    abstract fun initPresenter()

    abstract fun initUi()

    abstract fun injectDependencies()

}