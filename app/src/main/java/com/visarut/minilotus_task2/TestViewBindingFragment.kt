package com.visarut.minilotus_task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.visarut.minilotus_task2.databinding.TestViewBindingFragmentBinding
import com.visarut.minilotus_task2.epoxy.EpoxyListController
import com.visarut.minilotus_task2.epoxy.MiniLotusListData
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestViewBindingFragment : Fragment() {


    private lateinit var binding: TestViewBindingFragmentBinding
    private val viewModel: TestViewBindingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.test_view_binding_fragment, container, false)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel


        val epoxyListController = EpoxyListController()
        binding.epoxyList.setController(epoxyListController)



        viewModel.promotionList.observe(viewLifecycleOwner, Observer {

            val miniLotus = MiniLotusListData(null, it, null)
            epoxyListController.setData(miniLotus)
        })

        return binding.root
    }


}