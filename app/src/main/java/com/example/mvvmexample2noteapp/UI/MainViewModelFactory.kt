package com.example.mvvmexample2noteapp.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample2noteapp.Data.Repository

class MainViewModelFactory (private val noteRepository: Repository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(noteRepository) as T
    }

}