package com.visarut.minilotus_task2.view.feature.featureSaveName

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.SaveNameFragmentBinding
import com.visarut.minilotus_task2.domain.epoxy.model.SharedPrefData
import org.koin.androidx.viewmodel.ext.android.viewModel

class SaveNameFragment : Fragment() {

    private val viewModel : SaveNameViewModel by viewModel()

    lateinit var binding: SaveNameFragmentBinding

    companion object {
        fun newInstance() = SaveNameFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.save_name_fragment,container,false)

        binding.lifecycleOwner = this


        binding.btnSaveText.setOnClickListener {
            viewModel.saveName(binding.etText.text.toString())
        }

//        viewModel.name.observe(viewLifecycleOwner, Observer {
//           SharedPrefData(viewModel.name)
//        })

        return binding.root
    }




}