package com.kwdcurrencyconverter.domain

data class CurrencyListEntity(
    val timeStamp: Long?,
    val currencyItems: List<CurrencyItemEntity>?,
    val isSuccess: Boolean?
)