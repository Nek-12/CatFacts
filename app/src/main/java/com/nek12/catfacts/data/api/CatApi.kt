package com.nek12.catfacts.data.api

import com.nek12.catfacts.data.api.model.GetCatFactResponse
import retrofit2.http.GET

interface CatApi {

    @GET("/fact")
    suspend fun randomFact(): GetCatFactResponse
}
