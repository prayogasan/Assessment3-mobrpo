//package com.d3if3060.assessment1.db
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//
//@Dao
//interface KonversiDao {
//    @Insert
//    fun insert(konversi: KonversiEntity)
//
//    @Query("SELECT * FROM konversi ORDER BY tanggal DESC")
//    fun getLastKonversi(): List<KonversiEntity>
//}