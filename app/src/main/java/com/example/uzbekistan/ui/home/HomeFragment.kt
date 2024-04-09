package com.example.uzbekistan.ui.home


import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uzbekistan.Data.city
import com.example.uzbekistan.R
import com.example.uzbekistan.adapter.Rvadapter
import com.example.uzbekistan.databinding.FragmentHomeBinding
import com.example.uzbekistan.fragmnets.ShowFragment
import java.util.zip.Inflater
import android.view.Menu as Menu


class HomeFragment : Fragment(),Rvadapter.MyClickListener {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var list: ArrayList<city>
    private lateinit var rvadapter: Rvadapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadData()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        rvadapter = Rvadapter(list,this)
        binding.apply {
            rv.adapter = rvadapter
            rv.layoutManager = GridLayoutManager(requireContext(), 2)

            search.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    val text=newText!!.lowercase()
                    if (text!=null){
                        val filter=ArrayList<city>()
                        for (i in list){
                            if (i.Nomi.lowercase().contains(text)){
                                filter.add(i)
                            }
                        }
                        if (filter.isEmpty()){
                            Toast.makeText(requireContext(),"Ma'lumot topilmadi", Toast.LENGTH_SHORT).show()
                            rvadapter.setFilterListener(filter)
                        }else{
                            rvadapter.setFilterListener(filter)
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
        list.add(city("Toshkent", R.drawable.toshkent,"Toshkent – O‘zbekistonning poytaxti va shu bilan birga Markaziy Osiyodagi eng yirik shahardir. Toshkent shahrida 12 ta tuman bor.\n" +
                "Toshkentda tashrif uchun bir necha kun kerak bo‘ladigan diqqatga sazovor joylarning ro‘yxati juda katta.\n" +
                "\n" +
                "✔️ sayr qilish uchun keng va yashil xiyobonlar,   favvoralar va ekologik bog‘lar;\n" +
                "\n" +
                "✔️ Shahardagi ko‘plab muzeylarda O‘rta Osiyo xalqlari tarixi va madaniyati haqidagi noyob asarlar;\n" +
                "\n" +
                "✔️Buyuk me'moriy ansambllar, masjidlar va minoralar;\n" +
                "\n" +
                "✔️ Har didga mos teatr va galereyalar."))
        list.add(city("Samarqand", R.drawable.samarqand,"Samarqandning madaniy merosi juda katta. Аsrlar davomida bu shahar Buyuk Ipak yo'lining asosiy markazi bo'lib kelgan.\n" +
                "XXI asr boshlarida shahar YuNESKOning Umumjahon merosi ro'yxatiga \"Samarqand - madaniyatlar chorrahasi\" nomi bilan kiritildi!"))
        list.add(city("Xiva", R.drawable.xiva,"Xiva - qadimiy devorlar, minoralar va loydan qurilgan betakror binolar shahri.\n" +
                "Islom hamkorlik tashkilotining (IHT) Bokuda boʻlib oʻtgan XI sessiyasi doirasida Xiva 2024-yilda islom olamining turistik poytaxti deb eʼlon qilindi!\n"+"Xivaning yoshi 2500 yildan oshgan.\n" +
                "Qadimgi Xiva YUNESKOning Butunjahon merosi ro‘yxatiga kiritilgan. Va shunga ko‘ra, barcha diqqatga sazovor joylar dunyo tashkilotining himoyasi ostiga olingan.\n" +
                "\n" +
                "Xivada nimani ko‘rishingiz mumkin:\n" +
                "\n" +
                "✔️ Asosiy qalʼa - Ichan-Qalʼa, Kunya-Ark qalʼasi, Dishan-Qalʼa;\n" +
                "\n" +
                "✔️ Xivada yuzdan ortiq qadimiy  minoralar, maqbaralar, masjid va madrasalar mavjud;\n" +
                "\n" +
                "✔️Xiva hukmdorlarining saroylari va turar joylari;\n" +
                "\n" +
                "✔️ Qadimiy karvonsaroylar va hammomlar;\n" +
                "\n" +
                "✔️ Davlat qo‘g‘irchoq teatri va Avesto muzeyi."))
        list.add(city("Shahrisabz", R.drawable.shahrisabiz,"Shahrisabz - O‘zbekistonning qadimiy va go‘zal shaharlaridan biri bo'lib, tarixiy markazi YUNESKOning Butunjahon madaniy merosi ro‘yxatiga kiritilgan \n Buyuk sarkarda Amir Temur shu shaharda tug‘ilgan.\n" +
                "Shahrisabzda nimani ko‘rishingiz mumkin:\n" +
                "\n" +
                "✔️ qadimgi Oqsaroyning xarobalari,\n" +
                "\n" +
                "✔️ Ko‘k gumbaz masjidi,\n" +
                "\n" +
                "✔️ Dor ut-Tilovat yodgorlik majmuasi,\n" +
                "\n" +
                "✔️ Dorus-Saodat, Shamsad-Din Kulyal, Gumbazi-Seyidon maqbaralari."))
        list.add(city("Buxoro", R.drawable.buxoro,"Muqaddas Buxoro O‘zbekistonning sayyohlik durdonalaridan biridir.  Tarixiy shahar markazi YUNESKOning Butunjahon merosi ro‘yxatiga kiritilgan. Shaharning yoshi  2500 yildan  oshgan.\n" +
                "Qadimiy sharqona ertakning muhitiga tushib qolishni istasangiz, Buxoroning eng diqqatga sazovor joylarini ziyorat qiling:\n" +
                "\n" +
                "✔️Poi-Kalon meʼmoriy yodgorlik, (Shanxay Hamkorlik Tashkiloti tomonidan \"sakkizinchi mo''jiza\" sifatida tan olingan);\n" +
                "\n" +
                "✔️Ark qalʼasi;\n" +
                "\n" +
                "✔️ Somoniylar maqbarasi;\n" +
                "\n" +
                "✔️ Chashmai Ayub maqbarasi;\n" +
                "\n" +
                "✔️ Magaki-Attari masjidi.\n" +
                "\n" +
                "✔️ Mirzo Ulug‘bek madrasasi,\n" +
                "\n" +
                "✔️ Miri-Arab madrasasi,\n" +
                "\n" +
                "✔️ Lyabi-Xauz ansambli va boshqalar"))
        list.add(city("Zomin", R.drawable.zomin,"Ajoyib landshaftlar va toza tog‘ havosi, flora va faunaning  xilma-xilligi, qadimiy ziyoratgohlar va noyob milliy sihatgoh - bularning barchasi Zomin.\n" +
                "Zominda nimani ko‘rish mumkin?\n" +
                "\n" +
                "✔️ Katta hududda joylashgan Zomin davlat tog‘ archa qo‘riqxonasi va uning tarkibiga kiradigan Baxmal o‘rmon xo‘jaligi, Zomin o‘rmon xo‘jaligi, umumiy maydoni 26840 ga. teng bo‘lgan Zomin milliy tabiiy bog‘i;\n" +
                "\n" +
                "✔️ Kristall ko‘llar\n" +
                "\n" +
                "Nurota tizmalari o‘zining janubiy, qisman g‘arbiy va vohasining bir qismini o‘rab, moʻtadil iqlimni taʼminlaydi, shuningdek, mintaqaning shimolidagi Aydar-Arnasay ko‘llar tizimiga relyef va tabiiy go‘zallikning o‘ziga xosligini beradi;\n" +
                "\n" +
                "✔️ Milliy sihatgoh - \"Zomin\" sanatoriysi\n" +
                "\n" +
                "Zomin milliy bog‘ida dengiz sathidan 2 ming metr balandlikda “Zomin” sihatgohi joylashgan.\n" +
                "\n" +
                "Eng toza havo, tog‘li landshaftlar, ignabargli o‘simliklar - bularning barchasi kattalar va bolalarga tibbiy muolajalar o‘tqazish uchun eng yaxshi sharoit hisoblanadi.\n" +
                "\n" +
                "✔️ Qadimiy ziyoratgohlar va Parpi Oyim majmuasi."),)
        list.add(city("Termiz", R.drawable.termiz,"O‘zbekistonning ko‘plab shaharlari kabi Termizda ham amaliy sanʼatning barcha turlari bo‘yicha har xil ustalarni topishingiz mumkin."))
        list.add(city("Guliston", R.drawable.guliston,"Eng mashhur diqqatga sazovor joylar\n" +
                "Guliston kichkina shahar, ammo ajablanarli darajada yorqin, mehmondo‘st va qiziqarli.\n" +
                "\n" +
                "Shaharda ko‘rishingiz mumkin:\n" +
                "\n" +
                "✔️ Asosiy shahar maydoni,\n" +
                "\n" +
                "✔️ Guliston shahar bog'i,\n" +
                "\n" +
                "✔️ O'lkashunoslik muzeyi,\n" +
                "\n" +
                "✔️ Yo'l bo'yida va milliy taomlar bilan ta'minlangan shahar kafelari."))
        list.add(city("Nukus", R.drawable.nukus,"Nukus shahrida zamonaviy yodgorliklarni va binolarni ko‘rishingiz mumkin.\n" +
                "\n" +
                "Shahar hayoti voqealarga to‘la bo‘lganligi sababli, sanʼat ixlosmandlari va sarguzasht qidiruvchilarni o‘ziga jalb qiladi.\n" +
                "\n" +
                "Nukusga tashrif buyurganingizda quyidagilarni ko‘rishni tavsiya qilamiz:\n" +
                "\n" +
                "✔️ Amir Temur nomidagi shahar bog‘i,\n" +
                "\n" +
                "✔️ Do‘slik xiyoboni va bosh maydon,\n" +
                "\n" +
                "✔️ Savitskiy nomidagi sanʼat muzeyi,\n" +
                "\n" +
                "✔️ Berdax milliy muzeyi."))
        list.add(city("Namangan", R.drawable.namangan,"\"Gullar shahri\" Namangan o'zining tarixiy lazzati, shinam ko'chalari va eski binolari bilan ajralib turadi. Bu erda bir qavatli an'anaviy uylar va g'ayrioddiy binolarni topishingiz mumkin:\n" +
                "\n" +
                "✔️ Mulla-Qirgiz madrasasi;\n" +
                "\n" +
                "✔️ Namangani maqbarasi;\n" +
                "\n" +
                "✔️ Afsona bog'i;\n" +
                "\n" +
                "✔️ Bobur nomidagi madaniyat va istirohat bog'i;\n" +
                "\n" +
                "✔️ Xo'ja Amin Kabri maqbarasi;\n" +
                "\n" +
                "✔️ Mavlon-Buva majmuasi."))
        list.add(city("Qarshi", R.drawable.qarshi,"Qadimiy Qarshi shahri 2006 yilda YUNESKO shafeligida 2700 yillik yubileyini nishonladi. Buyuk Aleksandr Makedonskiy bu yerda bo‘lgan. Afsonada aytilishicha, shaharda mashhur jasur va so‘g‘d harbiy qo‘mondoni Spitamen tug‘ilgan. Uning jasoratidan Makedonskiy hayratda qoldi. Shaharda turar-joy binolari va shahar infratuzilmasi bilan birgalikda bir nechta qadimiy ibodat joylarini ko‘rishingiz mumkin.\n" +
                "\n" +
                "✔️ Abu Ubayd ibn Jarrohning yodgorlik majmuasi;\n" +
                "\n" +
                "✔️ Qarshi ko‘prigi;\n" +
                "\n" +
                "✔️ Odina madrasasi va masjidi;\n" +
                "\n" +
                "✔️ Ko‘k-Gumbaz masjidi;\n" +
                "\n" +
                "✔️ Kulichboy madrasasi;\n" +
                "\n" +
                "✔️ Xuja Abdulaziz madrasasi;\n" +
                "\n" +
                "✔️ Sardoba;\n" +
                "\n" +
                "✔️ Qarshi hammomlari."))
        list.add(city("Navoiy", R.drawable.navoiy,"Navoiy respublikaning eng yirik maʼmuriy markazi va eng yosh shahri hisoblanadi.\n" +
                "\n" +
                "Shaharda quyidagilarni ko‘rishingiz mumkin:\n" +
                "\n" +
                "✔️ Xalqlar do‘stligi xiyoboni;\n" +
                "\n" +
                "✔️ Alisher Navoiy nomidagi istirohat bog‘i;\n" +
                "\n" +
                "✔️ Sergiy Radonejskiyning  ibodatxonasi;\n" +
                "\n" +
                "✔️ Hazrat Alisher Navoiy masjidi."))
        list.add(city("Qo'qon", R.drawable.qoqon,"Qo‘qon Buyuk Ipak yo‘lidagi eng qadimiy shahar. Shahar hashamatli yodgorliklarga va ulug‘vor madrasalarga boy va bu ajablanarli emas, chunki Qo‘qon ilm-fan rivojlanishining   markazi edi. Quyidagi diqqatga sazovor joylarni ko‘rishni unutmang:\n" +
                "\n" +
                "✔️ Xudoyorxon saroyi,\n" +
                "\n" +
                "✔️ Jomiy masjidi,\n" +
                "\n" +
                "✔️ Modarixon maqbarasi,\n" +
                "\n" +
                "✔️ Norbut-biya madrasasi,\n" +
                "\n" +
                "✔️ Qo‘qon xonlarining maqbarasi"))
        list.add(city("Andijon", R.drawable.andijon,"Andijon shahri - o‘zbek sheʼriyatining taniqli vakili, Mug‘allar sulolasining asoschisi, sarkarda va hukmdor Boburning vatani. Bir vaqtlar Buyuk Ipak yo‘li bo‘ylab joylashgan, arxeologik yodgorliklar va tarixiy obidalarga boy bo‘lgan shaharni , tashrif buyurishga tavsiya etamiz:\n" +
                "\n" +
                "✔️ Bobur bog‘i;\n" +
                "\n" +
                "✔️ Jomiy meʼmoriy majmuasi;\n" +
                "\n" +
                "✔️ Qutayba ibn Muslim maqbarasi;\n" +
                "\n" +
                "✔️ Bibi Seshanba (muqaddas joy)."))
        list.add(city("Farg'ona", R.drawable.fargona,"Zamonaviy Farg‘ona - iqtisodiyoti va madaniyati rivojlangan yirik sanoat markazi. Bu yerda amaliy sanʼat, sheʼriy adabiyot va taʼlim anʼanalari saqlanib qolgan. Shaharga tashrif buyurganingizda quyidagilarni ko‘rishingiz mumkin:\n" +
                "\n" +
                "✔️ Markaziy bog‘ va al-Farg‘oniy yodgorligi;\n" +
                "\n" +
                "✔️ O‘lkashunoslik muzeyi va qo‘g‘irchoq teatri;\n" +
                "\n" +
                "✔️ \"Yangi Chek\" va “Nur-Jomiy” masjidlari;\n" +
                "\n" +
                "✔️ Rus drama teatri;\n" +
                "\n" +
                "✔️ Farg‘ona davlat universiteti;\n" +
                "\n" +
                "✔️ \"Ofitserlar uyi\";\n" +
                "\n" +
                "✔️ Sergiy Radonejskiyning  ibodatxonasi."))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

    override fun onItemClick(position: Int) {
        val bundle=Bundle()
        bundle.putString("nomi", list[position].Nomi)
        bundle.putInt("rasm", list[position].Rasm)
        bundle.putString("malumot",list[position].malumot)
        val showFragment=ShowFragment()
        showFragment.arguments=bundle
        findNavController().navigate(R.id.showFragment,bundle)
    }

}

