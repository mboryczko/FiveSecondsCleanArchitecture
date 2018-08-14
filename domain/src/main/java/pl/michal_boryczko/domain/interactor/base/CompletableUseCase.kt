package pl.michal_boryczko.domain.interactor.base

/**
 * Created by ${michal_boryczko} on 14.08.2018.
 */

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import pl.michal_boryczko.domain.executor.ThreadExecutor
import pl.michal_boryczko.domain.executor.PostExecutionThread

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a [DisposableCompletableObserver]
 * that will execute its job in a background thread and will post the result in the UI thread.
 *
 * Class is parametrized with two types, where:
 * @param T the input value type
 */

abstract class CompletableUseCase<in T>(
		private val threadExecutor: ThreadExecutor,
		private val postExecutionThread: PostExecutionThread) {

	private val disposables: CompositeDisposable = CompositeDisposable()

	/**
	 * Builds an [Completable] which will be used when executing the current [CompletableUseCase].
	 */
	protected abstract fun buildUseCaseCompletable(params: T): Completable

	/**
	 * Returns built [Single]. This method is for composing and reusing existed UseCases
	 */
	internal fun completable(params: T): Completable = buildUseCaseCompletable(params)

	/**
	 * Executes the current use case.
	 *
	 * @param observer [DisposableCompletableObserver] which will be listening to the observable build
	 * * by [.buildUseCaseCompletable] ()} method.
	 * @param params Parameters (Optional) used to build/execute this use case.
	 */
	open fun execute(observer: DisposableCompletableObserver, params: T) {
		val single = this.buildUseCaseCompletable(params)
				.subscribeOn(Schedulers.from(threadExecutor))
				.observeOn(postExecutionThread.getScheduler())
		addDisposable(single.subscribeWith(observer))
	}

	/**
	 * Dispose from current [CompositeDisposable].
	 */
	open fun dispose() {
		if (!disposables.isDisposed) {
			disposables.dispose()
		}
	}

	/**
	 * Clears all disposables
	 */
	open fun clear() {
		if (!disposables.isDisposed) {
			disposables.clear()
		}
	}

	/**
	 * Dispose from current [CompositeDisposable].
	 */
	private fun addDisposable(disposable: Disposable) {
		disposables.add(disposable)
	}
}