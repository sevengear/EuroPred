package com.sevengear.basic.core.ktx

import com.google.android.material.textfield.TextInputLayout

/**
 * [TextInputLayout] extensions
 */
fun TextInputLayout?.safeValue() = this?.editText?.text?.toString() ?: ""