package com.github.francoisadam.adventuregamebook.api

import com.github.francoisadam.adventuregamebook.model.Story
import io.reactivex.Single
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path


interface StoryApi {

    //TODO need auth
    @GET("story")
    fun getUser(): Single<ArrayList<Story>>

    //TODO need auth
    @PUT("story")
    fun addStory(): Single<Story>

    @GET("all")
    fun getAllStories(): Single<ArrayList<Story>>

    @GET("story/{userId}")
    fun getUserStories(@Path("userId") userId: Int): Single<ArrayList<Story>>

    //TODO need auth
    @DELETE("story/{storyId}")
    fun deleteStory(@Path("storyId") storyId: Int): Single<Unit>
}