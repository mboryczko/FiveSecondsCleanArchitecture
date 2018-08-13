package pl.michal_boryczko.data.interactor

import android.arch.persistence.room.Dao
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import pl.michal_boryczko.data.entity.QuestionRoom
import pl.michal_boryczko.domain.repository.LocalSource

/**
 * Created by ${michal_boryczko} on 13.08.2018.
 */
@Dao
interface QuestionDAO: LocalSource {

	@Query("SELECT * FROM QUESTIONS")
	fun getQuestions(): List<QuestionRoom>

	@Update(onConflict = OnConflictStrategy.REPLACE)
	fun updateQuestion(questionRoom: QuestionRoom)
}