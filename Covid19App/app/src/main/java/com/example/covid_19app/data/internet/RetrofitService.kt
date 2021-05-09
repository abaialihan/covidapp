package com.example.covid_19app.data.internet

import com.example.covid_19app.model.AllStatResponse
import com.example.covid_19app.model.CovidStatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface RetrofitService {
    @GET("countries")
    fun getGlobalStat(): Call<CovidStatResponse>

    @GET("countries/kyrgyzstan")
    fun getKyrgyzstanStat(): Call<CovidStatResponse>

    @GET("countries/kyrgyzstan")
    fun getRussiaStat(): Call<CovidStatResponse>

    @GET("countries/kyrgyzstan")
    fun getCanadaStat(): Call<CovidStatResponse>

    @GET("countries/kyrgyzstan")
    fun getUsaStat(): Call<CovidStatResponse>


}