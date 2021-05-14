package com.example.covid_19app.data.internet

import com.example.covid_19app.data.dataPOJO.AllStatResponse
import com.example.covid_19app.data.dataPOJO.CovidStatResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("countries/world")
    fun getGlobalStat(): Call<AllStatResponse>

    @GET("countries/kyrgyzstan")
    fun getKyrgyzstanStat(): Call<CovidStatResponse>

    @GET("countries/russia")
    fun getRussiaStat(): Call<CovidStatResponse>

    @GET("countries/canada")
    fun getCanadaStat(): Call<CovidStatResponse>

    @GET("countries/usa")
    fun getUsaStat(): Call<CovidStatResponse>

}