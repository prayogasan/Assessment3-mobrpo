package com.d3if3060.assessment1.api

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.d3if3060.assessment1.R

class AboutApiFragment : Fragment() {
    private lateinit var viewModel: AboutApiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_about_api, container, false)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application))
            .get(AboutApiViewModel::class.java)
        viewModel.fetchAboutData()

        viewModel.aboutData.observe(viewLifecycleOwner, Observer { aboutResponse ->
            // Update tampilan dengan data dari API
            view.findViewById<TextView>(R.id.titleTextView).text = aboutResponse.title
            view.findViewById<TextView>(R.id.descriptionTextView).text = aboutResponse.body
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { errorMessage ->
            // Tangani pesan kesalahan
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
        })

        return view
    }
}
