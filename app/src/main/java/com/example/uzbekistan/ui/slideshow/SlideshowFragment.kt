package com.example.uzbekistan.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.uzbekistan.adapter.extebleAdapter
import com.example.uzbekistan.databinding.FragmentSlideshowBinding

private lateinit var list: ArrayList<String>
private lateinit var map: HashMap<String, List<String>>
private lateinit var Adapter: extebleAdapter
private lateinit var filter:ArrayList<String>
private lateinit var filtermap :HashMap<String,List<String>>

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadData()
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        Adapter = extebleAdapter(requireContext(),map, list)
        binding.expandview.setAdapter(Adapter)
        binding.searchview.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val text=newText!!.lowercase()
                filter=ArrayList()
                filtermap=HashMap()
                if (!text.isEmpty()){
                    for (m in map.keys){
                        if (m.contains(newText)){
                            filter= ArrayList(map.keys)
                            filtermap[m] = filter
                        }
                    }
                    if (filtermap.isEmpty()){
                        Toast.makeText(requireContext(),"Ma'lumot topilmadi", Toast.LENGTH_SHORT).show()
                        Adapter.setFilterListener(filter,filtermap)
                    }else{
                        Adapter.setFilterListener(filter,filtermap)
                    }
                }

                return true
            }

        })
        return root
    }

    private fun loadData() {
        list = ArrayList()
        map = HashMap()
        val list1=ArrayList<String>()
        list1.add("1. Bog'ot tumani")
        list1.add("2. Gurlan tumani")
        list1.add("3. Xonqa tumani")
        list1.add("4. Hazorasp tumani")
        list1.add("5. Xiva tumani")
        list1.add("6. Qo'shko'pir tumani")
        list1.add("7. Shovot tumani")
        list1.add("8. Urganch tumani")
        list1.add("9. Yangiariq tumani")
        list1.add("10. Yangibozor tumani")
        list1.add("11. Tuproqqal'a tumani")
        map["Xorazm viloyati"] = list1
        val list2=ArrayList<String>()
        list2.add("1. Konimerx tumani")
        list2.add("2. Karmana tumani")
        list2.add("3. Qiziltepa tumani")
        list2.add("4. Xatirchi tumani")
        list2.add("5. Navbahor tumani")
        list2.add("6. Nurota tumani")
        list2.add("7. Tomdi tumani")
        list2.add("8. Uchquduq tumani")
        map["Navoiy viloyati"] = list2
        val list3=ArrayList<String>()
        list3.add("1. Amudoaryo tumani")
        list3.add("2. Berunit tumani")
        list3.add("3. Chimboy tumani")
        list3.add("4. Ellikqal'a tumani")
        list3.add("5. Kegeyli tumani")
        list3.add("6. Mo'ynoq tumani")
        list3.add("7. Nukus tumani")
        list3.add("8. Qanilko'l tumani")
        list3.add("9. Qo'ng'irot tumani")
        list3.add("10. Qorao'zak tumani")
        list3.add("11. Shumanay tumani")
        list3.add("12. Taxtako'pir tumani")
        list3.add("13. To'rtko'l tumani")
        list3.add("14. Xo'jayli tumani")
        list3.add("15. Taxiatosh tumani")
        list3.add("16. Bo'zatov tumani")
        map["Qoraqalpog'iston Respublikasi"] = list3
        val list4=ArrayList<String>()
        list4.add("1. Olot tumani")
        list4.add("2. Buxoro tumani")
        list4.add("3. Gijduvon tumani")
        list4.add("4. Jondor tumani")
        list4.add("5. Kogon tumani")
        list4.add("6. Qorako'l tumani")
        list4.add("7. Qorovulbozor tumani")
        list4.add("8. Peshku tumani")
        list4.add("9. Romitan tumani")
        list4.add("10. Shofikon tumani")
        list4.add("11. Vobkent tumani")
        map["Buxoro viloyati"] = list4
        val list5=ArrayList<String>()
        list5.add("1. Bulung'ur tumani")
        list5.add("2. Ishtixon tumani")
        list5.add("3. Jomboy tumani")
        list5.add("4. Kattaqo'rg'on tumani")
        list5.add("5. Qo'shrabot tumani")
        list5.add("6. Narpay tumani")
        list5.add("7. Nurobod tumani")
        list5.add("8. Oqdaryo tumani")
        list5.add("9. Paxtachi tumani")
        list5.add("10. Payariq tumani")
        list5.add("11. Toyloq tumani")
        list5.add("12. Samarqand tumani")
        list5.add("13. Urgut tumani")
        map["Samarqand viloyati"] = list5
        val list6=ArrayList<String>()
        list6.add("1. Chiroqchi tumani")
        list6.add("2. Dehqonobod tumani")
        list6.add("3. G'uzor tumani")
        list6.add("4. Qamashi tumani")
        list6.add("5. Qarshi tumani")
        list6.add("6. Koson tumani")
        list6.add("7. Kasbi tumani")
        list6.add("8. Kitob tumani")
        list6.add("9. Mirshkor tumani")
        list6.add("10. Muborak tumani")
        list6.add("11. Nishon tumani")
        list6.add("12. Shahrisabz tumani")
        list6.add("13. Yakkabog' tumani")
        list6.add("14. Ko'kdala tumani")
        map["Qashqadaryo viloyati"] = list6
        val list7=ArrayList<String>()
        list7.add("1. Angor tumani")
        list7.add("2. Boysun tumani")
        list7.add("3. Denov tumani")
        list7.add("4. Jarqo'rg'on tumani")
        list7.add("5. Qiziriq tumani")
        list7.add("6. Qumqo'rg'on tumani")
        list7.add("7. Muzrabot tumani")
        list7.add("8. Oltinsoy tumani")
        list7.add("9. Sariosiyo tumani")
        list7.add("10. Sherobod tumani")
        list7.add("11. Sho'rchi tumani")
        list7.add("12. Termiz tumani")
        list7.add("13. Uzun tumani")
        map["Surxandaryo viloyati"] = list7
        val list8=ArrayList<String>()
        list8.add("1. Arnasoy tumani")
        list8.add("2. Baxmal tumani")
        list8.add("3. Do'stlik tumani")
        list8.add("4. Forish tumani")
        list8.add("5. G'allaorol tumani")
        list8.add("6. Sharof Rashidov tumani")
        list8.add("7. Mirzachol tumani")
        list8.add("8. Paxtakor tumani")
        list8.add("9. Yangiobod tumani")
        list8.add("10. Zomin tumani")
        list8.add("11. Zafarobod tumani")
        list8.add("12. Zarbdor tumani")
        map["Jizzax viloyati"] = list8
        val list9=ArrayList<String>()
        list9.add("1. Oqoltin tumani")
        list9.add("2. Boyovut tumani")
        list9.add("3. Guliston tumani")
        list9.add("4. Xovos tumani")
        list9.add("5. Mirzaobod tumani")
        list9.add("6. Sayxunobod tumani")
        list9.add("7. Sardoba tumani")
        list9.add("8. Yangiyer tumani")
        list9.add("10. Shirin tumani")
        list9.add("11. Guliston tumani")
        map["Sirdaryo viloyati"] = list9
        val list10=ArrayList<String>()
        list10.add("1. Bekobod tumani")
        list10.add("2. Bo'stonliq tumani")
        list10.add("3. Chinoz tumani")
        list10.add("4. Qibray tumani")
        list10.add("5. Ohangaron tumani")
        list10.add("6. Oqqo'rg'on tumani")
        list10.add("7. Parkent tumani")
        list10.add("8. Piskent tumani")
        list10.add("9. Quyi chirchiq tumani")
        list10.add("10. O'rta chirchiq tumani")
        list10.add("11. Yangiyo'l tumani")
        list10.add("12. Yuqori Chirchiq tumani")
        list10.add("13. Zangiota tumani")
        map["Toshkent viloyati"] = list10
        val list11=ArrayList<String>()
        list11.add("1. Chortoq tumani")
        list11.add("2. Chust tumani")
        list11.add("3. Kosonsoy tumani")
        list11.add("4. Mingbuloq tumani")
        list11.add("5. Namangan tumani")
        list11.add("6. Norin tumani")
        list11.add("7. Pop tumani")
        list11.add("8. To'raqo'rg'on tumani")
        list11.add("9. Uchqo'rg'on tumani")
        list11.add("10. Uychi tumani")
        list11.add("Yangiqo'rg'on tumani")
        map["Namangan viloyati"] = list11
        val list12=ArrayList<String>()
        list12.add("1. Oltiariq tumani")
        list12.add("2. Bag'dod tumani")
        list12.add("3. Beshariq tumani")
        list12.add("4. Buvayda tumani")
        list12.add("5. Dang'ara tumani")
        list12.add("6. Fargo'na tumani")
        list12.add("7. Furqat tumani")
        list12.add("8. Furqat tumani")
        list12.add("9. Qo'shtepa tumani")
        list12.add("10. Quva tumani")
        list12.add("11. Rishton tumani")
        list12.add("12. Sho'x tumani")
        list12.add("13. Toshloq tumani")
        list12.add("14. Uchko'prik tumani")
        list12.add("15. O'zbekiston tumani")
        list12.add("16. Yozyovon tumani")
        list12.add("17. Quvasoy tumani")
        map["Farg'ona viloyati"] = list12
        val list13=ArrayList<String>()
        list13.add("1. Andijon tumani")
        list13.add("2. Asaka tumani")
        list13.add("3. Baliqchi tumani")
        list13.add("4. Bo'ston tumani")
        list13.add("5. Buloqboshi tumani")
        list13.add("6. Izboskan tumani")
        list13.add("7. Jalaquduq tumani")
        list13.add("8. Xo'jaobod tumani")
        list13.add("9. Qo'rg'ontepa tumani")
        list13.add("10. Marhamat tumani")
        list13.add("11. Oltinko'l tumani")
        list13.add("12. Paxtaobod tumani")
        list13.add("13. Shahrixon tumani")
        list13.add("14. Ulug'nor tumani")
        map["Andijon viloyati"] = list13
        val list14=ArrayList<String>()
        list14.add("1. Bektemir tumani")
        list14.add("2. Chilonzor tumani")
        list14.add("3. Hamza tumani")
        list14.add("4. Mirobod tumani")
        list14.add("5. Mirzo Ulug'bek tumani")
        list14.add("6. Sergeli tumani")
        list14.add("7. Shayxontohur tumani")
        list14.add("8. Olmazor tumani")
        list14.add("9. Uchtepa tumani")
        list14.add("10. Yakkasaroy tumani")
        list14.add("11. Yangihayot tumani")
        map["Toshkent shahri"] = list14
        list = ArrayList(map.keys)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}