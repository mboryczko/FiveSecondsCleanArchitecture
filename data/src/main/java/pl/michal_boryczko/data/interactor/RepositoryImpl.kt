package pl.michal_boryczko.data.interactor

import android.content.Context
import pl.michal_boryczko.data.network.NetworkService
import pl.michal_boryczko.data.preferences.UserPreferences
import pl.michal_boryczko.domain.repository.Repository
import javax.inject.Inject

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */
class RepositoryImpl @Inject constructor(
        val service: NetworkService,
        val context: Context,
        val preferences: UserPreferences) : Repository {

}