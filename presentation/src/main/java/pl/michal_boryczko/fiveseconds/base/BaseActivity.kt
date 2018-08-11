package pl.michal_boryczko.fiveseconds.base


import android.content.Context
import android.content.pm.ActivityInfo
import android.support.multidex.MultiDexApplication
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import pl.michal_boryczko.domain.repository.Repository
import pl.michal_boryczko.fiveseconds.R
import pl.michal_boryczko.fiveseconds.internal.AndroidApplication
import pl.michal_boryczko.fiveseconds.internal.di.components.ActivityComponent
import pl.michal_boryczko.fiveseconds.internal.di.components.ApplicationComponent
import pl.michal_boryczko.fiveseconds.internal.di.components.DaggerActivityComponent
import pl.michal_boryczko.fiveseconds.internal.di.modules.ActivityModule
import javax.inject.Inject

/**
 * Base [android.app.Activity] class for every Activity in this application.
 */
abstract class BaseActivity : AppCompatActivity() {


  @Inject
  lateinit var repository: Repository

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    applicationComponent.inject(this)
   /* if (isTabletDevice()) {
      requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
    } else {
      requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }*/

  }


  /**
   * Get the Main Application component for dependency injection.
   * @return [ApplicationComponent]
   */
  val applicationComponent: ApplicationComponent
    get() = (application as AndroidApplication).applicationComponent

  val activityComponent: ActivityComponent
    get() = DaggerActivityComponent.builder().applicationComponent(applicationComponent)
        .activityModule(ActivityModule(this))
        .build()

  fun showKeyboard(view: View){
    //not working
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)

  }

  fun hideKeyboard(view: View) = (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
      view.windowToken, 0)


}
