package pl.michal_boryczko.data.preferences

import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

/**
 * Created by ${michal_boryczko} on 10.08.2018.
 */


class UserPreferences @Inject constructor(val sharedPreferences: SharedPreferences, val gson: Gson) {

	private object Key {

		const val USER_EMAIL = "user_email"
	}

	var userEmail: String
		get() = sharedPreferences.getString(Key.USER_EMAIL, "")
		set(value) = sharedPreferences.edit().putString(Key.USER_EMAIL, value).apply()




}