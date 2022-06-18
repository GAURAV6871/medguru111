package com.example.medguru.ui.Medicine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "You can find everything about MEDICINES here!!"
    }
    val text: LiveData<String> = _text
}