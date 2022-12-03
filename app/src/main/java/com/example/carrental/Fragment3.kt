package com.example.carrental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment3 : Fragment() {
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
        val view4 = inflater.inflate(R.layout.fragment_3, container, false)
        val resultText: TextView = view4.findViewById(R.id.edTextResult)
        val m1:MainActivity = activity as MainActivity;
        val cT = m1.getCarTypef()
        val cM = m1.getCarMakef()
        var price1: Double = 0.0
        var price2: Double = 0.0
        when (cM){
            "Mazda" -> price1 = 30.0
            "Toyota" -> price1 = 25.0
            "Honda" -> price1 = 22.0
        }
        when (cT){
            "Sedan" -> price2 = 10.0
            "Suv" -> price2 = 20.0
            "Coupe" -> price2 = 20.0
        }

        resultText.text="You chose a car of make " + cM + " and of type " + cT +"\nWhich amounts to: " +(price1+price2).toString() +"Jd per Day" +
                "\nWould you like to confirm your order?"

        val btPrev2: Button = view4.findViewById(R.id.btPrev2)
        val btNext2: Button = view4.findViewById(R.id.btNext2)
        btPrev2.setOnClickListener { view ->
            m1.switch1()
        }
        btNext2.setOnClickListener { view ->
            Toast.makeText(context, "Order Confirmed, Thank you!", Toast.LENGTH_SHORT).show()
        }
        return view4
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}