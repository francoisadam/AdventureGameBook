package com.github.francoisadam.adventuregamebook.repository

import com.github.francoisadam.adventuregamebook.api.ApiClient
import com.github.francoisadam.adventuregamebook.api.LdhApi
import com.github.francoisadam.adventuregamebook.model.User
import io.reactivex.Single
import retrofit2.Retrofit

object ApiRepository {

    private var retrofit: Retrofit? = null
    private var api: LdhApi? = null

    init {
        retrofit = ApiClient().getClient()
        api = retrofit?.create(LdhApi::class.java)
    }

    fun getUser(): Single<User>? {
        return api?.getUser()
    }
}