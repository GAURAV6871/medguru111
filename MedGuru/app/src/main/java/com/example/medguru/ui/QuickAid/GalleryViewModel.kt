package com.example.medguru.ui.QuickAid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Can have QUICK AID here!!"
    }
    val text: LiveData<String> = _text
}