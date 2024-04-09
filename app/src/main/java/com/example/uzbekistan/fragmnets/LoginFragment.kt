package com.example.uzbekistan.fragmnets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.uzbekistan.AdminActivity
import com.example.uzbekistan.MainActivity
import com.example.uzbekistan.R
import com.example.uzbekistan.databinding.FragmentLoginBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LoginFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private   var binding: FragmentLoginBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLoginBinding.inflate(inflater,container,false)
        binding?.apply {
            kirish.setOnClickListener {
                binding.apply {
                    if(name.text.toString().lowercase() == "admin" && phoneNumber.text.toString() == "932853874"){
                        val intent=Intent(requireContext(),AdminActivity::class.java)
                        startActivity(intent)
                    }else if (name.text.toString().isNotEmpty() &&  phoneNumber.text.toString().isNotEmpty() ){
                        val intent=Intent(requireContext(),MainActivity::class.java)
                        startActivity(intent)
                    }
                    else Toast.makeText(requireContext(), "Ism yoki telefon raqami xato", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}