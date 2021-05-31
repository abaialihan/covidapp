package com.example.covid_19app.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CovidStatHttpBuilder {

    private const val BASE_URL = "https://coronavirus-map.p.rapidapi.com/v1/"

    private var service: CovidStatRetrofitService? = null

    private fun buildService(): CovidStatRetrofitService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CovidStatRetrofitService::class.java)
    }

    fun getService(): CovidStatRetrofitService {
        if (service == null) service = buildService()
        return service!!
    }
}