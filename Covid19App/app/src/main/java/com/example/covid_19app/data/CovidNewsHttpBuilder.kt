package com.example.covid_19app.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CovidNewsHttpBuilder {

    private const val BASE_URL = "https://newsapi.org/v2/"
    private var service: CovidNewsRetrofitService? = null

    private fun buildService(): CovidNewsRetrofitService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CovidNewsRetrofitService::class.java)
    }

    fun getService(): CovidNewsRetrofitService{
        if (service == null) service = buildService()
        return service!!
    }
}