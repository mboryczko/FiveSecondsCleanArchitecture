package pl.michal_boryczko.domain.interactor.base

import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import pl.michal_boryczko.domain.executor.PostExecutionThread
import pl.michal_boryczko.domain.executor.ThreadExecutor

/**
 * Simple wrapper for [SingleUseCase] to omit input type parameter
 *
 * @param R the output value type
 */
abstract class SingleVoidUseCase<R> protected constructor(
		threadExecutor: ThreadExecutor,
		postExecutionThread: PostExecutionThread) : SingleUseCase<Unit, R>(threadExecutor, postExecutionThread) {

	fun execute(observer: DisposableSingleObserver<R>) = super.execute(observer, Unit)

	override fun buildUseCaseSingle(unit: Unit): Single<R> = buildUseCaseSingle()

	protected abstract fun buildUseCaseSingle(): Single<R>

	internal fun single(): Single<R> = buildUseCaseSingle()
}
