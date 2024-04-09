package com.example.uzbekistan.fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uzbekistan.Data.SQLite
import com.example.uzbekistan.R
import com.example.uzbekistan.adapter.showGalleryAdapter
import com.example.uzbekistan.databinding.FragmentGalleryshowBinding
import com.example.uzbekistan.databinding.GalleryshowBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [galleryshow.newInstance] factory method to
 * create an instance of this fragment.
 */
class galleryshow : Fragment() {
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
private lateinit var binding:FragmentGalleryshowBinding
private lateinit var adapter:showGalleryAdapter
private lateinit var list: ArrayList<String>
private lateinit var database:SQLite
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentGalleryshowBinding.inflate(inflater, container, false)
        val rasm = arguments?.getInt("rasm")
        val nomi = arguments?.getString("nomi")
        val malumot=arguments?.getString("malumot")
        database= SQLite(requireContext())
        if (nomi != null) {
            list=ArrayList(database.getDataByString(nomi))
        }

        binding!!.apply {
            image.setImageResource(rasm.toString().toInt())
            text.text= nomi
            description.text=malumot
            adapter=showGalleryAdapter(list)
            galleryrv.adapter=adapter
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment galleryshow.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            galleryshow().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}