package com.example.uzbekistan.fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.uzbekistan.R
import com.example.uzbekistan.databinding.FragmentAdminBinding
import java.util.zip.Inflater

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AdminFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private  var binding:FragmentAdminBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentAdminBinding.inflate(inflater,container,false)

        return binding!!.root
    }

    override fun onStart() {
        super.onStart()
        binding!!.apply {
            add.setOnClickListener {
                findNavController().navigate(R.id.adminAddFragment)
            }
            list.setOnClickListener {
                findNavController().navigate(R.id.adminListFragment)
            }
            chiqish.setOnClickListener {
                findNavController().navigate(R.id.signFragment2)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}