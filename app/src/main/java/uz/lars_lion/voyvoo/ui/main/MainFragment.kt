package uz.lars_lion.voyvoo.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import lars_lion.dev.o_harid.utils.navigateSafe
import lars_lion.dev.o_harid.utils.visible
import uz.lars_lion.voyvoo.R
import uz.lars_lion.voyvoo.adapter.ItemRvAdapter
import uz.lars_lion.voyvoo.base.BaseFragment
import uz.lars_lion.voyvoo.databinding.FragmentMainBinding
import uz.lars_lion.voyvoo.model.Person

class MainFragment : BaseFragment<FragmentMainBinding>() {

    lateinit var mAdapter: ItemRvAdapter
    lateinit var m1Adapter: ItemRvAdapter
    lateinit var m2Adapter: ItemRvAdapter
    lateinit var m3Adapter: ItemRvAdapter
    val listOfPerson = ArrayList<Person>()
    val listOfOnline = ArrayList<Person>()
    val listOfViner = ArrayList<Person>()


    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding =
        FragmentMainBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        initRv1()
        initRv2()
        initRv3()
        Handler(Looper.getMainLooper()).postDelayed({
            with(binding!!) {
                watchAnimation.visible(false)
                watchAnimationUzbHizmat.visible(false)
                watch_animation_xalq_artisti.visible(false)
                progressBarBestseller.visible(false)
                rvNow.visible(true)
                initData()
                initData1()
                initData2()
                initDataViner()

            }
            onClicks()
        }, 1000)

    }

    private fun onClicks() {
        with(binding!!) {
            tvBestsellerSeeAll.setOnClickListener{
                findNavController().navigateSafe(R.id.action_mainFragment_to_onlineFragment)
            }


            tvNowAll.setOnClickListener {
            findNavController().navigateSafe(R.id.action_mainFragment_to_topFragment)
            }

            tvVinerAll.setOnClickListener {
                findNavController().navigateSafe(R.id.action_mainFragment_to_hizmatKorsatganFragment)

            }

            tvXalqArtistiAll.setOnClickListener {
                findNavController().navigateSafe(R.id.action_mainFragment_to_xalqArtistiFragment)

            }


            m1Adapter.onClickListener(object : ItemRvAdapter.ItemOnClickListener {
                override fun onItemClickOption(position: Int, data: Person) {
                    findNavController().navigateSafe(R.id.action_mainFragment_to_singerFragment)
                }
            })
            m2Adapter.onClickListener(object : ItemRvAdapter.ItemOnClickListener {
                override fun onItemClickOption(position: Int, data: Person) {
                    findNavController().navigateSafe(R.id.action_mainFragment_to_singerFragment)
                }
            })
            mAdapter.onClickListener(object : ItemRvAdapter.ItemOnClickListener {
                override fun onItemClickOption(position: Int, data: Person) {
                    findNavController().navigateSafe(R.id.action_mainFragment_to_singerFragment)
                }
            })
            m3Adapter.onClickListener(object : ItemRvAdapter.ItemOnClickListener {
                override fun onItemClickOption(position: Int, data: Person) {
                    findNavController().navigateSafe(R.id.action_mainFragment_to_singerFragment)
                }
            })

        }
    }

    private fun initRv() {
        mAdapter = ItemRvAdapter()
        binding!!.rvNow.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    private fun initRv1() {
        m1Adapter = ItemRvAdapter()
        binding!!.rvBestseller.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = m1Adapter
        }
    }

    private fun initRv2() {
        m2Adapter = ItemRvAdapter()
        binding!!.rvXalqArtisti.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = m2Adapter
        }
    }
    private fun initRv3() {
        m3Adapter = ItemRvAdapter()
        binding!!.rvViner.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = m3Adapter
        }
    }

    private fun initData() {
        listOfPerson.add(Person(R.drawable.munisa, "Munisa", "250000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.rayhon, "Rayhon", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.asal, "Asal", "200000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ozodbek, "Ozodbek", "450000", "Madaniyat Vaziri"))
        listOfPerson.add(Person(R.drawable.ziyoda, "Ziyoda", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ulugbek, "Ulug`bek", "120000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.munisa, "Munisa", "250000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.rayhon, "Rayhon", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.asal, "Asal", "200000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ozodbek, "Ozodbek", "450000", "Madaniyat Vaziri"))
        listOfPerson.add(Person(R.drawable.ziyoda, "Ziyoda", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ulugbek, "Ulug`bek", "120000", "Qo`shiqchi"))

        mAdapter.submitList(listOfPerson)
        binding!!.rvNow.adapter = mAdapter
    }

    private fun initData1() {
        listOfOnline.add(Person(R.drawable.munisa, "Munisa", "250000", "Qo`shiqchi"))
        listOfOnline.add(Person(R.drawable.rayhon, "Rayhon", "300000", "Qo`shiqchi"))
        listOfOnline.add(Person(R.drawable.unnamed, "Dilime", "250000", "Viner"))
        listOfOnline.add(Person(R.drawable.abu, "Abu", "300000", "Viner"))
        listOfOnline.add(Person(R.drawable.ziyoda, "Ziyoda", "300000", "Qo`shiqchi"))
        listOfOnline.add(Person(R.drawable.ulugbek, "Ulug`bek", "120000", "Qo`shiqchi"))
        listOfOnline.add(Person(R.drawable.mitti, "Mittime", "300000", "Viner"))
        m1Adapter.submitList(listOfOnline)
        binding!!.rvBestseller.adapter = m1Adapter
    }

    private fun initData2() {
        listOfPerson.add(Person(R.drawable.munisa, "Munisa", "250000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.rayhon, "Rayhon", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.asal, "Asal", "200000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ozodbek, "Ozodbek", "450000", "Madaniyat Vaziri"))
        listOfPerson.add(Person(R.drawable.ziyoda, "Ziyoda", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ulugbek, "Ulug`bek", "120000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.munisa, "Munisa", "250000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.rayhon, "Rayhon", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.asal, "Asal", "200000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ozodbek, "Ozodbek", "450000", "Madaniyat Vaziri"))
        listOfPerson.add(Person(R.drawable.ziyoda, "Ziyoda", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ulugbek, "Ulug`bek", "120000", "Qo`shiqchi"))

        m2Adapter.submitList(listOfPerson)
        binding!!.rvXalqArtisti.adapter = m1Adapter
    }

    private fun initDataViner() {
        listOfViner.add(Person(R.drawable.unnamed, "Dilime", "250000", "Viner"))
        listOfViner.add(Person(R.drawable.abu, "Abu", "300000", "Viner"))
        listOfViner.add(Person(R.drawable.mitti, "Mittime", "300000", "Viner"))


        m3Adapter.submitList(listOfViner)
        binding!!.rvViner.adapter = m3Adapter
    }

}