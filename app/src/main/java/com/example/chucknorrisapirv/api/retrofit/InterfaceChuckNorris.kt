package com.example.chucknorrisapirv.api.retrofit

import com.example.chucknorrisapirv.models.ChackJokeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface InterfaceChuckNorris {

    @GET("/jokes/search")
    fun getChuckJokesRandom(
        @Query("query") search: String,
        @Header("x-rapidapi-host") host: String = "matchilling-chuck-norris-jokes-v1.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "9e093beaabmsh3c96490565c07d0p134685jsn4fe53e85d579",
        @Header("accept") accept: String = "application/json"

    ): Call<ChackJokeData>




}