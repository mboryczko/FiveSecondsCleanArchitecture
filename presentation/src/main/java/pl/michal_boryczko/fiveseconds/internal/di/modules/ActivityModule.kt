package pl.michal_boryczko.fiveseconds.internal.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.michal_boryczko.fiveseconds.internal.DaggerNames
import pl.michal_boryczko.fiveseconds.internal.di.scopes.ActivityScope
import javax.inject.Named

@Module
class ActivityModule(private val activityContext: Context) {

  @Provides
  @Named(DaggerNames.ACTIVITY_CONTEXT)
  @ActivityScope
  internal fun provideActivityContext(): Context = activityContext

}
