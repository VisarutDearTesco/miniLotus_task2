package com.visarut.minilotus_task2.view.recycleView.feature.featureHeader

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.visarut.minilotus_task2.R
import com.visarut.minilotus_task2.databinding.PromotionBannerItem3Binding
import com.visarut.minilotus_task2.Domain.epoxy.RecycleViewBaseItem

class PromotionList3Adapter(
    private val promotionListData: ArrayList<RecycleViewBaseItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        var binding: PromotionBannerItem3Binding =
            DataBindingUtil.inflate(inflate, R.layout.promotion_banner_item3, parent, false)
        return Promotion3ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = promotionListData[position]
//        (holder as Promotion3ViewHolder).binding.title.text = data.title

    }

    override fun getItemCount(): Int {
        return promotionListData.size
    }


}

class Promotion3ViewHolder(itemView: PromotionBannerItem3Binding) :
    RecyclerView.ViewHolder(itemView.root) {

    var binding: PromotionBannerItem3Binding = itemView


    fun bind(item: ClipData.Item?) {
//        binding.setItem(item)
        binding.executePendingBindings()
    }
}