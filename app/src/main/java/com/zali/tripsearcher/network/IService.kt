package com.zali.tripsearcher.network

import com.zali.tripsearcher.domain.model.ContentMain
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface IService {


    @GET("home.json")
    fun getListHome():Observable<ContentMain>
}