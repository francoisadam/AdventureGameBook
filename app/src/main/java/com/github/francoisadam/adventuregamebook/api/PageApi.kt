package com.github.francoisadam.adventuregamebook.api

import com.github.francoisadam.adventuregamebook.model.Adventure
import com.github.francoisadam.adventuregamebook.model.Page
import io.reactivex.Single
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path


interface PageApi {

    //TODO need auth
    @PUT("page")
    fun addPage(): Single<Page>

    //TODO need auth
    @GET("page/{pageId}")
    fun getPage(@Path("pageId") pageId: Int): Single<Page>

    @DELETE("page/{pageId}")
    fun deletePage(@Path("pageId") pageId: Int): Single<Unit>

    @GET("page/story/{storyId}")
    fun getStoryFirstPage(@Path("storyId") storyId: Int): Single<Adventure>
}