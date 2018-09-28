package com.github.francoisadam.adventuregamebook.api

import com.github.francoisadam.adventuregamebook.model.User
import io.reactivex.Single
import retrofit2.http.GET


interface LdhApi {

    @GET("user/get")
    fun getUser(): Single<User>
}