package pl.michal_boryczko.data.interactor

import android.content.Context
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleTransformer
import pl.michal_boryczko.data.R
import pl.michal_boryczko.data.entity.QuestionRoom
import pl.michal_boryczko.data.network.NetworkService
import pl.michal_boryczko.data.preferences.UserPreferences
import pl.michal_boryczko.domain.models.Question
import pl.michal_boryczko.domain.models.exceptions.ApiErrorException
import pl.michal_boryczko.domain.repository.RemoteSource
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */
class RemoteSourceImpl @Inject constructor(
        val service: NetworkService,
        val context: Context,
        val preferences: UserPreferences) : RemoteSource {

	override fun getAllQuestions(): Single<List<Question>> {
		return service.getAllQuestions()
				.compose(unpackResponseAndHandleErrors())
				.flatMapObservable { Observable.fromIterable(it) }
				.map (QuestionRoom::transform )
				.toList()
	}


	private fun <T> unpackResponseAndHandleErrors(): SingleTransformer<Response<T>, T> {
		return SingleTransformer { upstream ->
			upstream.flatMap {
				if (it.isSuccessful) {
					Single.just(it.body())
				} else {
					Single.error(ApiErrorException(
							if (it.code() == 400) "Wystąpił nieoczekiwany błąd"
							else it.errorBody()?.string() ?: it.errorBody().toString() , it.code()))
				}
			}
		}
	}


/*

	private fun <T> handle401Exception() = SingleTransformer<T, T>() {
		it.onErrorResumeNext {
			if (it is UnauthorizedException) {
				login(autologging = true)
						.flatMap { _ -> Single.error<T>(it) }
			} else {
				Single.error(it)
			}
		}
	}
*/


}