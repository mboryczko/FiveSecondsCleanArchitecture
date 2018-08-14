package pl.michal_boryczko.data.interactor

import io.reactivex.Completable
import pl.michal_boryczko.data.db.valueOf
import pl.michal_boryczko.data.interactor.dao.QuestionDAO
import pl.michal_boryczko.domain.models.Question
import pl.michal_boryczko.domain.repository.LocalSource
import javax.inject.Inject

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */
class LocalSourceImpl @Inject constructor(
        private val questionDAO: QuestionDAO) : LocalSource{

	override fun insertAllQuestions(questions: List<Question>): Completable  = questionDAO.insertAllQuestions(questions.map { it.valueOf()})


}