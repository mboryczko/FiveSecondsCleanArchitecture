package pl.michal_boryczko.fiveseconds.internal.di.components


import dagger.Component
import pl.michal_boryczko.fiveseconds.internal.di.modules.ActivityModule
import pl.michal_boryczko.fiveseconds.internal.di.scopes.ActivityScope
import pl.michal_boryczko.fiveseconds.ui.menu.impl.MenuActivity

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

  fun inject(menuActivity: MenuActivity)



}