package com.example.chucknorrisapirv.api.controllers

import com.example.chucknorrisapirv.api.retrofit.InterfaceChuckNorris
import com.example.chucknorrisapirv.api.retrofit.getRetrofit

class ChuckServiceImpl {

    fun getChuckJokesRandom(
        search: String
    ) = try {
        Pair(
            getRetrofit().create(InterfaceChuckNorris::class.java).getChuckJokesRandom(
                search = search
            ).execute().body(), null
        )
    } catch (e: java.lang.Exception) {
        Pair(null, e)
    }

}