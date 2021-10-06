package com.sevengear.basic.core.ktx

import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * [String] extensions
 */

fun String.isValidEmail(): Boolean {
    return Pattern.compile(
        "[a-zA-Z0-9\\u00f1\\u00d1\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    ).matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return this.length in 9..63
}

fun String.getAge(): Int {
    var age = 0
    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:Z", Locale.getDefault()).parse(this).let {
        val now = Calendar.getInstance()
        val dob = Calendar.getInstance()
        dob.time = it
        if (dob.after(now)) {
            return age
        }
        val year1 = now.get(Calendar.YEAR)
        val year2 = dob.get(Calendar.YEAR)
        age = year1 - year2
        val month1 = now.get(Calendar.MONTH)
        val month2 = dob.get(Calendar.MONTH)
        if (month2 > month1) {
            age--
        }
        if (month1 == month2) {
            val day1 = now.get(Calendar.DAY_OF_MONTH)
            val day2 = dob.get(Calendar.DAY_OF_MONTH)
            if (day2 > day1) {
                age--
            }
        }
    }
    return age
}

fun String.withoutAccents() = this
    .replace("á", "a")
    .replace("é", "e")
    .replace("í", "i")
    .replace("ó", "o")
    .replace("ú", "u")
    .replace("ü", "u")