package pl.michal_boryczko.fiveseconds.internal.di.components

import dagger.Component
import pl.michal_boryczko.fiveseconds.internal.di.modules.FragmentModule
import pl.michal_boryczko.fiveseconds.internal.di.scopes.FragmentScope


@FragmentScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

}