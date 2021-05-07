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
import com.example.covid_19app.data.Country

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StaticFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StaticFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var spinnerCountry: Spinner
    private lateinit var flagImageView: ImageView

    //лист из названий стран которые мы выбраем в  спиннере
    val listOfCountry: Array<String> = arrayOf("KGZ", "USA", "RUS", "CND")
    // id иконок стран собраем  массив чтобы связать с позициями списка стран
    val flagPosition: Array<Int> = arrayOf(R.drawable.ic_kgz, R.drawable.ic_usa, R.drawable.ic_rus, R.drawable.ic_cnd)

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
        flagImageView = rootView.findViewById(R.id.flagImageView)
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
                Toast.makeText(activity, "You selected ${parent?.getItemAtPosition(position).toString()}", Toast.LENGTH_LONG).show()
                //меняем картину в flagImageView по выбору item в спинере
                flagImageView.setImageResource(flagPosition[spinnerCountry.selectedItemPosition])
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