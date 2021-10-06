package com.sevengear.basic.domain.usecase

import com.sevengear.basic.core.thread.Executor
import com.sevengear.basic.core.usecase.RxSingleUseCase
import com.sevengear.basic.domain.model.DrawResponse
import com.sevengear.basic.domain.repository.DrawRepository
import io.reactivex.Single
import javax.inject.Inject

class GetDrawResutls @Inject constructor(executor: Executor, private val repository: DrawRepository):
RxSingleUseCase<GetDrawResutls.Request, GetDrawResutls.Response>(executor){
    override fun build(input: Request): Single<Response> =
        repository.getDrawResults(input.idGame, input.initDate, input.endDate).map { Response(it) }

    class Request(val idGame: String, val initDate: String, val endDate: String)

    class Response(drawResponse: DrawResponse)
}