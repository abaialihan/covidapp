package com.example.covid_19app.data.dataPOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CovidStatModel(
	@SerializedName("data")
	@Expose
	val data: Data,
	val type: String,
	val status: Int
)

data class Data(
	val summary: Summary,
	val change: Change
)

data class Change(
	val recovered: Int,
	val total_cases: Int,
	val critical: Int,
	val recovery_ratio: Double,
	val tested: Int,
	val active_cases: Int,
	val deaths: Int,
	val death_ratio: Double
)

data class Summary(
	val recovered: Int,
	val total_cases: Int,
	val critical: Int,
	val recovery_ratio: Double,
	val tested: Int,
	val active_cases: Int,
	val deaths: Int,
	val death_ratio: Double
)

