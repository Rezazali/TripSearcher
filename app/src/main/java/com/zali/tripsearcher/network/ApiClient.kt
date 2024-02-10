package com.zali.tripsearcher.network

import com.zali.tripsearcher.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit : Retrofit? = null

    private fun getInstance() : Retrofit{
        if (retrofit == null)
            synchronized(ApiClient::class.java){
                if (retrofit == null){
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .build()
                }
            }
        return retrofit!!
    }

    private var iService : IService = getInstance().create(IService::class.java)

    fun serviceGenerator() : IService{
        return iService
    }
}