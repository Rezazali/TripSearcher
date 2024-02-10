package com.zali.tripsearcher.presentation.home.homelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.zali.tripsearcher.R
import com.zali.tripsearcher.domain.Type
import com.zali.tripsearcher.domain.model.ContentMain

class HomeAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    private var listMain : List<ContentMain> = emptyList()

    private val items: List<ListItem> = emptyList()

    override fun getItemViewType(position: Int): Int {
        return items[position].getItemList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            Type.Slide.ordinal ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_rectangle,parent,false)
                return SlideViewHolder(view)
            }
            Type.Story.ordinal ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_populare,parent,false)
                return StoryViewHolder(view)
            }
            Type.Banner.ordinal ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_banner,parent,false)
                return BannerViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_rectangle,parent,false)
                SlideViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (listMain.isEmpty()){
            0
        }else{
            listMain.size
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(listMain[position])
    }
}

class SlideViewHolder(itemView: View) : BaseViewHolder(itemView) {

    val imageSlider = itemView.findViewById<AppCompatImageView>(R.id.img_rectangle)
    var textTitle = itemView.findViewById<AppCompatTextView>(R.id.txt_title)
    val textPrice = itemView.findViewById<AppCompatTextView>(R.id.txt_price)
    val textRate = itemView.findViewById<AppCompatTextView>(R.id.txt_rate)
    override fun bind(item: ContentMain) {
        textTitle.text = item.data[adapterPosition].title
        textPrice.text = item.data[adapterPosition].title
        textRate.text = item.data[adapterPosition].title
    }
}

class StoryViewHolder(itemView: View) : BaseViewHolder(itemView) {

    override fun bind(item: ContentMain) {

    }
}

class BannerViewHolder(itemView: View) : BaseViewHolder(itemView) {

    override fun bind(item: ContentMain) {

    }
}