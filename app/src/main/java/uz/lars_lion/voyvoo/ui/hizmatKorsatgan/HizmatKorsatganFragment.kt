package uz.lars_lion.voyvoo.ui.hizmatKorsatgan

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import uz.lars_lion.voyvoo.adapter.ItemRv1Adapter
import uz.lars_lion.voyvoo.adapter.ItemRvAdapter
import uz.lars_lion.voyvoo.base.BaseFragment
import uz.lars_lion.voyvoo.databinding.FragmentHizmatKorsatganBinding
import uz.lars_lion.voyvoo.model.Person
import com.google.android.material.internal.ViewUtils.dpToPx
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import uz.lars_lion.voyvoo.R


class HizmatKorsatganFragment : BaseFragment<FragmentHizmatKorsatganBinding>() {

    lateinit var mAdapter: ItemRv1Adapter
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

class ItemDecorationAlbumColumns(private val mSizeGridSpacingPx: Int, private val mGridSize: Int) : ItemDecoration() {
    private var mNeedLeftSpacing = false
   override fun getItemOffsets(
       outRect: Rect,
       view: View,
       parent: RecyclerView,
       state: RecyclerView.State
   ) {
        val frameWidth =
            ((parent.width - mSizeGridSpacingPx.toFloat() * (mGridSize - 1)) / mGridSize).toInt()
        val padding = parent.width / mGridSize - frameWidth
        val itemPosition = (view.layoutParams as RecyclerView.LayoutParams).viewAdapterPosition
        if (itemPosition < mGridSize) {
            outRect.top = 0
        } else {
            outRect.top = mSizeGridSpacingPx
        }
        if (itemPosition % mGridSize == 0) {
            outRect.left = 0
            outRect.right = padding
            mNeedLeftSpacing = true
        } else if ((itemPosition + 1) % mGridSize == 0) {
            mNeedLeftSpacing = false
            outRect.right = 0
            outRect.left = padding
        } else if (mNeedLeftSpacing) {
            mNeedLeftSpacing = false
            outRect.left = mSizeGridSpacingPx - padding
            if ((itemPosition + 2) % mGridSize == 0) {
                outRect.right = mSizeGridSpacingPx - padding
            } else {
                outRect.right = mSizeGridSpacingPx / 2
            }
        } else if ((itemPosition + 2) % mGridSize == 0) {
            mNeedLeftSpacing = false
            outRect.left = mSizeGridSpacingPx / 2
            outRect.right = mSizeGridSpacingPx - padding
        } else {
            mNeedLeftSpacing = false
            outRect.left = mSizeGridSpacingPx / 2
            outRect.right = mSizeGridSpacingPx / 2
        }
        outRect.bottom = 0
    }
}