package pl.michal_boryczko.fiveseconds.internal.di.modules

import dagger.Module
import dagger.Provides
import pl.michal_boryczko.domain.executor.PostExecutionThread
import pl.michal_boryczko.domain.executor.ThreadExecutor
import pl.michal_boryczko.domain.interactor.impl.UpdateQuestions
import pl.michal_boryczko.domain.repository.LocalSource
import pl.michal_boryczko.domain.repository.RemoteSource
import javax.inject.Singleton

@Module
class ExecutorModule constructor(
		val remoteSource: RemoteSource,
		val localSource: LocalSource,
		val threadExecutor: ThreadExecutor,
		val postExecutionThread: PostExecutionThread
) {

	@Provides
	@Singleton
	internal fun provideGetQuestionsUseCase() = UpdateQuestions(remoteSource, localSource, threadExecutor, postExecutionThread)




}
