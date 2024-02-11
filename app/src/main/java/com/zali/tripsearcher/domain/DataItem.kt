package com.zali.tripsearcher.domain

import com.zali.tripsearcher.domain.model.Item

data class DataItem(val viewType: Int) {

    var recyclerItemList: List<Item>? = null

    constructor(viewType: Int, recyclerItemList: List<Item>) : this(viewType) {
        this.recyclerItemList = recyclerItemList
    }

}