package pl.michal_boryczko.domain.interactor.impl

import io.reactivex.Completable
import pl.michal_boryczko.domain.executor.ThreadExecutor
import pl.michal_boryczko.domain.executor.PostExecutionThread
import pl.michal_boryczko.domain.interactor.base.CompletableUseCase
import pl.michal_boryczko.domain.repository.DataSource
import javax.inject.Inject

/**
 * Created by ${michal_boryczko} on 13.08.2018.
 */
class PullQuestionsUseCase @Inject constructor(
		private val dataSource: DataSource,
		threadExecutor: ThreadExecutor,
		postExecutionThread: PostExecutionThread) :CompletableUseCase<Void>(threadExecutor, postExecutionThread) {


	override fun buildUseCaseCompletable(params: Void): Completable = dataSource.pullQuestions()


}