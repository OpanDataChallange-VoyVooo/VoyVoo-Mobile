package uz.lars_lion.voyvoo.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
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
    val listOfPerson = ArrayList<Person>()

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding =
        FragmentMainBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        initRv1()
        initRv2()
        Handler(Looper.getMainLooper()).postDelayed({
            with(binding!!) {
                watchAnimation.visible(false)
                watchAnimationUzbHizmat.visible(false)
                watch_animation_xalq_artisti.visible(false)
                watch_animation_nihol.visible(false)
                progressBarBestseller.visible(false)
                rvNow.visible(true)
                initData()
                initData1()
                initData2()

            }
        }, 1000)

        onClicks()
    }

    private fun onClicks() {
        with(binding!!){

        }
    }

    private fun initRv() {
        mAdapter = ItemRvAdapter()
        binding!!.rvNow.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
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

        m1Adapter.submitList(listOfPerson)
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
        binding!!.rvXalqArtisti.adapter = m2Adapter
    }

}