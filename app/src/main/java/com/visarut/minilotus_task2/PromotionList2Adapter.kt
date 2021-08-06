package com.visarut.minilotus_task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.visarut.minilotus_task2.databinding.PromotionBannerItem2Binding
import com.visarut.minilotus_task2.databinding.PromotionBannerItemBinding

class PromotionList2Adapter(
    private val promotionListData: ArrayList<PromotionItem2>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.promotion_banner_item, parent, false)
        return Promotion2ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = promotionListData[position]
        (holder as Promotion2ViewHolder).binding.image.load(data.imageUrl)

    }

    override fun getItemCount(): Int {
        return promotionListData.size
    }


}

class Promotion2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var binding : PromotionBannerItem2Binding = PromotionBannerItem2Binding.bind(itemView)
}