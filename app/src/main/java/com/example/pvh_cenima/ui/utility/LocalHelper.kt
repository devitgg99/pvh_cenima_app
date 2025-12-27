package com.example.pvh_cenima.ui.utility

import android.content.Context
import android.content.SharedPreferences
import java.util.Locale

object LocalHelper {
    private const val PREF_NAME = "language_pref"
    private const val KEY_LANGUAGE = "selected_language"
    private const val DEFAULT_LANGUAGE = "en"

    private fun getPrefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveLanguage(context: Context, lang: String) {
        getPrefs(context).edit().putString(KEY_LANGUAGE, lang).apply()
    }

    fun getSavedLanguage(context: Context): String =
        getPrefs(context).getString(KEY_LANGUAGE, DEFAULT_LANGUAGE) ?: DEFAULT_LANGUAGE

    fun wrapContext(context: Context): Context {
        val lang = getSavedLanguage(context)
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)
        return context.createConfigurationContext(config)
    }
}