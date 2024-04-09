package com.example.uzbekistan.fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.uzbekistan.R
import com.example.uzbekistan.adapter.viewPager
import com.example.uzbekistan.databinding.FragmentSignBinding
import com.google.android.material.tabs.TabLayout


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SignFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var  viewPageAdapter: viewPager
    private   var binding: FragmentSignBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignBinding.inflate(inflater,container,false)
        binding?.apply {
            viewPageAdapter= viewPager(this@SignFragment)
            viewPager.adapter=viewPageAdapter
            tablyout.addTab(tablyout.newTab().setText("Kirish"))
            tablyout.addTab(tablyout.newTab().setText("Ro'yhatdan o'tish"))
            tablyout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if(tab!=null){
                        viewPager.currentItem=tab.position
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }
            })
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    tablyout.selectTab(tablyout.getTabAt(position))
                }
            })
        }
        return binding?.root
    }
    override fun onDestroy() {
        super.onDestroy()
       binding = null
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            SignFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}