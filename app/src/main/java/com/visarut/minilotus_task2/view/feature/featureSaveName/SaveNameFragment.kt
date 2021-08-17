package com.visarut.minilotus_task2.view.feature.featureSaveName

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.SaveNameFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SaveNameFragment : Fragment() {

    private lateinit var binding: SaveNameFragmentBinding
    private val viewModel : SaveNameViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.save_name_fragment,container,false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.btnSaveText.setOnClickListener {
            viewModel.saveName(binding.etText.text)
            Toast.makeText(context,"Saved Text!",Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }




}