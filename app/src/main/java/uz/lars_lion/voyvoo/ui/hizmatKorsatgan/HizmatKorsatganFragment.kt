package uz.lars_lion.voyvoo.ui.hizmatKorsatgan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import uz.lars_lion.voyvoo.R
import uz.lars_lion.voyvoo.adapter.ItemRvAdapter
import uz.lars_lion.voyvoo.base.BaseFragment
import uz.lars_lion.voyvoo.databinding.FragmentHizmatKorsatganBinding
import uz.lars_lion.voyvoo.model.Person

class HizmatKorsatganFragment : BaseFragment<FragmentHizmatKorsatganBinding>() {
    lateinit var mAdapter: ItemRvAdapter
    val listOfPerson = ArrayList<Person>()

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHizmatKorsatganBinding = FragmentHizmatKorsatganBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        initData()

    }

    private fun initRv() {
        mAdapter = ItemRvAdapter()
        binding!!.rv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            val Hdivider =
                DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
            val Vdivider =
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            addItemDecoration(Hdivider)
            addItemDecoration(Vdivider)
            adapter = mAdapter
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
        binding!!.rv.adapter = mAdapter
    }


}