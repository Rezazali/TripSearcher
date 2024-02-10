package com.zali.tripsearcher.presentation.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zali.tripsearcher.domain.model.ContentMain
import com.zali.tripsearcher.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : ViewModel(){

    private  val TAG = "HomeViewModel"

    private lateinit var mutableLiveData: MutableLiveData<ContentMain>

    fun requestListMain():MutableLiveData<ContentMain>{
        mutableLiveData = MutableLiveData()

        webService()

        return mutableLiveData
    }

    private fun webService() {
        ApiClient.serviceGenerator().getListHome()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ContentMain>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "onError: ")
                }

                override fun onComplete() {

                }

                override fun onNext(t: ContentMain) {
                    Log.d(TAG, "onNext: ")
                    mutableLiveData.value = t
                }

            })
    }
}