package pl.michal_boryczko.fiveseconds.internal.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import pl.dentaltree.data.executor.JobExecutor
import pl.michal_boryczko.domain.executor.PostExecutionThread
import pl.michal_boryczko.domain.executor.ThreadExecutor
import pl.michal_boryczko.fiveseconds.UiThread
import pl.michal_boryczko.fiveseconds.internal.AndroidApplication
import pl.michal_boryczko.fiveseconds.internal.DaggerNames
import javax.inject.Named
import javax.inject.Singleton

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
class ApplicationModule(private val application: AndroidApplication) {

  @Provides
  @Named(DaggerNames.APPLICATION_CONTEXT)
  @Singleton
  internal fun provideApplicationContext(): Context = application

  @Provides
  @Singleton
  internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread

  @Provides
  @Singleton
  internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor


  @Provides
  @Singleton
  internal fun provideSharedPreferences(@Named(DaggerNames.APPLICATION_CONTEXT) context: Context): SharedPreferences =
          context.getSharedPreferences("five_seconds", Context.MODE_PRIVATE)



}
