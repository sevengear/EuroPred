package com.sevengear.basic.data.repository

import com.sevengear.basic.data.source.remote.DrawRemoteDataSource
import com.sevengear.basic.domain.model.DrawResponse
import com.sevengear.basic.domain.repository.DrawRepository
import io.reactivex.Single
import javax.inject.Inject

class DrawDataRepository @Inject constructor(
    private val drawRemoteDataSource: DrawRemoteDataSource
): DrawRepository {
    override fun getDrawResults(idGame: String, initDate: String, endDate: String): Single<DrawResponse> {
        return drawRemoteDataSource.getDrawResults(idGame, initDate, endDate).map { it.mapToDomain() }
    }

}