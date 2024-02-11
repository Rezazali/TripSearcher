package com.zali.tripsearcher.presentation.home.homelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zali.tripsearcher.DataItemType
import com.zali.tripsearcher.R
import com.zali.tripsearcher.databinding.EachItemBinding
import com.zali.tripsearcher.databinding.ItemRecyclerBannerBinding
import com.zali.tripsearcher.domain.DataItem

import com.zali.tripsearcher.domain.model.Item

class HomeAdapter(private val dataItemList: List<DataItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.item_recycler_banner -> {
                val binding = ItemRecyclerBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BannerItemViewHolder(binding)
            }
            else -> {
                val binding = EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecyclerItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataItemList[position]
        when (holder) {
            is BannerItemViewHolder -> if (item.viewType == DataItemType.BANNER) { // Assuming DataItem.BannerDataItem exists and holds a List<Item>
                holder.bindBannerView(item.recyclerItemList) // Assuming bannerItems is the List<Item> you want to pass
            }
            is RecyclerItemViewHolder -> {
                when(item.viewType){
                    DataItemType.SLIDER ->{
                        item.recyclerItemList?.let { holder.bindSliderRecyclerView(it) }
                    }
                    DataItemType.STORY ->{
                        item.recyclerItemList?.let {
                            holder.bindStoryRecycler(it)
                        }
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataItemList[position].viewType) {
            DataItemType.BANNER ->
                R.layout.item_recycler_banner
            else ->
                R.layout.each_item
        }
    }
}
class RecyclerItemViewHolder(private val binding: EachItemBinding) :
        RecyclerView.ViewHolder(binding.root){

    init {
        binding.childRecyclerView.layoutManager =
            LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
    }

    fun bindSliderRecyclerView(itemList: List<Item>){
        val adapter = ChildAdapter(DataItemType.SLIDER, itemList)
        binding.childRecyclerView.adapter = adapter
    }

    fun bindStoryRecycler(itemList: List<Item>){
        val adapter = ChildAdapter(DataItemType.STORY, itemList)
        binding.childRecyclerView.adapter = adapter
    }
}

class BannerItemViewHolder(private val binding: ItemRecyclerBannerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindBannerView(banner: List<Item>?) {
        Glide.with(binding.root.context)
            .load(banner?.get(0)?.photo)
            .into(binding.imgBanner)
    }

}
