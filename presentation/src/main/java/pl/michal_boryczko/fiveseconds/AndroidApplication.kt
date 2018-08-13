package pl.michal_boryczko.fiveseconds

import android.app.Activity
import android.support.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import pl.michal_boryczko.fiveseconds.internal.di.components.ApplicationComponent
import pl.michal_boryczko.fiveseconds.internal.di.components.DaggerApplicationComponent
import pl.michal_boryczko.fiveseconds.internal.di.modules.ApplicationModule
import pl.michal_boryczko.fiveseconds.internal.di.modules.NetModule
import timber.log.Timber

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */

class AndroidApplication : MultiDexApplication() {



	lateinit var applicationComponent: ApplicationComponent
		private set

	override fun onCreate() {
		super.onCreate()
		//AndroidThreeTen.init(this)
		initializeInjector()
		//initializeErrorHandler()
		initializeCaligraphy()

		if (BuildConfig.DEBUG) {
			initializeTimber()
			initializeStetho()
		} else {
		}
	}



	private fun initializeStetho() = Stetho.initializeWithDefaults(this)

	private fun initializeTimber() = Timber.plant(Timber.DebugTree())

	private fun initializeInjector() {
		applicationComponent = DaggerApplicationComponent.builder()
				.applicationModule(ApplicationModule(this))
				.netModule(NetModule(this))
				.build()
		applicationComponent.inject(this)
	}

	/*private fun initializeErrorHandler() = RxJavaPlugins.setErrorHandler { Functions.emptyConsumer<ApiErrorException>() }*/

	companion object {
		fun getInstance(activity: Activity) = activity.application as AndroidApplication
	}

	private fun initializeCaligraphy() {
		/*CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
				.setDefaultFontPath("Lato-Regular.ttf")
				.setFontAttrId(R.attr.fontPath)
				.build()
		)*/
	}
}