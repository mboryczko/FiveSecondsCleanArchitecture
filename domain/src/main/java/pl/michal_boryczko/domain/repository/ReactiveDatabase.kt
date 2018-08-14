package pl.michal_boryczko.domain.repository

import io.reactivex.Completable
import io.reactivex.Single

/**
 *  Represents standard crud operations on store with [io.reactivex] manner
 */


interface ReactiveDatabase<T> {

	fun update(item: T): Single<T>

	fun addAll(items: Iterable<T>): Single<Iterable<T>>

	/*fun add(item: T): Single<T>



	fun remove(item: T): Completable

	fun query(): Single<List<T>>

	fun queryById(entityId: Long): Single<T>

	fun queryByProductId(productId: Long): Single<T>

	fun count(): Single<Int>*/
}
