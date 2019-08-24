package com.example.youtubeplaylist

import com.example.mvvmexample2noteapp.Model.PlayListData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiInterface {
//https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCXebEXcYgA&maxResults=10&key={YOUR_API_KEY}


    @GET("playlists?part=snippet")
    fun getChannelPlayList(
        @Query("channelId") channelID: String,
        @Query("key") apiKey: String,
        @Query("maxResults") limit:Int
    ):Call<PlayListData>
    /*
    @GET("playlists?part=snippet")
    fun getChannelPlayList(
        @Query("channelId") channelID: String,
        @Query("key") apiKey: String,
        @Query("maxResults") limit: Int
*/
}