package com.kwdcurrencyconverter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kwdcurrencyconverter.domain.CurrencyConverterRepository
import com.kwdcurrencyconverter.domain.CurrencyListEntity
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrencyConverterViewModel @Inject constructor(
    private val currencyConverterRepository: CurrencyConverterRepository
): ViewModel(){
    private val _currencyListState: MutableLiveData<CurrencyListEntity> = MutableLiveData()
    val currencyListState: LiveData<CurrencyListEntity>
        get() = _currencyListState

    fun getCurrencyConversionList() {
        viewModelScope.launch {
             currencyConverterRepository.getCurrencyConversionValues()
                .onSuccess {
                    _currencyListState.postValue(it)
                }
                 .onFailure {
                     _currencyListState.postValue(CurrencyListEntity(
                         isSuccess = false,
                         currencyItems = null,
                         timeStamp = null
                     ))
                 }
        }

    }


}