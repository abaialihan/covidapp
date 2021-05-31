package com.example.covid_19app.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CovidNewsModel(

	@SerializedName("totalResults")
	@Expose
	val totalResults: Int,

	@SerializedName("articles")
	@Expose
	val articles: List<ArticlesItem>,

	@SerializedName("status")
	@Expose
	val status: String
)

data class ArticlesItem(

	@field:SerializedName("publishedAt")
	val publishedAt: String,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("urlToImage")
	val urlToImage: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("source")
	val source: Source,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("content")
	val content: String
)

data class Source(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
)
