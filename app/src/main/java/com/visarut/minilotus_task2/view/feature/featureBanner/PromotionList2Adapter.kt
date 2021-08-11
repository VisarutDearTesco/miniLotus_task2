package com.visarut.minilotus_task2

import android.content.ClipData
import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.visarut.minilotus_task2.databinding.LogoBannerBinding
import com.visarut.minilotus_task2.databinding.PromotionBannerItem2Binding
import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.LogoBanner
import com.visarut.minilotus_task2.domain.epoxy.RecycleViewBaseItem


class PromotionList2Adapter(
    private val promotionListData: ArrayList<RecycleViewBaseItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
//        val binding: PromotionBannerItem2Binding =
//            DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item2, parent, false)
        val binding: LogoBannerBinding =
            DataBindingUtil.inflate(inflate, R.layout.logo_banner, parent, false)
        return LogoBannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = promotionListData[position]
//        (holder as Promotion2ViewHolder).binding.image.load(data.imageUrl)
        val promotionData = data as LogoBanner
        (holder as LogoBannerViewHolder).binding.image.load(promotionData.imageUrl)

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

class LogoBannerViewHolder(itemView : LogoBannerBinding) :
    RecyclerView.ViewHolder(itemView.root) {

    var binding: LogoBannerBinding = itemView

    fun bind(item: ClipData.Item?) {
        binding.executePendingBindings()
    }
}



