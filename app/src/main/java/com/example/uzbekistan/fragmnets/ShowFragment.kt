package com.example.uzbekistan.fragmnets

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.uzbekistan.Data.city
import com.example.uzbekistan.Data.tuman
import com.example.uzbekistan.R
import com.example.uzbekistan.databinding.FragmentShowBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private  var binding:FragmentShowBinding?=null
class ShowFragment : Fragment() {
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

        binding=FragmentShowBinding.inflate(inflater, container, false)
        val rasm = arguments?.getInt("rasm")
        val nomi = arguments?.getString("nomi")
        val malumot=arguments?.getString("malumot")
         binding!!.apply {
             image.setImageResource(rasm.toString().toInt())
             text.text= nomi
             description.text=malumot
         }
        return binding!!.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}