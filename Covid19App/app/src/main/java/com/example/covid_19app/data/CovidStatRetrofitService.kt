package com.example.covid_19app.data

import com.example.covid_19app.data.dataPOJO.CovidStatModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CovidStatRetrofitService {

    @Headers("x-rapidapi-key: 8c204d7268msh9863be3198028dbp18c127jsn56eacae3a12f", "x-rapidapi-host: coronavirus-map.p.rapidapi.com")
    @GET("summary/region")
    fun getStatByCountry(@Query("region") country: String): Call<CovidStatModel>

}