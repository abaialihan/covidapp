@file:Suppress("UNREACHABLE_CODE")

package com.example.covid_19app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.covid_19app.R
import com.example.covid_19app.data.dataPOJO.CovidResponse
import com.example.covid_19app.data.internet.HttpBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StaticFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var spinnerCountry: Spinner
    private lateinit var progressBar: ProgressBar
    private lateinit var flagImageView: ImageView
    private lateinit var totalConfirmedTextView: TextView
    private lateinit var newConfirmedTextView: TextView
    private lateinit var totalDeathTextView: TextView
    private lateinit var newDeathTextView: TextView
    private lateinit var totalRecoveredTextView: TextView
    private lateinit var newRecoveredTextView: TextView

    //лист из названий стран которые мы выбраем в  спиннере
    private val listOfCountry: Array<String> = arrayOf("Kyrgyzstan", "USA", "Russia", "Canada", "Global")
    // id иконок стран собраем  массив что бы связать с позициями списка стран
    private val flagPosition: Array<Int> = arrayOf(R.drawable.ic_kgz, R.drawable.ic_usa, R.drawable.ic_rus, R.drawable.ic_cnd, R.drawable.global)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_static, container, false)
        spinnerCountry = rootView.findViewById(R.id.spinner_country)
        progressBar = rootView.findViewById(R.id.progressBar)
        flagImageView = rootView.findViewById(R.id.flagImageView)
        totalConfirmedTextView = rootView.findViewById(R.id.totalConfirmedTextView)
        newConfirmedTextView = rootView.findViewById(R.id.newConfirmedTextView)
        totalDeathTextView = rootView.findViewById(R.id.totalDeathTextView1)
        newDeathTextView = rootView.findViewById(R.id.newDeathTextView1)
        totalRecoveredTextView = rootView.findViewById(R.id.totalRecoveredTextView)
        newRecoveredTextView = rootView.findViewById(R.id.newRecoveredTextView)

        itemSelect()
        return rootView
    }

    // здесь обрабатываем выбранный item из спиннера
    private fun itemSelect(){
        //создвем адаптер для спинера
        val adapter = activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, listOfCountry) }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // ставим созданный адаптер к спиннеру
        spinnerCountry!!.adapter = adapter

        // ItemSelectedListener для спинера
        spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Toast.makeText(activity, "You selected ${parent?.getItemAtPosition(position).toString()}", Toast.LENGTH_LONG).show()
                //меняем картину в flagImageView по выбору item в спинере
                flagImageView.setImageResource(flagPosition[spinnerCountry.selectedItemPosition])

                val countryName: String = parent?.getItemAtPosition(position).toString()

                progressBar.visibility = View.VISIBLE

                HttpBuilder.getService().getStatByCountry(countryName).enqueue(object : Callback<CovidResponse>{
                    override fun onResponse(call: Call<CovidResponse>, response: Response<CovidResponse>) {
                        if (response.isSuccessful && response.body() != null){
                            Log.i("TAG", "onSuccessful")
                            val dataResponseBody = response.body()
                            progressBar.visibility = View.INVISIBLE

                            totalConfirmedTextView.text = dataResponseBody?.data?.summary?.total_cases.toString()
                            newConfirmedTextView.text = dataResponseBody?.data?.change?.total_cases.toString()
                            totalDeathTextView.text = dataResponseBody?.data?.summary?.deaths.toString()
                            newDeathTextView.text = dataResponseBody?.data?.change?.deaths.toString()
                            totalRecoveredTextView.text = dataResponseBody?.data?.summary?.recovered.toString()
                            newRecoveredTextView.text = dataResponseBody?.data?.change?.recovered.toString()

                        }
                    }

                    override fun onFailure(call: Call<CovidResponse>, t: Throwable) {
                        Log.i("TAG", "onFailure")
                    }
                })

            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StaticFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StaticFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}