package com.example.uzbekistan.fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.uzbekistan.Data.SQLite
import com.example.uzbekistan.Data.User
import com.example.uzbekistan.R
import com.example.uzbekistan.databinding.FragmentRegisterBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
private lateinit var database:SQLite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private  var binding:FragmentRegisterBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRegisterBinding.inflate(inflater,container,false)
        database= SQLite(requireContext())
        binding?.apply {
            royhatdanOtish.setOnClickListener {
                if (name.text.toString().isNotEmpty() && familiya.text.toString().isNotEmpty() && phoneNumber.text.toString().isNotEmpty()){
                    val ismi=name.text.toString()
                    val familiyasi=familiya.text.toString()
                    val raqami=phoneNumber.text.toString()
                    val user=User(Ismi = ismi, Familiyasi = familiyasi, telraqami = raqami)
                    database.addUser(user)
                    Toast.makeText(requireContext(), "Ro'yhatdan o'tdingiz", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.signFragment)
                }else Toast.makeText(requireContext(), "Ma'lumot to'iq kiritilmagan", Toast.LENGTH_SHORT).show()  }

        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}