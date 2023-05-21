package com.d3if3060.assessment1.ui.hitung

import androidx.lifecycle.*

import com.d3if3060.assessment1.model.HasilKonversi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitungViewModel : ViewModel() {


    private val _hasilKonversi = MutableLiveData<HasilKonversi>()
    val hasilKonversi: LiveData<HasilKonversi>
        get() = _hasilKonversi


    fun konversiJarak(inputText: String, isFeetChecked: Boolean) {
        val input = inputText.toDouble()
        if (inputText.isNotEmpty()) {
            val result = if (isFeetChecked) {
                convertFeetToMeter(input)
            } else {
                convertMeterToFeet(input)
            }
            val hasilKonversi = HasilKonversi(result, isFeetChecked)
            _hasilKonversi.value = hasilKonversi
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
