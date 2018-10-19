package com.github.francoisadam.adventuregamebook.repository

import com.github.francoisadam.adventuregamebook.api.ApiClient
import com.github.francoisadam.adventuregamebook.api.PersoApi
import com.github.francoisadam.adventuregamebook.model.Adventure
import com.github.francoisadam.adventuregamebook.model.Character
import com.github.francoisadam.adventuregamebook.model.Food
import io.reactivex.Single
import retrofit2.Retrofit

object PersoRepository {

    private var retrofit: Retrofit? = null
    private var api: PersoApi? = null

    init {
        retrofit = ApiClient().getClient()
        api = retrofit?.create(PersoApi::class.java)
    }

    fun getPerso(persoId: Int): Single<Character>? {
        return api?.getPerso(persoId)
    }

    fun makePersoEat(persoId: Int, food: Food): Single<Adventure>? {
        return api?.makePersoEat(persoId, food)
    }
}