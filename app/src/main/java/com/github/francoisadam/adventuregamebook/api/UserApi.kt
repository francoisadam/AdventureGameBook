package com.github.francoisadam.adventuregamebook.api

import com.github.francoisadam.adventuregamebook.model.User
import io.reactivex.Single
import retrofit2.http.*


interface UserApi {

    //TODO need auth
    @GET("user")
    fun getCurrentUser(@Header("Authorization") token: String): Single<User>

    @PUT("user")
    fun createUser(@Body user: User): Single<User>

    @GET("user/{id}")
    fun getUser(@Path("id") userId: Int): Single<User>
}