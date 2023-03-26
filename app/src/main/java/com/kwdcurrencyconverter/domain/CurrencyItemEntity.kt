package com.kwdcurrencyconverter.domain

data class CurrencyItemEntity(
    val symbol: String,
    val conversionValue: Double,
    var calculatedValue: Double = 0.0
)
