package com.github.francoisadam.adventuregamebook.repository

import com.github.francoisadam.adventuregamebook.api.ApiClient
import com.github.francoisadam.adventuregamebook.api.StoryApi
import com.github.francoisadam.adventuregamebook.model.Story
import io.reactivex.Single
import retrofit2.Retrofit

object StoryRepository {

    private var retrofit: Retrofit? = null
    private var api: StoryApi? = null

    init {
        retrofit = ApiClient().getClient()
        api = retrofit?.create(StoryApi::class.java)
    }

    fun getAllStories(): Single<ArrayList<Story>>? {
        return api?.getAllStories()
    }

    fun getUserStories(userId: Int): Single<ArrayList<Story>>? {
        return api?.getUserStories(userId)
    }
}