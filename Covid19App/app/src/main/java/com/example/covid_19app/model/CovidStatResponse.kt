package com.example.covid_19app.model

data class CovidStatResponse(
	val country: String? = null,
	val recovered: Int? = null,
	val cases: Int? = null,
	val critical: Int? = null,
	val deathsPerOneMillion: Int? = null,
	val active: Int? = null,
	val casesPerOneMillion: Int? = null,
	val deaths: Int? = null,
	val testsPerOneMillion: Int? = null,
	val todayCases: Int? = null,
	val todayDeaths: Int? = null,
	val totalTests: Int? = null
)

