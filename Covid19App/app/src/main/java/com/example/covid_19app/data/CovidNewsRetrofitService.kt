package com.example.covid_19app.data

import com.example.covid_19app.models.CovidNewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDate

interface CovidNewsRetrofitService {
    @GET("everything")
    fun getCovidNews(@Query("q") news: String = "covid",
                     @Query("from") currentDate: LocalDate,
                     @Query("sortBy") sortNews: String = "popularity",
                     @Query("apiKey") apikey: String = "f5b97856cd824e5ea96e42ff76473b2e"): Call<CovidNewsModel>
}