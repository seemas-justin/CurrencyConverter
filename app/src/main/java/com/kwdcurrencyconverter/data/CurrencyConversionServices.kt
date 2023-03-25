package com.kwdcurrencyconverter.data

import com.kwdcurrencyconverter.data.models.CurrencySymbolsResponse
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyConversionServices {

    @GET("latest?symbols=symbols&base=KWD")
    suspend fun getCurrencyConversionRate(): Response<CurrencySymbolsResponse>
}