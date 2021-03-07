package app.mimo.it.core.utils

import android.content.SharedPreferences
import app.mimo.it.core.AppConstants

object PreferencesUtils {

    fun saveToken(sharedPreferences: SharedPreferences, token: String?) {
        sharedPreferences.edit().putString(AppConstants.TOKEN, token).apply()
    }

    fun getToken(sharedPreferences: SharedPreferences) =
        sharedPreferences.getString(AppConstants.TOKEN, null)
}