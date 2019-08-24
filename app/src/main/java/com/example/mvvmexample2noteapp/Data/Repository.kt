package com.example.mvvmexample2noteapp.Data

import android.util.Log
import com.example.mvvmexample2noteapp.Data.Retrofit.ServiceCallBack
import com.example.mvvmexample2noteapp.Model.PlayListData
import com.example.mvvmexample2noteapp.XNoteDaoData.YoutubePlayList

class Repository private constructor(private val playListDAO: YoutubePlayList) {

    private var youtubePlayList: PlayListData? = null

    companion object {

        @Volatile
        private var instance: Repository? = null

        fun getInstance(noteDao: YoutubePlayList) = instance ?: synchronized(this) {
            instance ?: Repository(noteDao).also { instance = it }
        }

    }

    /*
    fun addNote(note:Note) {
        playListDAO.addNote(note)
    }

    fun getNotes() = playListDAO.getNotes()
*/
    fun getYoutubePlayList(CHANNEL_ID: String, API_KEY: String, limit: Int, callback: ServiceCallBack) {
        Log.d("SONUC", "Repository-getYoutubePlayList")

        playListDAO.getYoutubePlayList(CHANNEL_ID, API_KEY, limit, callback)

    }

}

