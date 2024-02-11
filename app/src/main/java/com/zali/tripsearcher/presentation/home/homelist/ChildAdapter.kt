package com.zali.tripsearcher.presentation.home.homelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zali.tripsearcher.DataItemType
import com.zali.tripsearcher.databinding.ItemRecyclerPopulareBinding
import com.zali.tripsearcher.databinding.ItemRecyclerRectangleBinding
import com.zali.tripsearcher.domain.model.Item

class ChildAdapter(private val viewType: Int, private val recyclerItemList: List<Item>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            DataItemType.SLIDER ->{
                val binding = ItemRecyclerRectangleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return SliderViewHolder(binding)
            }
            else ->{
                val binding = ItemRecyclerPopulareBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return StoryViewHolder(binding)
            }
        }
    }


    override fun getItemCount(): Int {
        return recyclerItemList.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is SliderViewHolder ->{
                holder.bindSliderView(recyclerItemList[position])
            }
            is StoryViewHolder ->{
                holder.bindStoryView(recyclerItemList[position])
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return viewType
    }

}


class SliderViewHolder(private val binding : ItemRecyclerRectangleBinding): RecyclerView.ViewHolder(binding.root){

    fun bindSliderView(item: Item) {
        Glide.with(binding.root.context)
            .load(item.photo)
            .into(binding.imgRectangle)
    }
}


class StoryViewHolder(private val binding : ItemRecyclerPopulareBinding): RecyclerView.ViewHolder(binding.root){

    fun bindStoryView(item: Item) {
        Glide.with(binding.root.context)
            .load(item.photo)
            .into(binding.imgPopulare)
    }
}