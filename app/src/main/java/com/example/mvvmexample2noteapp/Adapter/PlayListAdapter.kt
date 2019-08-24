package com.example.mvvmexample2noteapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample2noteapp.Model.Item
import com.example.mvvmexample2noteapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tek_satir_playlist.view.*

class PlaylistAdapter(oynatmaListeleri: List<Item?>?) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    var tumOynatmaListeleri = oynatmaListeleri

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var tekSatirPlaylist = inflater.inflate(R.layout.tek_satir_playlist, parent, false)

        return PlaylistViewHolder(tekSatirPlaylist)
    }

    override fun getItemCount(): Int {
        if (tumOynatmaListeleri != null) { return tumOynatmaListeleri!!.size }
        return 0
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {

        var oAnkiSatir = tumOynatmaListeleri?.get(position)
        holder.setData(oAnkiSatir, position)

    }


    inner class PlaylistViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var tekSatirPlaylist = itemView as CardView

        var titlePlaylist = tekSatirPlaylist.txtTitle
        var imagePlaylist = tekSatirPlaylist.imgPlaylist


        fun setData(oAnkiSatir: Item?, position: Int) {
            titlePlaylist.text = oAnkiSatir?.snippet?.title
            Picasso.with(tekSatirPlaylist.context).load(oAnkiSatir?.snippet?.thumbnails?.high?.url).into(imagePlaylist)

        }
    }

}
