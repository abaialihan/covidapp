package com.example.covid_19app.adapters

import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19app.R
import com.example.covid_19app.data.CovidNewsHttpBuilder
import com.example.covid_19app.models.CovidNewsModel
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class NewsAdapter( private val newsList: ArrayList<CovidNewsModel>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        CovidNewsHttpBuilder.getService().getCovidNews().enqueue(object : Callback<CovidNewsModel>{
            override fun onResponse(
                call: Call<CovidNewsModel>,
                response: Response<CovidNewsModel>
            ) {
                if(response.isSuccessful && response.body() != null){
                    Log.i("TAG", "onSuccessful")
                    val dataResponseBody = response.body()

                    holder.authorTextView.text = dataResponseBody!!.articles[position].author
                    holder.titleTextView.text = dataResponseBody.articles[position].title
                    holder.descripTextView.text = dataResponseBody.articles[position].description
                    holder.publicationTextView.text = dataResponseBody.articles[position].publishedAt.toString()
                    holder.sourceTextView.text = dataResponseBody.articles[position].source.name
                    holder.timeTextView.text = " \u2022 " + Calendar.getInstance()

                    Picasso.get()
                        .load(newsList[position].articles[position].urlToImage)
                        .centerCrop()
                        .into(holder.newsImageView)
                }
            }

            override fun onFailure(call: Call<CovidNewsModel>, t: Throwable) {
                Log.i("TAG", "onFailure")
            }
        })
    }

    override fun getItemCount() = newsList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        var descripTextView: TextView = itemView.findViewById(R.id.descripTextView)
        var authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        var publicationTextView: TextView = itemView.findViewById(R.id.publicationDateTextView)
        var sourceTextView: TextView = itemView.findViewById(R.id.sourceTextView)
        var timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        var newsImageView: ImageView = itemView.findViewById(R.id.newsImageView)
        var progressBar: ProgressBar = itemView.findViewById(R.id.prograss_load_photo)

    }




}