package pl.michal_boryczko.fiveseconds.ui.menu

import android.content.Context
import pl.michal_boryczko.fiveseconds.base.Presenter
import pl.michal_boryczko.fiveseconds.internal.DaggerNames
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by mjbor on 8/11/2018.
 */
class MenuPresenter @Inject constructor(
        @Named(DaggerNames.ACTIVITY_CONTEXT) private val context: Context
        ): Presenter<MenuView>() {

    override fun resume() = Unit
    override fun pause() = Unit
    override fun destroy() = Unit



}