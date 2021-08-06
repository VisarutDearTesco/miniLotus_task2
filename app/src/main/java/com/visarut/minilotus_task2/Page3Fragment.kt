package com.visarut.minilotus_task2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.visarut.minilotus_task2.databinding.Page3FragmentBinding
import org.koin.android.ext.android.inject

class Page3Fragment : Fragment() {

    val viewModel by inject<Page3ViewModel>()

    companion object {
        fun newInstance() = Page3Fragment()
    }

    private lateinit var adapter: PromotionList3Adapter
//    private lateinit var viewModel: Page3ViewModel

    private var _binding: Page3FragmentBinding? = null
    private val binding get() = _binding!!

    var tempList = ArrayList<PromotionItem3>()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Page3FragmentBinding.inflate(inflater, container, false)

        adapter = PromotionList3Adapter(tempList)

        val layoutManager = LinearLayoutManager(context)

        binding.promotionList.layoutManager = layoutManager
        binding.promotionList.adapter = adapter

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        tempList.addAll(viewModel.getData())
        adapter.notifyDataSetChanged()
    }

}