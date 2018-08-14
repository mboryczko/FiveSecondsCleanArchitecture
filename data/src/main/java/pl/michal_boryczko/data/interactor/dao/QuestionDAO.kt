package pl.michal_boryczko.data.interactor.dao

import android.arch.persistence.room.*
import io.reactivex.Completable
import io.reactivex.Single
import pl.michal_boryczko.data.entity.QuestionRoom
import pl.michal_boryczko.domain.models.Question
import pl.michal_boryczko.domain.repository.LocalSource

/**
 * Created by ${michal_boryczko} on 13.08.2018.
 */
@Dao
interface QuestionDAO {

	@Query("SELECT * FROM QUESTIONS")
	fun getQuestions(): Single<List<QuestionRoom>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertQuestion(questionRoom: QuestionRoom)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertAllQuestions(questionsRoom: List<QuestionRoom>): Completable
}