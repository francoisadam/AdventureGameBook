package com.github.francoisadam.adventuregamebook.manager

import android.content.Context
import android.preference.PreferenceManager


object SharedPreferencesManager {
    private val USER_KEY = "user_id"

    fun getUserToken(context: Context): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(USER_KEY, "DugrakToken")
    }

    fun saveUserToken(context: Context, token: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        preferences.edit().putString(USER_KEY, token).apply()
    }
}