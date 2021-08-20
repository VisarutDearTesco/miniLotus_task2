package com.visarut.minilotus_task2.view.feature.featureDeliveryHome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.DeliveryHomePageFragmentBinding
import com.visarut.minilotus_task2.domain.epoxy.model.FoodDeliveryData
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeliveryHomePageFragment : Fragment() {

    private lateinit var binding: DeliveryHomePageFragmentBinding
    private val viewModel: DeliveryHomePageViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater, R.layout.delivery_home_page_fragment, container, false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val deliveryHomeController = DeliveryHomeController()

        binding.epoxyList.setController(deliveryHomeController)

        viewModel.foodCategoryList.observe(viewLifecycleOwner, Observer {
            val foodDelivery = FoodDeliveryData(viewModel.foodCategoryList)
            deliveryHomeController.setData(foodDelivery)
        })

        return binding.root
    }


}