package com.visarut.minilotus_task2

import android.annotation.SuppressLint
import android.content.ClipData
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.LayoutSubItem
import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.PromotionTypeImage
import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.PromotionTypeText
import com.visarut.minilotus_task2.Domain.epoxy.RecycleViewBaseItem
import com.visarut.minilotus_task2.databinding.*
import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.ListType.Companion.TYPE_IMAGE
import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.ListType.Companion.TYPE_LISTLOGO
import com.visarut.minilotus_task2.Domain.epoxy.model.baseitem.ListType.Companion.TYPE_TEXT_ONLY

class PromotionListAdapter(
    private val promotionListData: ArrayList<RecycleViewBaseItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    lateinit var binding: Page1fragmentFragmentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)

        return when (viewType) {
            TYPE_TEXT_ONLY -> {
                var binding: PromotionBannerItem3Binding =
                    DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item3, parent, false)
                PromotionTypeTextViewHolder(binding)
            }
            TYPE_IMAGE -> {
                var binding : PromotionBannerItem2Binding =
                    DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item2, parent, false)
                PromotionTypeImageViewHolder(binding)
            }
            TYPE_LISTLOGO -> {
                var binding : LayoutSubItemBinding =
                    DataBindingUtil.inflate(inflate, R.layout.layout_sub_item, parent, false)
                LayoutSubItemViewHolder(binding)
            }
            else -> {
                var binding: PromotionBannerItemBinding =
                    DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item, parent, false)
                PromotionTypeImageTextViewHolder(binding)
            }

        }

    }

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = promotionListData[position]

        when (holder) {
            is PromotionTypeTextViewHolder -> {
                val promotionData = data as PromotionTypeText
                holder.binding.title.text = promotionData.title
            }
            is PromotionTypeImageViewHolder -> {
                val promotionData = data as PromotionTypeImage
                holder.binding.image.load(promotionData.imageUrl)
            }
            is LayoutSubItemViewHolder -> {
//                Log.d("test","in LayoutSubitemViewHolder")
                val promotionData = data as LayoutSubItem

                val layoutManager = LinearLayoutManager(holder.binding.promotionList.context, OrientationHelper.HORIZONTAL, false)
                val promotionList2Adapter : PromotionList2Adapter = PromotionList2Adapter(promotionData.logoData)
                Log.d("test2",promotionData.logoData.toString())
                holder.binding.promotionList.layoutManager = layoutManager
                holder.binding.promotionList.adapter = promotionList2Adapter

            }
        }

    }

    override fun getItemCount(): Int {
        return promotionListData.size
    }

    override fun getItemViewType(position: Int): Int {
        return promotionListData[position].type
    }


}

class PromotionTypeImageTextViewHolder(itemView: PromotionBannerItemBinding) :
    RecyclerView.ViewHolder(itemView.root) {


    var binding: PromotionBannerItemBinding = itemView


    fun bind(item: ClipData.Item?) {
//        binding.setItem(item)
        binding.executePendingBindings()
    }
}

class PromotionTypeTextViewHolder(itemView: PromotionBannerItem3Binding) :
    RecyclerView.ViewHolder(itemView.root) {

    var binding: PromotionBannerItem3Binding = itemView


    fun bind(item: ClipData.Item?) {
//        binding.setItem(item)
        binding.executePendingBindings()
    }
}

class PromotionTypeImageViewHolder(itemView: PromotionBannerItem2Binding) :
    RecyclerView.ViewHolder(itemView.root) {

    var binding: PromotionBannerItem2Binding = itemView


    fun bind(item: ClipData.Item?) {
//        binding.setItem(item)
        binding.executePendingBindings()
    }
}

class LayoutSubItemViewHolder(itemView : LayoutSubItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {

    var binding: LayoutSubItemBinding = itemView


    fun bind(item: ClipData.Item?) {
        binding.executePendingBindings()
    }
}

