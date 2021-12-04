package uz.lars_lion.voyvoo.preferences

import android.content.Context
import androidx.preference.PreferenceManager

class PreferencesManager(
    private val context: Context
) {

    private val preferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            context
        )
    }

    var isAuthVerified by PreferencesDelegate(preferences, IS_AUTH_VERIFIED, false)
    var name by PreferencesDelegate(preferences, NAME, "empty")


    companion object {
        private const val IS_AUTH_VERIFIED = "IS_AUTH_VERIFIED"
        private const val NAME = "NAME"

    }

}