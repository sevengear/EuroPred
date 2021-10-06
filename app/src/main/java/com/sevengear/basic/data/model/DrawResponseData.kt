package com.sevengear.basic.data.model

import com.google.gson.annotations.SerializedName
import com.sevengear.basic.domain.model.DrawResponse
import com.sevengear.basic.domain.model.DrawResponseItem

data class DrawResponseData(
    val results: List<DrawResponseItemData>
) {
    fun mapToDomain() = DrawResponse(
        results.map { it.mapToDomain() }
    )
}

data class DrawResponseItemData(
    @SerializedName("anyo")
    val anyo: String,
    @SerializedName("combinacion")
    val combinacion: String,
    @SerializedName("combinacion_acta")
    val combinacionActa: String,
    @SerializedName("fecha_sorteo")
    val fechaSorteo: String,
    @SerializedName("game_id")
    val gameId: String
) {
    fun mapToDomain() = DrawResponseItem(
        anyo, combinacion, combinacionActa, fechaSorteo, gameId
    )
}