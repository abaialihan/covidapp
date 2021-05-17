package com.example.covid_19app.data.internet

import com.example.covid_19app.data.dataPOJO.AllStatResponse
import com.example.covid_19app.data.dataPOJO.CovidStatResponse
import com.example.covid_19app.data.dataPOJO.CovidResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {
    @GET("region")
    fun getGlobalStat(): Call<AllStatResponse>

    @Headers("x-rapidapi-key: 8c204d7268msh9863be3198028dbp18c127jsn56eacae3a12f", "x-rapidapi-host: coronavirus-map.p.rapidapi.com")
    @GET("summary/region")
    fun getStatByCountry(@Query("region") country: String): Call<CovidResponse>

    @GET("countries/russia")
    fun getRussiaStat(): Call<CovidStatResponse>

    @GET("countries/canada")
    fun getCanadaStat(): Call<CovidStatResponse>

    @GET("countries/usa")
    fun getUsaStat(): Call<CovidStatResponse>

}