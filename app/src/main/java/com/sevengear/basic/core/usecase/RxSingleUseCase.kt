package com.sevengear.basic.core.usecase

import com.sevengear.basic.core.thread.Executor
import io.reactivex.Single

abstract class RxSingleUseCase<I, O>(
    private val executor: Executor
) : UseCase<I, Single<O>>() {

    operator fun invoke(input: I): Single<O> =
        build(input)
            .subscribeOn(executor.io)
            .observeOn(executor.main)

}