package com.sevengear.basic.core.ktx

import android.content.Context
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager

/**
 * [View] extensions
 */
fun View.addOnGlobalLayout(action: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            action()
            viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
    })
}

fun View.hideKeyboard() {
    requestFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    inputMethodManager?.hideSoftInputFromWindow(windowToken, 0)
}