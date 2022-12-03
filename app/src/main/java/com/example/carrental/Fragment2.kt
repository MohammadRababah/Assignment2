package com.example.carrental

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view3= inflater.inflate(R.layout.fragment_2, container, false)
        val btNext1: Button = view3.findViewById(R.id.btNext1)
        val btPrev1: Button = view3.findViewById(R.id.btPrev1)
        val spCarType: Spinner = view3.findViewById(R.id.spCarType)
        val spCarMake: Spinner = view3.findViewById(R.id.spCarMake)
        val optionsMake= arrayOf("Please Select a Car Make:", "Mazda", "Toyota", "Honda")
        val optionsType= arrayOf("Please Select a Car Type:", "Sedan", "Coupe", "Suv")

        spCarMake.adapter=
            context?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_list_item_1,
                    optionsMake
                )
            }
        spCarType.adapter=
            context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, optionsType) }

        var flag1= "nothing"
        var flag2= "nothing"

        spCarMake.onItemSelectedListener= object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag1= optionsMake.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spCarType.onItemSelectedListener= object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag2= optionsType.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        btNext1.setOnClickListener {
            val m1:MainActivity = activity as MainActivity;
            if (flag1=="Please Select a Car Make:" || flag2=="Please Select a Car Type:"){
                Toast.makeText(context, "Invalid Selection", Toast.LENGTH_SHORT).show()
            }
            else{
                m1.switch2(flag1, flag2)
            }
        }

        btPrev1.setOnClickListener {
            val m1:MainActivity = activity as MainActivity;
            m1.switch2prev()
        }
        return view3
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}