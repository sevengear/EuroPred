package com.sevengear.basic.data.api

import com.sevengear.basic.data.model.DrawResponseData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface LottoApi {
    @GET("buscadorSorteos?game_id={idGame}&celebrados=true&fechaInicioInclusiva={initDate}&fechaFinInclusiva={endDate}")
    fun getDrawResults(
        @Path("idGame") idGame: String,
        @Path("initDate") initDate: String,
        @Path("endDate") endDate: String
    ): Single<DrawResponseData>
}