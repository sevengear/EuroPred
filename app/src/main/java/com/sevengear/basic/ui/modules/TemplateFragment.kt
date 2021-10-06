package com.sevengear.basic.ui.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.sevengear.basic.core.mvp.MvpFragment

abstract class TemplateFragment(@LayoutRes layoutResId: Int) : MvpFragment(layoutResId),
    TemplateView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}