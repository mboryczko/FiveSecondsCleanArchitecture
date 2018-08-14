package pl.michal_boryczko.data.interactor

import android.content.Context
import io.reactivex.Completable
import pl.michal_boryczko.data.network.NetworkService
import pl.michal_boryczko.data.preferences.UserPreferences
import pl.michal_boryczko.domain.repository.DataSource
import pl.michal_boryczko.domain.repository.LocalSource
import pl.michal_boryczko.domain.repository.RemoteSource
import javax.inject.Inject

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */
class DataSourceImpl @Inject constructor(
        private val localSource: LocalSource,
		private val remoteSource: RemoteSource,
        val context: Context,
        val preferences: UserPreferences) : DataSource {


	override fun pullQuestions(): Completable {
		return remoteSource
				.getAllQuestions()
				.flatMapCompletable {
					localSource.insertAllQuestions(it)
				}
	}


}