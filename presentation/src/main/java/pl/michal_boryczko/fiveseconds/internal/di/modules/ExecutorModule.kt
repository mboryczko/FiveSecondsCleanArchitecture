package pl.michal_boryczko.fiveseconds.internal.di.modules

import dagger.Module
import dagger.Provides
import pl.michal_boryczko.domain.executor.PostExecutionThread
import pl.michal_boryczko.domain.executor.ThreadExecutor
import pl.michal_boryczko.domain.interactor.impl.PullQuestionsUseCase
import pl.michal_boryczko.domain.repository.DataSource
import pl.michal_boryczko.domain.repository.LocalSource
import pl.michal_boryczko.domain.repository.RemoteSource
import javax.inject.Singleton

@Module
class ExecutorModule{

	@Provides
	@Singleton
	internal fun providePullQuestionsUseCase(
			dataSource: DataSource,
			threadExecutor: ThreadExecutor,
			postExecutionThread: PostExecutionThread
	) = PullQuestionsUseCase(dataSource, threadExecutor, postExecutionThread)




}
