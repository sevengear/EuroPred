package com.sevengear.basic.core.interceptor

import android.content.Context
import com.sevengear.basic.core.error.Error
import com.sevengear.basic.core.ktx.isOnline
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import java.io.IOException
import java.net.SocketTimeoutException
import kotlin.jvm.Throws

/**
 * An interceptor that checks if the device is online and the timeout for webservices connections.
 */
class NetworkInterceptor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        if (context.isOnline()) {
            return try {
                val request = chain.request()
                chain.proceed(request)
            } catch (e: SocketTimeoutException) {
                throw Error.ServerError
            }
        }
        throw Error.NetworkError
    }

}