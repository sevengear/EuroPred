package com.sevengear.basic.data.source.remote

import com.sevengear.basic.data.api.LottoApi
import com.sevengear.basic.data.model.DrawResponseData
import io.reactivex.Single
import javax.inject.Inject

class DrawRemoteDataSource @Inject constructor(
    private val lottoApi: LottoApi
) {
    fun getDrawResults(idGame: String, initDate: String, endDate: String): Single<DrawResponseData> {
        return lottoApi.getDrawResults(idGame, initDate, endDate)
    }
}