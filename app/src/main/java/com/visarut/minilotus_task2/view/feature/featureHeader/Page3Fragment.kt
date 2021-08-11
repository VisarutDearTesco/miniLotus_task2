package com.visarut.minilotus_task2.view.feature.featureHeader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.Page3FragmentBinding
import com.visarut.minilotus_task2.domain.epoxy.RecycleViewBaseItem
import org.koin.android.ext.android.inject

class Page3Fragment : Fragment() {

    val viewModel by inject<Page3ViewModel>()


    private lateinit var adapter: PromotionList3Adapter


    var tempList = ArrayList<RecycleViewBaseItem>()

    private lateinit var binding: Page3FragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.page3_fragment, container, false)
        binding.lifecycleOwner = this

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