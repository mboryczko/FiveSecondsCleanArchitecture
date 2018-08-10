package pl.michal_boryczko.fiveseconds

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import pl.michal_boryczko.domain.executor.PostExecutionThread
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */
@Singleton
class UiThread @Inject constructor() : PostExecutionThread {

	override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()

}