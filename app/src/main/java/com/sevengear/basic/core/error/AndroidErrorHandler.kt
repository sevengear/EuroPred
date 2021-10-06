package com.sevengear.basic.core.error

import android.content.Context
import com.google.gson.Gson
import com.sevengear.basic.R
import com.sevengear.basic.data.model.ErrorResponse
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AndroidErrorHandler @Inject constructor(
    private val context: Context
) : ErrorHandler {

    override fun convert(error: Throwable) =
        when (error) {
            is Error.NetworkError -> context.getString(R.string.error_network)
            is Error.ServerError -> context.getString(R.string.error_server)
            is HttpException -> getError(error)
            else -> context.getString(R.string.error_default)
        }

    private fun getError(error: HttpException): String {
        return try {
            Gson()
                .getAdapter(ErrorResponse::class.java)
                .fromJson(error.response()?.errorBody()?.string())
                .responseMessage
        } catch (e: IOException) {
            context.getString(R.string.error_default)
        }
    }

}