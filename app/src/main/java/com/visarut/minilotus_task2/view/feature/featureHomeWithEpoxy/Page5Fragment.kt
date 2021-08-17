package com.visarut.minilotus_task2.view.feature.featureHomeWithEpoxy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.Page5FragmentBinding
import com.visarut.minilotus_task2.domain.epoxy.model.MiniLotusListData
import org.koin.androidx.viewmodel.ext.android.viewModel

class Page5Fragment : Fragment(), EpoxyListController.AddOnItemSelected {

    private lateinit var binding: Page5FragmentBinding
    private val viewModel : Page5ViewModel by viewModel()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.page5_fragment, container, false)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val epoxyListController = EpoxyListController()

        epoxyListController.setItemSelectListener(this)

        binding.epoxyList.setController(epoxyListController)

        viewModel.promotionList.observe(viewLifecycleOwner, Observer {

            val minilotus = MiniLotusListData(viewModel.widgetList,viewModel.bannerList,viewModel.promotionList)
            epoxyListController.setData(minilotus)

        })

        return binding.root
    }

    override fun onClickBanner(url: String?) {
        Log.d("test", url.toString())
        val action = Page5FragmentDirections.actionPage5FragmentToSingleBannerFragment(url)
        findNavController().navigate(action)
    }

    override fun onClickLogo() {
        TODO("Not yet implemented")
    }
}