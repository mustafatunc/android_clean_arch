package com.mustafa.androidcleanarch.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mustafa.androidcleanarch.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val errorTextView: TextView = root.findViewById(R.id.text_home_error)

        root.findViewById<Button>(R.id.get_sample_btn).setOnClickListener {
            homeViewModel.getSample("Some Name")
        }

        homeViewModel.sampleLiveData.observe(viewLifecycleOwner, Observer {
            textView.text =
                "Sample: ${it.sampleName} - ${it.sampleCount} - ${it.sampleDate.toString()}"
        })

        homeViewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            errorTextView.text = "Error: ${it.message}"
        })

        return root
    }
}
