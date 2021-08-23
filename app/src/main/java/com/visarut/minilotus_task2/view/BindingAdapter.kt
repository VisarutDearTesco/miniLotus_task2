package com.visarut.minilotus_task2

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("name")
fun bindText(view: TextView, name: String?){
    name?.let{
        view.text = it
    }
}

@BindingAdapter("size")
fun bindTextSize(view: TextView, size: Float?){
    size?.let{
        view.textSize = it
    }
}


@BindingAdapter("imageUrl")
fun bindImageUrl(view : ImageView, url: String?){
    url?.let{
        view.load(it)
    }
}
