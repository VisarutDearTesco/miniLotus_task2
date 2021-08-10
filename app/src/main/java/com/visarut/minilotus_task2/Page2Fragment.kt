package com.visarut.minilotus_task2

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.visarut.minilotus_task2.databinding.LayoutSubItemBinding
import com.visarut.minilotus_task2.databinding.Page2FragmentBinding
import com.visarut.minilotus_task2.databinding.Page3FragmentBinding
import com.visarut.minilotus_task2.recycleView.RecycleViewBaseItem
import org.koin.android.ext.android.inject

class Page2Fragment : Fragment() {

    val viewModel by inject<Page2ViewModel>()


    private lateinit var adapter: PromotionList2Adapter


    var tempList = ArrayList<RecycleViewBaseItem>()


//    private lateinit var binding: Page2FragmentBinding
    private lateinit var binding: LayoutSubItemBinding

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.layout_sub_item, container, false)
        binding.lifecycleOwner = this


        adapter = PromotionList2Adapter(tempList)

//        val layoutManager = LinearLayoutManager(context)
        val layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)

        binding.promotionList.layoutManager = layoutManager
        binding.promotionList.adapter = adapter

        return binding.root
    }

    override fun onStart() {
        super.onStart()
//        tempList.addAll(viewModel.getData())
        viewModel.promotionList.observe(viewLifecycleOwner,{
            tempList.addAll(it)
            adapter.notifyDataSetChanged()
        })
        adapter.notifyDataSetChanged()

    }

}