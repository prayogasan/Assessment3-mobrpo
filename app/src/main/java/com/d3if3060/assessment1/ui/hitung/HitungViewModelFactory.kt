//package com.d3if3060.assessment1.ui.hitung
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.d3if3060.assessment1.db.KonversiDao
//
//class HitungViewModelFactory(
//    private val db: KonversiDao
//) : ViewModelProvider.Factory {
//    @Suppress("unchecked_cast")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(HitungViewModel::class.java)) {
//            return HitungViewModel(db) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}