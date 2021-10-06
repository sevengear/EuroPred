package com.sevengear.basic.core.ktx

import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.sevengear.basic.R
import com.sevengear.basic.core.widget.AlertColor
import com.google.android.material.snackbar.Snackbar

/**
 * [Snackbar] extensions
 */
fun Snackbar.config(color: AlertColor) = apply {
    // Background
    view.background = ContextCompat.getDrawable(
        context, when (color) {
            AlertColor.Default -> R.drawable.bg_snackbar
            AlertColor.Error -> R.drawable.bg_snackbar_error
            AlertColor.Success -> R.drawable.bg_snackbar_success
            AlertColor.Warning -> R.drawable.bg_snackbar_warning
        }
    )
    // Text style
    view.findViewById<TextView>(R.id.snackbar_text)?.run {
        val textColor = ContextCompat.getColor(
            context, when (color) {
                AlertColor.Default -> R.color.colorOnPrimary
                AlertColor.Error -> R.color.colorOnError
                AlertColor.Success -> R.color.colorOnSuccess
                AlertColor.Warning -> R.color.colorOnError
            }
        )
        setTextColor(textColor)
    }
    // Margin and elevation
    val margin = view.resources.getDimensionPixelSize(R.dimen.snackbar_margin)
    (view.layoutParams as ViewGroup.MarginLayoutParams).setMargins(margin, margin, margin, margin)
    val elevation = view.resources.getDimensionPixelSize(R.dimen.snackbar_elevation).toFloat()
    ViewCompat.setElevation(view, elevation)
    // Disable behavior
    view.addOnGlobalLayout {
        (view.layoutParams as? CoordinatorLayout.LayoutParams)?.behavior = null
    }
}

fun Snackbar.setAction(
    @StringRes textResId: Int,
    @ColorRes colorResId: Int,
    onClick: () -> Unit
): Snackbar {
    view.findViewById<TextView>(R.id.snackbar_action)?.run {
        val textColor = ContextCompat.getColor(context, colorResId)
        setTextColor(textColor)
    }
    return setAction(context.getText(textResId)) { onClick() }
}