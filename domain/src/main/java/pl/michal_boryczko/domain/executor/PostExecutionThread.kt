package pl.michal_boryczko.domain.executor

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */


import io.reactivex.Scheduler

interface PostExecutionThread {

	fun getScheduler(): Scheduler

}