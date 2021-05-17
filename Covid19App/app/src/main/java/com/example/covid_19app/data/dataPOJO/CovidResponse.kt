package com.example.covid_19app.data.dataPOJO

data class CovidResponse(
	val dataResponse: Data,
	val type: String,
	val status: Int
)

data class Data(
	val summary: Summary,
	val change: Change
)

data class Change(
	val recovered: Int,
	val totalCases: Int,
	val critical: Int,
	val recoveryRatio: Double,
	val tested: Int,
	val activeCases: Int,
	val deaths: Int,
	val deathRatio: Double
)

data class Summary(
	val recovered: Int,
	val totalCases: Int,
	val critical: Int,
	val recoveryRatio: Double,
	val tested: Int,
	val activeCases: Int,
	val deaths: Int,
	val deathRatio: Double
)

