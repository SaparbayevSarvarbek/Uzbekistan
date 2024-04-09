package com.example.uzbekistan.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uzbekistan.Data.city
import com.example.uzbekistan.Data.tuman
import com.example.uzbekistan.R
import com.example.uzbekistan.adapter.gallaeryAdapter
import com.example.uzbekistan.databinding.FragmentGalleryBinding
import com.example.uzbekistan.fragmnets.ShowFragment

class GalleryFragment : Fragment(), gallaeryAdapter.onClick {

    private var _binding: FragmentGalleryBinding? = null

    private val binding get() = _binding!!
    private lateinit var list: ArrayList<tuman>
    private lateinit var gallaeryAdapter: gallaeryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadData()
        gallaeryAdapter = gallaeryAdapter(list, this)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {
            rv.adapter = gallaeryAdapter
            rv.layoutManager = GridLayoutManager(requireContext(), 2)
            search.setOnQueryTextListener(object :
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    val text = newText!!.lowercase()
                    if (text != null) {
                        val filter = ArrayList<tuman>()
                        for (i in list) {
                            if (i.TumanNomi.lowercase().contains(text)) {
                                filter.add(i)
                            }
                        }
                        if (filter.isEmpty()) {
                            Toast.makeText(
                                requireContext(),
                                "Ma'lumot topilmadi",
                                Toast.LENGTH_SHORT
                            ).show()
                            gallaeryAdapter.setFilterListener(filter)
                        } else {
                            gallaeryAdapter.setFilterListener(filter)
                        }
                    }
                    return true
                }
            })
        }
        return root
    }

    private fun loadData() {
        list = ArrayList()
        list.add(tuman("Toshkent", R.drawable.toshkent,"• Hokim : Shavkat Umrzoqov\n" +
                "Maydon : 334.8 km2 (129.3 mi²)\n" +
                "Markazi balandligi : 455 m\n" +
                "Rasmiy til(lar)i : o'zbekcha\n" +
                "Aholisi (2023) : 3 млн 20,5 минг \n" +
                "Zichligi : 8000.5 kishi/km2\n" +
                "Vaqt mintaqasi : UTC+5"))
        list.add(tuman("Toshkent viloyati", R.drawable.toshkentviloyati,"Maʼmuriy markazi : Nurafshon\n" +
                "Hokim : Zoir Mirzayev \n" +
                "Aholi (2022) : 2 931 000 (4-oʻrin)\n" +
                "Dinlar tarkibi : musulmonlar\n" +
                "Maydoni : 15,300 km²\n" +
                "Vaqt mintaqasi : UTC+5\n" +
                "Kod ISO 3166-2 : tUZ-TO\n" +
                "Rasmiy sayti : https://toshvil.uz/"))
        list.add(tuman("Qoraqalpog'iston ", R.drawable.qoraqalpogistonviloyat,"Tarkibida : 16 tuman va Nukus shahri\n" +
                "Maʼmuriy markazi : Nukus\n" +
                "Asos solingan sanasi : 1924-yil 14-oktabr\n" +
                "Qoraqalpogʻiston respublikasi Joqarg'ı Ken'esi raisi\tOrinbayev Amanbay Tleubayevich\n" +
                "Rasmiy tillar : Qoraqalpoq tili, Oʻzbek tili\n" +
                "Aholi (2021) : 2 000 000  (9-oʻrin)\n" +
                "Maydoni : 166 600 km²\n" +
                "Vaqt mintaqasi : UTC+5"))
        list.add(tuman("Buxoro viloyati", R.drawable.buxoroviloyati,"Maʼmuriy markazi : Buxoro\n" +
                "Yirik shahari : Buxoro\n" +
                "Aholi : 870 200 \n" +
                "Dinlar tarkibi : musulmonlar, xristianlar\n" +
                "Maydoni : 39 400 km²\n" +
                "Vaqt mintaqasi : UTC+5\n" +
                "Kod ISO 3166-2 : UZ-BU\n"))
        list.add(tuman("Andijon viloyati", R.drawable.andijonviloyati,"Tarkibida: 14 tuman, 2 ta shahar (Andijon va Xonobod shaharlari)\n" +
                "Maʼmuriy markazi : Andijon\n" +
                "Yirik shahari :Andijon shahri\n" +
                "Hokim : Shuhratbek Abdurahmonov\n" +
                "Aholi : 3 338 200 \n" +
                "Maydoni : 4303 km²\n" +
                "Vaqt mintaqasi : UTC+5\n" +
                "Rasmiy sayti : andijon.uz"))
        list.add(tuman("Xorazm viloyati", R.drawable.xorazmviloyat,"Maʼmuriy markazi : Urganch\n" +
                "Hokim : Joʻrabek Rahimov\n" +
                "Aholi : 1,924,167\n" +
                "Maydoni : 6 050 km²\n" +
                "Avtomobil raqami kodi : 90\n" +
                "Rasmiy sayt i: xorazm.uz"))
        list.add(tuman("Samarqand viloyati", R.drawable.samarqandviloyat,"Maʼmuriy markazi : Samarqand\n" +
                "Yirik shaharlari : Samarqand, Kattaqoʻrgʻon.\n" +
                "Hokim : tErkinjon Turdimov\n" +
                "Aholi : 4 077 000\n" +
                "Vaqt mintaqasi : UTC+5\n" +
                "Avtomobil raqami kodi : 30-39\n" +
                "Rasmiy sayti : samarkand.uz"))
        list.add(tuman("Qashqadaryo viloyati", R.drawable.qoraqalpogistonviloyat,"Tarkibida : 14 ta tuman, 1 ta shahar\n" +
                "Maʼmuriy markazi : Qarshi\n" +
                "Yirik shaharlari : Qarshi, Shahrisabz, Kitob, Gʻuzor, Yakkabogʻ\n" +
                "Hokim : Murodjon Azimov\n" +
                "Aholi : 3,408,300\n" +
                "Maydoni : 28,6 km²\n" +
                "Vaqt mintaqasi : UTC+5"))
        list.add(tuman("Jizzax viloyati", R.drawable.jizzaxviloyati,"Maʼmuriy markazi : Jizzax\n" +
                "Yirik shaharlari : Jizzax, G'allaorol, Gagarin, Paxtakor,Zarbdor, Zomin.\n" +
                "Asos solingan sanasi : 1935-yil\n" +
                "Hokim : Ergash Saliyev\n" +
                "Maydoni : 21200 km²\n" +
                "Vaqt mintaqasi : UTC+5\n" +
                "Rasmiy sayti : jizzax.uz"))
        list.add(tuman("Navoiy viloyati", R.drawable.navoiyviloyati,"Maʼmuriy markazi : Navoiy shahri\n" +
                "Yirik shahari : Navoiy shahri\n" +
                "Asos solingan sanasi : 1982-yil\n" +
                "Hokim : Normat Tursunov[1]\n" +
                "Aholi : 1 million (4-oʻrin)\n" +
                "Maydoni : 111,100 km²\n" +
                "Vaqt mintaqasi : UTC+5\n" +
                "Rasmiy sayti : http://navoi.uz/"))
        list.add(tuman("Surxandaryo viloyati", R.drawable.surxandaryoviloyati,"Maʼmuriy markazi : Termiz\n" +
                "Yirik shahari : Termiz\n" +
                "Asos solingan sanasi : 1941-yil 6-mart\n" +
                "Hokim : Ulugʻbek Qosimov[1]\n" +
                "Aholi (2023-yil 1-aprel holatiga) : 2 821 900 \n" +
                "Maydoni : 20,1 ming km2 km²\n" +
                "Rasmiy sayti : surxondaryo.uz"))
        list.add(tuman("Namangan viloyati", R.drawable.namanganviloyati,"Maʼmuriy markazi : Namangan\n" +
                "Rasmiy tillar : oʻzbek\n" +
                "Aholi : 2 931 045 \n" +
                "Maydoni : 7900 km²\n" +
                "Vaqt mintaqasi : UTC+5\n" +
                "Rasmiy sayti : namangan.uz"))
        list.add(tuman("Sirdaryo viloyati", R.drawable.sirdaryoviloyati,"Maʼmuriy markazi : Guliston shahri\n" +
                "Yirik shaharlari : Yangiyer, Sirdaryo, Shirin\n" +
                "Asos solingan sanasi : 1963-yil\n" +
                "Viloyat hokimi : Akmaljon Mahmudaliyev\n" +
                "Aholi (2022) : 900 mingga yaqin (14-oʻrin)\n" +
                "Maydoni : 4.28 ming km² \n" +
                "Vaqt mintaqasi : UTC+5"))
        list.add(tuman("Farg'ona viloyati", R.drawable.fargonaviloyati,"Maʼmuriy markazi : Fargʻona\n" +
                "Yirik shaharlari : Fargʻona, Qoʻqon, Margʻilon, Quvasoy Xamza\n" +
                "Asos solingan sanasi : 1938-yil\n" +
                "Hokim : Xayrulla Bozorov\n" +
                "Aholi  : 3,817,000  (2-oʻrin)\n" +
                "Zichligi : 474,88 kishi./km²\n" +
                "Maydoni : 6 800 km² (10-oʻrin)\n" +
                "Vaqt mintaqasi : UTC+5\n"+
                "Rasmiy sayti : http://ferghana.uz/"))
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        val bundle = Bundle()
        bundle.putString("nomi", list[position].TumanNomi)
        bundle.putInt("rasm", list[position].tumanRasm)
        bundle.putString("malumot",list[position].malumot)
        val showFragment = ShowFragment()
        showFragment.arguments = bundle
        findNavController().navigate(R.id.galleryshow, bundle)
    }
}