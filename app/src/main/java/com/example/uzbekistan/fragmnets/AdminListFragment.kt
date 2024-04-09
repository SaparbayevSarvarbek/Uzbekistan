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
import com.example.uzbekistan.adapter.AdminRv
import com.example.uzbekistan.databinding.AdminitemviewBinding
import com.example.uzbekistan.databinding.FragmentAdminListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AdminListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private lateinit var binding: FragmentAdminListBinding
    private lateinit var adminRv: AdminRv
    private lateinit var database: SQLite
    private lateinit var list:ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminListBinding.inflate(inflater, container, false)
        database = SQLite(requireContext())
         list = ArrayList(database.userlist())
        adminRv = AdminRv(list)
        binding.rv.adapter=adminRv
        binding.back.setOnClickListener{
            findNavController().navigate(R.id.adminFragment2)
        }
        return binding.root
    }
}