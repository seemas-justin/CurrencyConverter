package com.kwdcurrencyconverter.domain


interface CurrencyConverterRepository {
    suspend fun getCurrencyConversionValues(): Result<CurrencyListEntity>
}