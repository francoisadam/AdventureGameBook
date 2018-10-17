package com.github.francoisadam.adventuregamebook.api

import com.github.francoisadam.adventuregamebook.model.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path


interface UserApi {

    //TODO need auth
    @GET("user")
    fun getCurrentUser(): Single<User>

    @PUT("user")
    fun createUser(@Body user: User): Single<User>

    @GET("user/{id}")
    fun getUser(@Path("id") userId: Int): Single<User>
}