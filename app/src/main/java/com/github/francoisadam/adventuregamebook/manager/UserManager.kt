package com.github.francoisadam.adventuregamebook.manager

import android.content.Context
import com.github.francoisadam.adventuregamebook.model.User

object UserManager {
    var currentUser: User? = null

    fun saveUser(context: Context, user: User) {
        user.token?.let { token ->
            currentUser = user
            SharedPreferencesManager.saveUserToken(context, token)
        }
    }
}