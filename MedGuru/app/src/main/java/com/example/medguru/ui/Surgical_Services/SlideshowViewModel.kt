package com.example.medguru.ui.Surgical_Services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "You can have surgical services here!!"
    }
    val text: LiveData<String> = _text
}