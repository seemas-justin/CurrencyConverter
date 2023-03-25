package com.kwdcurrencyconverter.domain

data class CurrencyItemEntity(
    val symbol: String,
    val conversionValue: Double,
    val calculatedValue: Double = 0.0
)
