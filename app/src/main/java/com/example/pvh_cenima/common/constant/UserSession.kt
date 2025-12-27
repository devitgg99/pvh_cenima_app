package com.example.pvh_cenima.common.constant

import android.content.Context
import android.content.SharedPreferences

object UserSession {
    private const val PREF_NAME = "user_session"
    private const val KEY_THEME_MODE = "key_theme_mode"
    private const val KEY_LANGUAGE = "selected_language"
    private const val ACCESS_TOKEN = "access_token"
    private const val DEFAULT_LANGUAGE = "en"
    private lateinit var sharedPreferences: SharedPreferences
    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

    /**
     * Save Access Token
     * */

    fun saveAccessToken(token: String) {
        sharedPreferences.edit().putString(ACCESS_TOKEN, token).apply()
    }

    fun getAccessToken(): String {
        return sharedPreferences.getString(ACCESS_TOKEN, "") ?: ""
    }

    /**
     * Localization
     */
    fun saveLanguage(lang: String) {
        sharedPreferences.edit().putString(KEY_LANGUAGE, lang).apply()
    }

    fun getSavedLanguage(): String =
        sharedPreferences.getString(KEY_LANGUAGE, DEFAULT_LANGUAGE) ?: DEFAULT_LANGUAGE


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