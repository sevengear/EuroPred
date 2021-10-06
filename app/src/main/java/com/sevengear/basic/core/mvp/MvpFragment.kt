package com.sevengear.basic.core.mvp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class MvpFragment(
    @LayoutRes layoutResId: Int,
    private val redraw: Boolean = true
) : Fragment(layoutResId), MvpView {

    private var root: View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDependencies()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        if (redraw || root == null) {
            root = null
            super.onCreateView(inflater, container, savedInstanceState)
        } else {
            root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (root == null) {
            root = view
            initUi()
        }
        initPresenter()
    }

    abstract fun initPresenter()

    abstract fun initUi()

    abstract fun injectDependencies()

}