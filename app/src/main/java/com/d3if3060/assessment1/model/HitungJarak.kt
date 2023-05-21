package com.d3if3060.assessment1.model

fun convertMeterToFeet(meter: Double): Double {
    val feetPerMeter = 3.28084
    return meter * feetPerMeter
}

fun convertFeetToMeter(feet: Double): Double {
    val meterPerFeet = 0.3048
    return feet * meterPerFeet
}