package com.sevengear.basic.core.mvp

import android.os.Bundle
import com.sevengear.basic.R

abstract class FullscreenMvpDialog(layoutResId: Int) : MvpDialog(layoutResId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
    }

}