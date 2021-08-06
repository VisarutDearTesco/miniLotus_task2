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
import com.visarut.minilotus_task2.databinding.ActivityHomeBinding
import com.visarut.minilotus_task2.databinding.Page1fragmentFragmentBinding
import org.koin.android.ext.android.inject

class Page1fragment : Fragment() {

    val viewModel by inject<Page1fragmentViewModel>()

    companion object {
        fun newInstance() = Page1fragment()
    }
    private lateinit var adapter: PromotionListAdapter
//    private lateinit var viewModel: Page1fragmentViewModel

    private var _binding: Page1fragmentFragmentBinding? = null
    private val binding get() = _binding!!

    var tempList = ArrayList<PromotionItem>()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.page1fragment_fragment, container, false)
        _binding = Page1fragmentFragmentBinding.inflate(inflater, container, false)

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
        Log.d("test",tempList.toString())
    }
}