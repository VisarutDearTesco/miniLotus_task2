package com.visarut.minilotus_task2.view.feature.featureSingleBanner

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.SingleBannerFragmentBinding
import com.visarut.minilotus_task2.domain.epoxy.model.MiniLotusListData
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingleBannerFragment : Fragment() {

    private lateinit var binding : SingleBannerFragmentBinding
    private val viewModel: SingleBannerViewModel by viewModel()

    val args: SingleBannerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Toast.makeText(context,args.image,Toast.LENGTH_SHORT).show()

        binding =
            DataBindingUtil.inflate(inflater, R.layout.single_banner_fragment, container, false)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.setImageUrl(args.image)

//        binding.ivImageUrl.load(args.image)
//        binding.tvImageUrl.text = args.image

        viewModel.imageUrl.observe(viewLifecycleOwner, Observer {
            binding.ivImageUrl.load(it)
            binding.tvImageUrl.text = it
        })




        return binding.root
    }



}