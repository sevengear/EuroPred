package com.sevengear.basic.domain.model

data class DrawResponse(
    val results: List<DrawResponseItem>
)

data class DrawResponseItem(
    val anyo: String,
    val combinacion: String,
    val combinacionActa: String,
    val fechaSorteo: String,
    val gameId: String
)