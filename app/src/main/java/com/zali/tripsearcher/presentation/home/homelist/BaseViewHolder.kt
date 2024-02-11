package com.zali.tripsearcher.presentation.home.homelist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zali.tripsearcher.domain.model.ContentMain
import com.zali.tripsearcher.domain.model.Item

abstract class BaseViewHolder(item : View) : RecyclerView.ViewHolder(item) {
    abstract fun bind(item: Item)
}