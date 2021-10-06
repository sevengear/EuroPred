package com.sevengear.basic.domain.repository

import com.sevengear.basic.domain.model.DrawResponse
import io.reactivex.Single

interface DrawRepository {
    fun getDrawResults(idGame: String, initDate: String, endDate: String): Single<DrawResponse>
}