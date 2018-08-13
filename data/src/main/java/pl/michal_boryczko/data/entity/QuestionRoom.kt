package pl.michal_boryczko.data.entity

import QUESTION_TABLE
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey



/**
 * Created by ${michal_boryczko} on 13.08.2018.
 */

@Entity(tableName = QUESTION_TABLE)
class QuestionRoom {

	@PrimaryKey
	@ColumnInfo(name = "userid")
	private val id: Long = -1

	@ColumnInfo(name = "name")
	private val name: String = ""

}