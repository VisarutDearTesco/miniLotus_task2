package com.visarut.minilotus_task2.view.feature.featureHomeWithEpoxy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.Page5FragmentBinding
import com.visarut.minilotus_task2.domain.epoxy.model.MiniLotusListData
import org.koin.androidx.viewmodel.ext.android.viewModel

class Page5Fragment : Fragment() {

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

        binding.epoxyList.setController(epoxyListController)

        viewModel.promotionList.observe(viewLifecycleOwner, Observer {

            val minilotus = MiniLotusListData(viewModel.widgetList,viewModel.bannerList,viewModel.promotionList)
            epoxyListController.setData(minilotus)

        })






        return binding.root
    }
}