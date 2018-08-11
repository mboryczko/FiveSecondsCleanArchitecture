package pl.michal_boryczko.fiveseconds.internal.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.michal_boryczko.data.interactor.RepositoryImpl
import pl.michal_boryczko.data.network.NetworkService
import pl.michal_boryczko.data.preferences.UserPreferences
import pl.michal_boryczko.domain.repository.Repository
import pl.michal_boryczko.fiveseconds.internal.DaggerNames
import javax.inject.Named
import javax.inject.Singleton

@Module
class InteractorModule {

  @Provides
  @Singleton
  internal fun provideRepository(service: NetworkService, @Named(DaggerNames.APPLICATION_CONTEXT) context: Context,
                                 preferences: UserPreferences): Repository = RepositoryImpl(service, context, preferences)

}
