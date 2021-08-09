package com.visarut.minilotus_task2

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.visarut.minilotus_task2.databinding.PromotionBannerItem2Binding


class PromotionList2Adapter(
    private val promotionListData: ArrayList<PromotionItem2>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding: PromotionBannerItem2Binding =
            DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item2, parent, false)
        return Promotion2ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = promotionListData[position]
        (holder as Promotion2ViewHolder).binding.image.load(data.imageUrl)

    }

    override fun getItemCount(): Int {
        return promotionListData.size
    }


}

class Promotion2ViewHolder(itemView: PromotionBannerItem2Binding) :
    RecyclerView.ViewHolder(itemView.root) {


    var binding: PromotionBannerItem2Binding = itemView


    fun bind(item: Item?) {
//        binding.setItem(item)
        binding.executePendingBindings()
    }

}

