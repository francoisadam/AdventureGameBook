package com.github.francoisadam.adventuregamebook.repository

import com.github.francoisadam.adventuregamebook.api.AdventureApi
import com.github.francoisadam.adventuregamebook.api.ApiClient
import com.github.francoisadam.adventuregamebook.model.Adventure
import io.reactivex.Single
import retrofit2.Retrofit

object AdventureRepository {

    private var retrofit: Retrofit? = null
    private var api: AdventureApi? = null

    init {
        retrofit = ApiClient().getClient()
        api = retrofit?.create(AdventureApi::class.java)
    }

    fun getAdventure(persoId: Int): Single<Adventure>? {
        return api?.getAdventure(persoId)
    }
}