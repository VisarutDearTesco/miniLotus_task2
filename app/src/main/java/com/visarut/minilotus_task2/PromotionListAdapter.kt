package com.visarut.minilotus_task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.visarut.minilotus_task2.databinding.PromotionBannerItemBinding

class PromotionListAdapter(
    private val promotionListData: ArrayList<PromotionItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.promotion_banner_item, parent, false)
        return PromotionViewHolder(inflate)
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

class PromotionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var binding : PromotionBannerItemBinding = PromotionBannerItemBinding.bind(itemView)
}