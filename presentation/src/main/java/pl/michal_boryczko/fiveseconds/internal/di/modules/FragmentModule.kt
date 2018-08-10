package pl.michal_boryczko.fiveseconds.internal.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.michal_boryczko.fiveseconds.internal.DaggerNames
import pl.michal_boryczko.fiveseconds.internal.di.scopes.FragmentScope
import javax.inject.Named


@Module
class FragmentModule(private val fragmentContext: Context) {

  @Provides
  @FragmentScope
  @Named(DaggerNames.FRAGMENT_CONTEXT)
  internal fun provideFragmentContext(): Context = fragmentContext

}