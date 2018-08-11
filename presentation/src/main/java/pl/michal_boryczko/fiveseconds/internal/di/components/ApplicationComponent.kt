package pl.michal_boryczko.fiveseconds.internal.di.components

import dagger.Component
import pl.michal_boryczko.domain.repository.Repository
import pl.michal_boryczko.fiveseconds.base.BaseActivity
import pl.michal_boryczko.fiveseconds.base.BaseFragment
import pl.michal_boryczko.fiveseconds.internal.AndroidApplication
import pl.michal_boryczko.fiveseconds.internal.di.modules.ApplicationModule
import pl.michal_boryczko.fiveseconds.internal.di.modules.ExecutorModule
import pl.michal_boryczko.fiveseconds.internal.di.modules.InteractorModule
import pl.michal_boryczko.fiveseconds.internal.di.modules.NetModule
import javax.inject.Singleton

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(
    modules = arrayOf(ApplicationModule::class, InteractorModule::class, ExecutorModule::class, NetModule::class))
interface ApplicationComponent {

  fun inject(baseActivity: BaseActivity)
  fun inject(baseFragment: BaseFragment)
  fun inject(androidApplication: AndroidApplication)

  fun getRepository(): Repository

}

