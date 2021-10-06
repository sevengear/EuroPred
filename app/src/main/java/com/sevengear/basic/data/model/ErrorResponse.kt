package com.sevengear.basic.data.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("responseCode")
    val responseCode: Int,
    @SerializedName("responseMessage")
    val responseMessage: String
)