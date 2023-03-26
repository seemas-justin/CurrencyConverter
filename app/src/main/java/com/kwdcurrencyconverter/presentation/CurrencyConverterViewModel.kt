package com.kwdcurrencyconverter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kwdcurrencyconverter.domain.CurrencyConverterRepository
import com.kwdcurrencyconverter.domain.CurrencyItemEntity
import com.kwdcurrencyconverter.domain.CurrencyListEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    private val currencyConverterRepository: CurrencyConverterRepository
): ViewModel(){
    private val _currencyListState: MutableLiveData<CurrencyListEntity> = MutableLiveData()
    val currencyListState: LiveData<CurrencyListEntity>
        get() = _currencyListState

    private val _currencyListLoadingState: MutableLiveData<Boolean> = MutableLiveData()
    val currencyListLoadingState: LiveData<Boolean>
     get() = _currencyListLoadingState

    fun getCurrencyConversionList() {
        viewModelScope.launch {
             _currencyListLoadingState.postValue(true)
             currencyConverterRepository.getCurrencyConversionValues()
                .onSuccess {
                    _currencyListLoadingState.postValue(false)
                    _currencyListState.postValue(it)
                }
                 .onFailure {
                     _currencyListLoadingState.postValue(false)
                     _currencyListState.postValue(CurrencyListEntity(
                         isSuccess = false,
                         currencyItems = null,
                         timeStamp = null
                     ))
                 }
        }

    }

    fun convertCurrency(currencyValue: String) {
        if (currencyListState.value?.currencyItems!=null) {
            val list: List<CurrencyItemEntity> = _currencyListState.value?.currencyItems!!
            list.forEach {
                it.calculatedValue = it.conversionValue * currencyValue.toDouble()
            }
            _currencyListState.postValue(
                currencyListState.value!!.copy(
                currencyItems = list
            ))
        }
    }


}