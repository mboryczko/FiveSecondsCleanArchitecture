package pl.michal_boryczko.fiveseconds.base

import android.accounts.NetworkErrorException

/**
 * Interface representing a Presenter in a model mView presenter (MVP) pattern.
 */
abstract class Presenter<T : BaseView> {

  lateinit protected var view: T

  fun attachView(view: T) {
    this.view = view
  }

  /**
   * Method that control the lifecycle of the mView. It should be called in the mView's
   * (Activity or Fragment) onResume() method.
   */
  abstract fun resume()

  /**
   * Method that control the lifecycle of the mView. It should be called in the mView's
   * (Activity or Fragment) onPause() method.
   */
  abstract fun pause()

  /**
   * Method that control the lifecycle of the mView. It should be called in the mView's
   * (Activity or Fragment) onDestroy() method.
   */
  abstract fun destroy()

  internal fun handleNetworkError(e: Throwable) {
    if (e is NetworkErrorException) {

    }
   /* else if (e is ApiErrorException) {
    }*/
  }

}
