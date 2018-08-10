package pl.altconnect.mobileshop.presentation.base

import android.content.Context
import android.support.v4.app.Fragment

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import pl.michal_boryczko.fiveseconds.internal.AndroidApplication
import pl.michal_boryczko.fiveseconds.internal.di.components.ApplicationComponent
import pl.michal_boryczko.fiveseconds.internal.di.components.FragmentComponent
import pl.michal_boryczko.fiveseconds.internal.di.modules.FragmentModule
import javax.inject.Inject

/**
 * Base [android.app.Activity] class for every Activity in this application.
 */
abstract class BaseFragment : Fragment() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    applicationComponent.inject(this)
  }


  /**
   * Get the Main Application component for dependency injection.
   * @return [ApplicationComponent]
   */
  val applicationComponent: ApplicationComponent
    get() = AndroidApplication.getInstance(activity!!).applicationComponent

 /* val fragmentComponent: FragmentComponent
    get() = DaggerFragmentComponent.builder().applicationComponent(applicationComponent)
            .fragmentModule(FragmentModule(activity!!))
            .build()*/

  fun hideKeyboard(view: View) = (activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
          view.windowToken, 0)

}