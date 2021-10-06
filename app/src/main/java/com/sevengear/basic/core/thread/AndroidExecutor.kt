package com.sevengear.basic.core.thread

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AndroidExecutor : Executor {
    override val io: Scheduler = Schedulers.io()
    override val main: Scheduler = AndroidSchedulers.mainThread()
}