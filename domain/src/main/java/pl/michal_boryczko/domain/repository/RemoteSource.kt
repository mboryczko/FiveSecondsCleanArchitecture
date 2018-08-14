package pl.michal_boryczko.domain.repository

import io.reactivex.Single
import pl.michal_boryczko.domain.models.Question

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */
interface RemoteSource {

	fun getAllQuestions(): Single<List<Question>>

}