package com.sevengear.basic.core.error

interface ErrorHandler {
    fun convert(error: Throwable): String
}