package uz.lars_lion.voyvoo.ui.main.online

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.lars_lion.voyvoo.R
import uz.lars_lion.voyvoo.base.BaseFragment
import uz.lars_lion.voyvoo.databinding.FragmentOnlineBinding

class OnlineFragment : BaseFragment<FragmentOnlineBinding>() {
    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnlineBinding  = FragmentOnlineBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}