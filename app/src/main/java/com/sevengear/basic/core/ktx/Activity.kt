package com.sevengear.basic.core.ktx

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * [Activity] extensions
 */

fun Activity.hideKeyboard(focusableView: View? = null) {
    (focusableView ?: currentFocus)?.let {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Activity.openAppSetting(requestCode: Int) {
    val intent = Intent().apply {
        data = Uri.fromParts("package", packageName, null)
        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    }
    startActivityForResult(intent, requestCode)
}