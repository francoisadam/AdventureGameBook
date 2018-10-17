package com.github.francoisadam.adventuregamebook.api

import com.github.francoisadam.adventuregamebook.model.Adventure
import com.github.francoisadam.adventuregamebook.model.Character
import com.github.francoisadam.adventuregamebook.model.Food
import io.reactivex.Single
import retrofit2.http.*


interface PersoApi {

    //TODO need auth
    @GET("perso")
    fun getPersoList(): Single<ArrayList<Character>>

    //TODO need auth
    @PUT("perso")
    fun addPerso(): Single<Character>

    @GET("perso/{id}")
    fun getPerso(@Path("id") persoId: Int): Single<Character>

    @DELETE("perso/{id}")
    fun deletePerso(@Path("id") persoId: Int): Single<Unit>

    @POST("perso/{id}/eat")
    fun makePersoEat(@Path("id") persoId: Int, @Body food: Food): Single<Adventure>
}