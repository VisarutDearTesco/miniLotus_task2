package com.visarut.minilotus_task2

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.visarut.minilotus_task2.databinding.PromotionBannerItem3Binding
import com.visarut.minilotus_task2.databinding.PromotionBannerItemBinding

class PromotionListAdapter(
    private val promotionListData: ArrayList<PromotionItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        var binding: PromotionBannerItemBinding =
            DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item, parent, false)
        return PromotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = promotionListData[position]
        (holder as PromotionViewHolder).binding.title.text = data.title
        (holder as PromotionViewHolder).binding.image.load(data.imageUrl)

    }

    override fun getItemCount(): Int {
        return promotionListData.size
    }


}

class PromotionViewHolder(itemView: PromotionBannerItemBinding) :
    RecyclerView.ViewHolder(itemView.root) {


    var binding: PromotionBannerItemBinding = itemView


    fun bind(item: ClipData.Item?) {
//        binding.setItem(item)
        binding.executePendingBindings()
    }
}