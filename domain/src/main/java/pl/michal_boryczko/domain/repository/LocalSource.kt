package pl.michal_boryczko.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import pl.michal_boryczko.domain.models.Question

/**
 * Created by ${michal_boryczko} on 13.08.2018.
 */
interface LocalSource {
	 fun insertAllQuestions(questions: List<Question>): Completable
}