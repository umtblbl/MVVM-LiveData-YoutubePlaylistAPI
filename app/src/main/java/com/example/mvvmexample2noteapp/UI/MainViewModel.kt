package com.example.mvvmexample2noteapp.UI

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample2noteapp.Data.Repository
import com.example.mvvmexample2noteapp.Data.Retrofit.ServiceCallBack
import com.example.mvvmexample2noteapp.Model.PlayListData
import com.example.mvvmexample2noteapp.Utilities.Utils
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel(private val repository: Repository) : ViewModel(), ServiceCallBack {

    var liveYoutubePlaylist = MutableLiveData<PlayListData>()
    var error:String? = ""

    override fun onResponse(playListData: PlayListData?) {
        liveYoutubePlaylist.postValue(playListData)
    }

    override fun onError(message: String?) {
        error = message
    }

    fun startApiCall(CHANNEL_ID: String, API_KEY: String, limit: Int) {

        Log.d("SONUC", "startApiCall")

        //callYoutubePlayList(CHANNEL_ID, API_KEY, limit)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                callYoutubePlayList(CHANNEL_ID, API_KEY, limit)
                Log.d("SONUC", "Timer")
            }
        }, 1, 1000)


    }

    fun callYoutubePlayList(CHANNEL_ID: String, API_KEY: String, limit: Int) {
        repository.getYoutubePlayList(CHANNEL_ID, API_KEY, limit, this)
    }
}


