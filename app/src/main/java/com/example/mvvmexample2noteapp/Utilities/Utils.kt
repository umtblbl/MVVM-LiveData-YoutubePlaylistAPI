package com.example.mvvmexample2noteapp.Utilities

import com.example.mvvmexample2noteapp.Data.Repository
import com.example.mvvmexample2noteapp.UI.MainViewModelFactory
import com.example.mvvmexample2noteapp.XNoteDaoData.YoutubePlayList

object Utils {

    val API_KEY = "you APIKEY" // developers.google.com ---> Youtube Data v3 API ---> playlist.list
    val CHANNEL_ID = "you CHANNELID"

    fun provideNoteViewModelFactory(): MainViewModelFactory {
        val noteRepository = Repository.getInstance(YoutubePlayList.getInstance())
        return  MainViewModelFactory(noteRepository)
    }

}