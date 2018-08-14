package pl.michal_boryczko.data.db.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import pl.michal_boryczko.data.interactor.dao.QuestionDAO
import pl.michal_boryczko.data.entity.QuestionRoom

/**
 * Created by ${michal_boryczko} on 13.08.2018.
 */
@Database(entities = [QuestionRoom::class], version = 1)
abstract class MyRoomDatabase: RoomDatabase(){
	abstract fun questionDao(): QuestionDAO

	companion object {
		lateinit var INSTANCE: MyRoomDatabase

		fun getInstance(context: Context): MyRoomDatabase {
			if (INSTANCE == null) {
				synchronized(MyRoomDatabase::class) {
					INSTANCE = Room.databaseBuilder(context.applicationContext,
							MyRoomDatabase::class.java, "MyRoomDatabase")
							.build()
				}
			}

			return INSTANCE
		}

	}
}