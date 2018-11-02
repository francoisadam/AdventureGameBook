package com.github.francoisadam.adventuregamebook.repository

import com.github.francoisadam.adventuregamebook.api.ApiClient
import com.github.francoisadam.adventuregamebook.api.UserApi
import com.github.francoisadam.adventuregamebook.model.User
import io.reactivex.Single
import retrofit2.Retrofit

object UserRepository {

    private var retrofit: Retrofit? = null
    private var api: UserApi? = null

    init {
        retrofit = ApiClient().getClient()
        api = retrofit?.create(UserApi::class.java)
    }

    fun createUser(user: User): Single<User>? {
        return api?.createUser(user)
    }

    fun getUser(token: String): Single<User>? {
        return api?.getCurrentUser(token)
    }
}