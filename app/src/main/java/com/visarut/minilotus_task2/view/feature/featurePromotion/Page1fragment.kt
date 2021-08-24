package com.visarut.minilotus_task2.view.feature.featurePromotion

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.visarut.minilotus_task2.PromotionListAdapter
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.Page1fragmentFragmentBinding
import com.visarut.minilotus_task2.domain.epoxy.RecycleViewBaseItem
import org.koin.android.ext.android.inject

class Page1fragment : Fragment() {

    val viewModel by inject<Page1fragmentViewModel>()

    companion object {
        fun newInstance() = Page1fragment()
    }

    private lateinit var adapter: PromotionListAdapter

    lateinit var binding: Page1fragmentFragmentBinding

    var tempList = ArrayList<RecycleViewBaseItem>()


    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.page1fragment_fragment, container, false)
        binding.lifecycleOwner = this

        adapter = PromotionListAdapter(tempList)

        val layoutManager = LinearLayoutManager(context)

        binding.promotionList.layoutManager = layoutManager

        binding.promotionList.adapter = adapter


        return binding.root

    }

    override fun onStart() {
        super.onStart()
//        tempList.addAll(viewModel.getData())
        viewModel.promotionList.observe(viewLifecycleOwner, Observer {
            tempList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
}