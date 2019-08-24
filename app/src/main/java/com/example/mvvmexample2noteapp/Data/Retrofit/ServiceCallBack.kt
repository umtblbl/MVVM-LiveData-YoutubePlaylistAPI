package com.example.mvvmexample2noteapp.Data.Retrofit

import com.example.mvvmexample2noteapp.Model.PlayListData

interface ServiceCallBack {

    fun onResponse(playListData: PlayListData?)
    fun onError(message: String?)

}