package com.kwdcurrencyconverter.domain

data class CurrencyListEntity(
    val timeStamp: Double?,
    val currencyItems: List<CurrencyItemEntity>?,
    val isSuccess: Boolean?
)