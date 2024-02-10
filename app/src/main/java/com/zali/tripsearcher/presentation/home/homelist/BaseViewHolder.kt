package com.zali.tripsearcher.presentation.home.homelist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zali.tripsearcher.domain.model.ContentMain

abstract class BaseViewHolder(item : View) : RecyclerView.ViewHolder(item) {
    abstract fun bind(item: ContentMain)
}