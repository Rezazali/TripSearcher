package com.zali.tripsearcher.presentation.home.homelist

interface ItemIntractor {

    fun onSliderClicked(id : Int)
    fun onStoryClicked(id : Int)
}


interface BannerIntractor {

    fun onBannerClicked(id : Int)
}