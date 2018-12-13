package com.github.francoisadam.adventuregamebook.manager

import android.util.Log

object LogManager {
    val TAG = "AdventureGameBook"

    fun logError(throwable: Throwable) {
        throwable.printStackTrace()
        Log.e(TAG, throwable.message)
    }

    fun log(message: String) {
        Log.i(TAG, message)
    }
}