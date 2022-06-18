package com.example.medguru.ui.Medicine

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.medguru.R
import com.google.android.gms.common.api.Response
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    private lateinit var searchView: SearchView

    private lateinit var database: DatabaseReference

    val list = mutableListOf("")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        database = FirebaseDatabase.getInstance().reference
        var adapter = ArrayAdapter(
            requireActivity().applicationContext,
            android.R.layout.simple_dropdown_item_1line,list
        )
        medicines.adapter = adapter
        svSearchHome.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                Log.d("Text", newText)
                database.get().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val result = task.result
                        var curList = mutableListOf<String>()
                        result?.let {
                            Log.d("Children", it.children.toString())
                            for (child in it.children) {
                                for (subchild in child.children) {
                                    Log.d("Sub Children", subchild.toString())
                                    for (names in subchild.children) {
                                        if (names.key == "Column_3" && names.value.toString().contains(newText, ignoreCase = true) && !names.value!!.equals("Item Description")) {
                                            Log.d("Name", names.toString())
                                            curList.add(names.value.toString())
                                        }
                                    }
                                }
                            }
                            list.clear()
                            list.addAll(curList)
                            adapter.notifyDataSetChanged()
                        }
                    } else {

                    }

                }
                return true
            }
        })
        // TODO: Use the ViewModel
    }

}