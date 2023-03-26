package com.d3if3060.assessment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.d3if3060.assessment1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { konversiJarak() }
    }

    private fun konversiJarak(){
        val editText1 = binding.editText1.text.toString().toFloat()
        if (TextUtils.isEmpty(editText1.toString())) {
            Toast.makeText(this, R.string.jarak_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, R.string.selected_invalid, Toast.LENGTH_LONG).show()
            return
        }

        binding.button.setOnClickListener {
            val inputText = binding.editText1.text.toString()

            if (inputText.isNotEmpty()) {
                val input = inputText.toDouble()
                val result = if (binding.RBfeet.isChecked) {
                    convertMeterToFeet(input)
                } else {
                    convertFeetToMeter(input)
                }

                val resultText = "%.2f".format(result)
                if (binding.RBMeter.isChecked) {
                    binding.konversiTextView.text = "$resultText feet"
                } else {
                    binding.konversiTextView.text = "$resultText meters"
                }
            } else {
                Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show()
            }
        }
    }



    private fun convertMeterToFeet(meter: Double): Double {
        val feetPerMeter = 3.28084
        return meter * feetPerMeter
    }

    private fun convertFeetToMeter(feet: Double): Double {
        val meterPerFeet = 0.3048
        return feet * meterPerFeet
    }
}