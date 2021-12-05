package uz.lars_lion.voyvoo.ui.hizmatKorsatgan

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.lars_lion.voyvoo.R
import uz.lars_lion.voyvoo.adapter.ItemRvAdapter
import uz.lars_lion.voyvoo.base.BaseFragment
import uz.lars_lion.voyvoo.databinding.FragmentHizmatKorsatganBinding
import uz.lars_lion.voyvoo.model.Person
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


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
            layoutManager =
                GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            addItemDecoration(object : ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    itemPosition: Int,
                    parent: RecyclerView
                ) {
                    val position = parent.getChildAdapterPosition(view!!)
                    val spanCount = 2
                    val spacing = 10
                    if (position >= 0) {
                        val column = position % spanCount
                        outRect.left =
                            spacing - column * spacing / spanCount
                        outRect.right =
                            (column + 1) * spacing / spanCount
                        if (position < spanCount) {
                            outRect.top = spacing
                        }
                        outRect.bottom = spacing
                    } else {
                        outRect.left = 0
                        outRect.right = 0
                        outRect.top = 0
                        outRect.bottom = 0
                    }
                }
            })
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