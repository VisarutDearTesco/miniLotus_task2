package com.visarut.minilotus_task2

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.visarut.minilotus_task2.databinding.PromotionBannerItem3Binding
import com.visarut.minilotus_task2.databinding.PromotionBannerItemBinding
import com.visarut.minilotus_task2.recycleView.ListType.Companion.TYPE_IMAGE
import com.visarut.minilotus_task2.recycleView.ListType.Companion.TYPE_TEXT_ONLY
import com.visarut.minilotus_task2.recycleView.PromotionItemTypeText
import com.visarut.minilotus_task2.recycleView.RecycleViewBaseItem

class PromotionListAdapter(
    private val promotionListData: ArrayList<RecycleViewBaseItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_TEXT_ONLY -> {
                var binding: PromotionBannerItem3Binding =
                    DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item3, parent, false)
                PromotionTypeTextViewHolder(binding)
            }
            else -> {
                var binding: PromotionBannerItemBinding =
                    DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item, parent, false)
                PromotionTypeImageViewHolder(binding)
            }

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = promotionListData[position]

        when (holder) {
            is PromotionTypeTextViewHolder -> {
                val promotionData = data as PromotionItemTypeText
                holder.binding.title.text = promotionData.title
            }
            is PromotionTypeImageViewHolder -> {
                val promotionData = data as PromotionItemTypeImage
                holder.binding.title.text = promotionData.title
                holder.binding.image.load(promotionData.imageUrl)
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

class PromotionTypeImageViewHolder(itemView: PromotionBannerItemBinding) :
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