package com.example.medguru.ui.sanitaryItems

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medguru.R

class SanitaryItems : Fragment() {

    companion object {
        fun newInstance() = SanitaryItems()
    }

    private lateinit var viewModel: SanitaryItemsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sanitary_item, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SanitaryItemsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}