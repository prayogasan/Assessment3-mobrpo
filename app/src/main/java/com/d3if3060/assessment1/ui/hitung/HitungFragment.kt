package com.d3if3060.assessment1.ui.hitung

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.d3if3060.assessment1.R
import com.d3if3060.assessment1.databinding.FragmentHitungBinding


class HitungFragment : Fragment() {
    private lateinit var binding: FragmentHitungBinding

    private lateinit var viewModel: HitungViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHitungBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(HitungViewModel::class.java)

        binding.button.setOnClickListener {
            val inputText = binding.editText1.text.toString()
            val isFeetChecked = binding.RBfeet.isChecked

            viewModel.konversiJarak(inputText, isFeetChecked)
        }

        viewModel.hasilKonversi.observe(viewLifecycleOwner, Observer { hasilKonversi ->
            val resultText = "%.2f".format(hasilKonversi.hasil)
            if (hasilKonversi.isFeet) {
                binding.konversiTextView.text = "$resultText Meters"
            } else {
                binding.konversiTextView.text = "$resultText feet"
            }

            if (hasilKonversi.hasil != null) {
                binding.shareButton.visibility = View.VISIBLE // Tampilkan tombol "Share" jika hasil perhitungan tersedia
            } else {
                binding.shareButton.visibility = View.GONE // Sembunyikan tombol "Share" jika hasil perhitungan tidak tersedia
            }
        })

        binding.shareButton.setOnClickListener { shareData() }

        return binding.root
    }


    private fun shareData() {
        val resultText = binding.konversiTextView.text.toString()
        val customText = "Hasil konversi jarak adalah: $resultText"

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, customText)

        val chooserIntent = Intent.createChooser(shareIntent, "Bagikan hasil konversi")
        if (shareIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(chooserIntent)
        } else {
            Toast.makeText(requireContext(), "Tidak ada aplikasi yang tersedia untuk berbagi", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(R.id.action_hitungFragment_to_historiFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(
                    R.id.action_hitungFragment_to_aboutFragment
                )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}