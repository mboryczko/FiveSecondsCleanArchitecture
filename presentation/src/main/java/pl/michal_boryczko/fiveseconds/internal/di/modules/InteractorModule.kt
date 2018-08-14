package pl.michal_boryczko.fiveseconds.internal.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.michal_boryczko.data.interactor.LocalSourceImpl
import pl.michal_boryczko.data.interactor.RemoteSourceImpl
import pl.michal_boryczko.data.interactor.dao.QuestionDAO
import pl.michal_boryczko.data.network.NetworkService
import pl.michal_boryczko.data.preferences.UserPreferences
import pl.michal_boryczko.domain.repository.LocalSource
import pl.michal_boryczko.domain.repository.RemoteSource
import pl.michal_boryczko.fiveseconds.internal.DaggerNames
import javax.inject.Named
import javax.inject.Singleton

@Module
class InteractorModule {

  @Provides
  @Singleton
  internal fun provideRemoteSource(service: NetworkService, @Named(DaggerNames.APPLICATION_CONTEXT) context: Context,
                                 preferences: UserPreferences): RemoteSource = RemoteSourceImpl(service, context, preferences)

  @Provides
  @Singleton
  internal fun provideLocalSource(questionDAO: QuestionDAO): LocalSource = LocalSourceImpl(questionDAO)

}
