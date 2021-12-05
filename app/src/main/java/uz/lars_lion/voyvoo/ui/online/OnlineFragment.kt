package uz.lars_lion.voyvoo.ui.online

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lars_lion.dev.o_harid.utils.navigateSafe
import uz.lars_lion.voyvoo.R
import uz.lars_lion.voyvoo.adapter.ItemRv1Adapter
import uz.lars_lion.voyvoo.base.BaseFragment
import uz.lars_lion.voyvoo.databinding.FragmentOnlineBinding
import uz.lars_lion.voyvoo.model.Person
import uz.lars_lion.voyvoo.ui.hizmatKorsatgan.ItemDecorationAlbumColumns

class OnlineFragment : BaseFragment<FragmentOnlineBinding>() {
    lateinit var mAdapter: ItemRv1Adapter
    val listOfPerson = ArrayList<Person>()


    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnlineBinding  = FragmentOnlineBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        initData()

        mAdapter.onClickListener(object : ItemRv1Adapter.ItemOnClickListener {
            override fun onItemClickOption(position: Int, data: Person) {
                findNavController().navigateSafe(R.id.action_mainFragment_to_singerFragment)
            }
        })
        binding!!.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initRv() {
        mAdapter = ItemRv1Adapter()
        binding!!.rv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            addItemDecoration(
                ItemDecorationAlbumColumns(
                    resources.getDimensionPixelSize(R.dimen.photos_list_spacing),
                    resources.getInteger(R.integer.photo_list_preview_columns)
                )
            )
            adapter = mAdapter
        }

    }

    private fun initData() {
        listOfPerson.add(Person(R.drawable.munisa, "Munisa", "250000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.rayhon, "Rayhon", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.unnamed, "Dilime", "250000", "Viner"))
        listOfPerson.add(Person(R.drawable.abu, "Abu", "300000", "Viner"))
        listOfPerson.add(Person(R.drawable.ziyoda, "Ziyoda", "300000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.ulugbek, "Ulug`bek", "120000", "Qo`shiqchi"))
        listOfPerson.add(Person(R.drawable.mitti, "Mittime", "300000", "Viner"))

        mAdapter.submitList(listOfPerson)
        binding!!.rv.adapter = mAdapter
    }



}