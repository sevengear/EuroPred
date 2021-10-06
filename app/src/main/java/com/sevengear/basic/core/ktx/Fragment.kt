package com.sevengear.basic.core.ktx

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

/**
 * [Fragment] extensions
 */
fun Fragment.onBackClick(action: () -> Unit) {
    activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            action()
        }
    })
}

fun Fragment.hideKeyboard(focusableView: View?) {
    activity?.hideKeyboard(focusableView)
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}