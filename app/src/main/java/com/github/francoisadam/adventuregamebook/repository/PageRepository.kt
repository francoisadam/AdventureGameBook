package com.github.francoisadam.adventuregamebook.repository

import com.github.francoisadam.adventuregamebook.api.ApiClient
import com.github.francoisadam.adventuregamebook.api.PageApi
import com.github.francoisadam.adventuregamebook.model.Adventure
import io.reactivex.Single
import retrofit2.Retrofit

object PageRepository {

    private var retrofit: Retrofit? = null
    private var api: PageApi? = null

    init {
        retrofit = ApiClient().getClient()
        api = retrofit?.create(PageApi::class.java)
    }

    fun getStoryFirstPage(storyId: Int): Single<Adventure>? {
        return api?.getStoryFirstPage(storyId)
    }
}