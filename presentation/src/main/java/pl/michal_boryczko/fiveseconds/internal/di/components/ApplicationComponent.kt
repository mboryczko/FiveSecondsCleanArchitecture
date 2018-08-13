package pl.michal_boryczko.fiveseconds.internal.di.components

import dagger.Component
import pl.michal_boryczko.data.db.database.MyRoomDatabase
import pl.michal_boryczko.domain.repository.RemoteSource
import pl.michal_boryczko.fiveseconds.base.BaseActivity
import pl.michal_boryczko.fiveseconds.base.BaseFragment
import pl.michal_boryczko.fiveseconds.AndroidApplication
import pl.michal_boryczko.fiveseconds.internal.di.modules.*
import javax.inject.Singleton

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(
    modules = arrayOf(ApplicationModule::class, InteractorModule::class, ExecutorModule::class, NetModule::class, DatabaseModule::class))
interface ApplicationComponent {

  fun inject(baseActivity: BaseActivity)
  fun inject(baseFragment: BaseFragment)
  fun inject(androidApplication: AndroidApplication)

  fun getRepository(): RemoteSource
  fun getDatabase(): MyRoomDatabase
}

