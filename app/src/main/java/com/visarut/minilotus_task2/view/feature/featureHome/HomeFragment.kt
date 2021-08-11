package com.visarut.minilotus_task2.view.feature.featureHome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.FragmentHomeBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this

        binding.btn1.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_page1fragment)
        }

        binding.btn2.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_page2Fragment)
        }
        binding.btn3.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_page3Fragment)
        }

        binding.btn4.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_testViewBindingFragment)
        }

        binding.btn5.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_page5Fragment)
        }

        return binding.root

    }


}