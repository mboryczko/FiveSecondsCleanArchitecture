package pl.michal_boryczko.data.network

import io.reactivex.Single
import pl.michal_boryczko.data.entity.QuestionRoom
import pl.michal_boryczko.domain.models.Question
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */
interface NetworkService {

	@GET("rxjava/getAllQuestions.php")
	fun getAllQuestions(
	): Single<Response<List<QuestionRoom>>>
}