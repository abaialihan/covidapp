package com.example.covid_19app.data.internet

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object HttpBuilder {

    const val BASE_URL = "https://coronavirus-19-api.herokuapp.com/"

    private var service: RetrofitService? = null

    private fun buildService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }

    public fun getService(): RetrofitService {
        if (service == null) service = buildService()
        return service!!
    }
}