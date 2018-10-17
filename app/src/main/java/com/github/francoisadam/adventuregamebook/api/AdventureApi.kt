package com.github.francoisadam.adventuregamebook.api

import com.github.francoisadam.adventuregamebook.model.Adventure
import com.github.francoisadam.adventuregamebook.model.Choice
import com.github.francoisadam.adventuregamebook.model.TestInput
import com.github.francoisadam.adventuregamebook.model.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface AdventureApi {

    //TODO need auth
    @POST("adventure/changePage")
    fun changePage(@Body choice: Choice): Single<Adventure>

    @GET("adventure/{persoId}")
    fun getAdventure(@Path("persoId") persoId: Int): Single<Adventure>

    //TODO need auth
    @POST("adventure/test")
    fun takeTest(@Body testInput: TestInput): Single<Adventure>
}