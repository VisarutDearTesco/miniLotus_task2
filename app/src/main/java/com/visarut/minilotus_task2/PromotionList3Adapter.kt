package com.visarut.minilotus_task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.visarut.minilotus_task2.databinding.PromotionBannerItem3Binding
import com.visarut.minilotus_task2.databinding.PromotionBannerItemBinding

class PromotionList3Adapter(
    private val promotionListData: ArrayList<PromotionItem3>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.promotion_banner_item3, parent, false)
        return Promotion3ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = promotionListData[position]
        (holder as Promotion3ViewHolder).binding.title.text = data.title

    }

    override fun getItemCount(): Int {
        return promotionListData.size
    }


}

class Promotion3ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var binding : PromotionBannerItem3Binding = PromotionBannerItem3Binding.bind(itemView)
}