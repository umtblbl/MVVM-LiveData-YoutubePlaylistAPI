package com.example.mvvmexample2noteapp.UI

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample2noteapp.Adapter.PlaylistAdapter
import com.example.mvvmexample2noteapp.Model.Item
import com.example.mvvmexample2noteapp.Model.PlayListData
import com.example.mvvmexample2noteapp.R
import com.example.mvvmexample2noteapp.Utilities.Utils
import kotlinx.android.synthetic.main.activity_note.*
import io.reactivex.plugins.RxJavaPlugins


class MainActivity : AppCompatActivity() {

    var viewModel: MainViewModel? = null
    var playList: PlayListData? = null
    var oynatmaListeleri: List<Item>? = null

    var myAdapter: PlaylistAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        initializeViewModel()
        initializeUI()

        /*btnAddNote.setOnClickListener {
            val note = Note(editTextNote.text.toString(), editTextAuthor.text.toString())
            viewModel?.addNote(note)
            editTextNote.setText("")
            editTextAuthor.setText("")

        }*/

    }
private fun initializeViewModel() {

    val factory = Utils.provideNoteViewModelFactory()
    viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

}
    private fun initializeUI() {

        Log.d("SONUC", "initializeUI")

        viewModel?.startApiCall(Utils.CHANNEL_ID, Utils.API_KEY, 25)


        viewModel?.liveYoutubePlaylist?.observe(this, Observer { liveYoutubePlaylist ->

            Log.d("SONUC", "observe-MainActivity")

            playList = liveYoutubePlaylist
            oynatmaListeleri = playList?.items
            supportActionBar?.subtitle = "Toplam Liste:${oynatmaListeleri?.size}"

            initializeRecyclerView()

        })



    }

    @SuppressLint("WrongConstant")
    fun initializeRecyclerView() {

        myAdapter = PlaylistAdapter(oynatmaListeleri)
        var layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        recyclerViewPlayList.layoutManager = layoutManager

        recyclerViewPlayList.adapter = myAdapter

        myAdapter!!.notifyDataSetChanged()
    }


}
