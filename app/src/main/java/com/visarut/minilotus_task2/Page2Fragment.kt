package com.visarut.minilotus_task2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.visarut.minilotus_task2.databinding.Page2FragmentBinding
import org.koin.android.ext.android.inject

class Page2Fragment : Fragment() {

    val viewModel by inject<Page2ViewModel>()

    companion object {
        fun newInstance() = Page2Fragment()
    }

    private lateinit var adapter: PromotionList2Adapter
//    private lateinit var viewModel: Page2ViewModel

    private var _binding: Page2FragmentBinding? = null
    private val binding get() = _binding!!

    var tempList = ArrayList<PromotionItem2>()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Page2FragmentBinding.inflate(inflater, container, false)

        adapter = PromotionList2Adapter(tempList)

        val layoutManager = LinearLayoutManager(context)

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