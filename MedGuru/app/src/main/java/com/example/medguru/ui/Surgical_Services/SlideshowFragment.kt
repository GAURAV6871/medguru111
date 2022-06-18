package com.example.medguru.ui.Surgical_Services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.medguru.R
import com.example.medguru.databinding.FragmentSlideshowBinding
import com.example.medguru.ui.sanitaryItems.SanitaryItems
import com.example.medguru.ui.sanitaryItems.SanitaryItemsViewModel

class SlideshowFragment : Fragment() {

    companion object {
        fun newInstance() = SlideshowFragment()
    }

    private lateinit var viewModel: SlideshowViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_slideshow, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SlideshowViewModel::class.java)
        // TODO: Use the ViewModel
    }

}