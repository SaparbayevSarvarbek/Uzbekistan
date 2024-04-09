package com.example.uzbekistan.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.uzbekistan.fragmnets.LoginFragment
import com.example.uzbekistan.fragmnets.RegisterFragment

class viewPager(fm:Fragment): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return  2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> LoginFragment()
            1-> RegisterFragment()
            else -> Fragment()
        }
    }
}