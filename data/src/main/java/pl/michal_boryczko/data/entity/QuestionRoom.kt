package pl.michal_boryczko.data.entity

import QUESTION_TABLE
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey
import pl.michal_boryczko.data.util.Transformer
import pl.michal_boryczko.domain.models.Question


/**
 * Created by ${michal_boryczko} on 13.08.2018.
 */

@Entity(tableName = QUESTION_TABLE)
data class QuestionRoom (
		@PrimaryKey
		@ColumnInfo(name = "id")
		val id: Long = -1,

		@ColumnInfo(name = "name")
		val name: String = ""


):Transformer<Question>{
	override fun transform(): Question = Question(id, name)
}
