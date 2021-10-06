package com.sevengear.basic.core.ktx

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.core.content.ContextCompat

/**
 * [TextView] extensions
 */
fun TextView.clearIcons() {
    setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
    compoundDrawablePadding = 0
}

@SuppressLint("RestrictedApi")
fun TextView.setEndIcon(@DrawableRes iconResId: Int, @ColorRes colorResId: Int = 0, @DimenRes paddingResId: Int = 0) {
    val icon = AppCompatDrawableManager.get().getDrawable(context, iconResId)
    if (colorResId != 0) {
        val color = ContextCompat.getColor(context, colorResId)
        icon.setTint(color)
    }
    setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, icon, null)
    if (paddingResId != 0) {
        compoundDrawablePadding = resources.getDimensionPixelSize(paddingResId)
    }
}

@SuppressLint("RestrictedApi")
fun TextView.setStartIcon(@DrawableRes iconResId: Int, @ColorRes colorResId: Int = 0, @DimenRes paddingResId: Int = 0) {
    val icon = AppCompatDrawableManager.get().getDrawable(context, iconResId)
    if (colorResId != 0) {
        val color = ContextCompat.getColor(context, colorResId)
        icon.setTint(color)
    }
    setCompoundDrawablesRelativeWithIntrinsicBounds(icon, null, null, null)
    if (paddingResId != 0) {
        compoundDrawablePadding = resources.getDimensionPixelSize(paddingResId)
    }
}

@SuppressLint("RestrictedApi")
fun TextView.setTopIcon(@DrawableRes iconResId: Int, @ColorRes colorResId: Int = 0, @DimenRes paddingResId: Int = 0) {
    val icon = AppCompatDrawableManager.get().getDrawable(context, iconResId)
    if (colorResId != 0) {
        val color = ContextCompat.getColor(context, colorResId)
        icon.setTint(color)
    }
    setCompoundDrawablesRelativeWithIntrinsicBounds(null, icon, null, null)
    if (paddingResId != 0) {
        compoundDrawablePadding = resources.getDimensionPixelSize(paddingResId)
    }
}

@SuppressLint("RestrictedApi")
fun TextView.setBottomIcon(@DrawableRes iconResId: Int, @ColorRes colorResId: Int = 0, @DimenRes paddingResId: Int = 0) {
    val icon = AppCompatDrawableManager.get().getDrawable(context, iconResId)
    if (colorResId != 0) {
        val color = ContextCompat.getColor(context, colorResId)
        icon.setTint(color)
    }
    setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, icon)
    if (paddingResId != 0) {
        compoundDrawablePadding = resources.getDimensionPixelSize(paddingResId)
    }
}