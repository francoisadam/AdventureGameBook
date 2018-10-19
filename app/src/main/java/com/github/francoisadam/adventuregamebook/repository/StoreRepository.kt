package com.github.francoisadam.adventuregamebook.repository

import com.github.francoisadam.adventuregamebook.api.ApiClient
import com.github.francoisadam.adventuregamebook.api.StoreApi
import retrofit2.Retrofit

object StoreRepository {

    private var retrofit: Retrofit? = null
    private var api: StoreApi? = null

    init {
        retrofit = ApiClient().getClient()
        api = retrofit?.create(StoreApi::class.java)
    }
}