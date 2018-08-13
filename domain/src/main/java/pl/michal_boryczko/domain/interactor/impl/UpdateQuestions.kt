package pl.michal_boryczko.domain.interactor.impl

import io.reactivex.Single
import pl.michal_boryczko.domain.executor.ThreadExecutor
import pl.michal_boryczko.domain.executor.PostExecutionThread
import pl.michal_boryczko.domain.interactor.base.SingleVoidUseCase
import pl.michal_boryczko.domain.repository.LocalSource
import pl.michal_boryczko.domain.repository.RemoteSource
import javax.inject.Inject

/**
 * Created by ${michal_boryczko} on 13.08.2018.
 */
class UpdateQuestions @Inject constructor(
		private val remoteSource: RemoteSource,
		private val localSource: LocalSource,
		threadExecutor: ThreadExecutor,
		postExecutionThread: PostExecutionThread)
	:SingleVoidUseCase<Boolean>(threadExecutor, postExecutionThread) {


	override fun buildUseCaseSingle(): Single<Boolean> {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}