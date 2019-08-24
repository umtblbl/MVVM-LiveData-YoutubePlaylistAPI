package com.example.mvvmexample2noteapp.XNoteDaoData

import android.annotation.SuppressLint
import android.util.Log
import com.example.mvvmexample2noteapp.Data.Retrofit.ServiceCallBack
import com.example.mvvmexample2noteapp.Model.PlayListData
import com.example.youtubeplaylist.ApiService
import com.example.youtubeplaylist.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YoutubePlayList {

    private var playListData: PlayListData? = null
    var callback: ServiceCallBack? = null

    companion object {

        @Volatile
        private var instance: YoutubePlayList? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: YoutubePlayList().also { instance = it }
        }

    }

    /*
    fun addNote(note: Note) {
        notesList.add(note)
        notes.value = notesList
    }

    fun getNotes() = notes as LiveData<List<Note>>
*/

    fun getYoutubePlayList(CHANNEL_ID: String, API_KEY: String, limit: Int, callback:ServiceCallBack) {
        Log.d("SONUC", "YoutubePlayList-getYoutubePlayList")
        val apiInterface = ApiService.client?.create(ApiInterface::class.java)
        val apiCall = apiInterface?.getChannelPlayList(CHANNEL_ID, API_KEY, limit)
/*
        apiInterface?.getChannelPlayList(CHANNEL_ID, API_KEY, limit)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<PlayListData> {
                override fun onComplete() {
                    Log.d("SONUC", "onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("SONUC", "onSubscribe: "+d.isDisposed)
                }


                override fun onNext(t: PlayListData) {
                    Log.d("SONUC", "onNext: "+t.items.size)
                    //playListData = t
                    playListData = t
                }

                override fun onError(e: Throwable) {
                    Log.d("SONUC", "onError"+e.message)
                }


            })
*/
        apiCall?.enqueue(object : Callback<PlayListData> {


            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call<PlayListData>, response: Response<PlayListData>?) {

                playListData = response?.body()
                Log.d("SONUC", ""+response?.body()?.items?.size)
                callback?.onResponse(response?.body())

            }

            override fun onFailure(call: Call<PlayListData>, t: Throwable) {
                Log.e("SONUC", "" + t.printStackTrace())
                callback?.onError(t.message)
            }
        })


    }

}