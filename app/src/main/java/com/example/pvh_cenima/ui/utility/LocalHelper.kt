package com.example.pvh_cenima.ui.utility

import android.content.Context
import com.example.pvh_cenima.common.constant.UserSession
import java.util.Locale

object LocalHelper {
    fun wrapContext(context: Context): Context {
        // Initialize UserSession first since attachBaseContext runs before onCreate
        UserSession.initialize(context)
        val lang = UserSession.getSavedLanguage()
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)
        return context.createConfigurationContext(config)
    }
}