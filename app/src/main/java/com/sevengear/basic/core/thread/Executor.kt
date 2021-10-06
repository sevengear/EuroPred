package com.sevengear.basic.core.thread

import io.reactivex.Scheduler

interface Executor {
    val io: Scheduler
    val main: Scheduler
}