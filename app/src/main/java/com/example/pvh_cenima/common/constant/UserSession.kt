package com.example.pvh_cenima.common.constant

import android.content.Context
import android.content.SharedPreferences

object UserSession {
    private const val PREF_NAME = "user_session"
    private const val APP_SETTING = "app_settings"
    private const val KEY_THEME_MODE = "key_theme_mode"
    private lateinit var sharedPreferences: SharedPreferences
    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

    /**
     * Save theme mode preference.
     * @param themeMode Theme mode ("Light", "Dark", or "System")
     */
    fun saveThemeMode(themeMode: String) {
        sharedPreferences.edit().apply {
            putString(KEY_THEME_MODE, themeMode)
            apply()
        }
        android.util.Log.d("UserSession", "Theme mode saved: $themeMode")
    }

    /**
     * Get saved theme mode preference.
     * @return Theme mode ("Light", "Dark", or "System") - default: "System"
     */
    fun getThemeMode(): String {
        return sharedPreferences.getString(KEY_THEME_MODE, "System") ?: "System"
    }
}