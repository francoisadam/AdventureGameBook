package com.github.francoisadam.adventuregamebook.api

import com.github.francoisadam.adventuregamebook.model.Store
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path


interface StoreApi {

    //TODO need auth
    @PUT("store")
    fun createStore(@Body store: Store): Single<Store>

    //TODO need auth
    @GET("store/{avatarUri}")
    fun getStore(@Path("avatarUri") storeId: Int): Single<Store>

    //TODO need auth
    @GET("store/all")
    fun getAllStores(): Single<ArrayList<Store>>
}