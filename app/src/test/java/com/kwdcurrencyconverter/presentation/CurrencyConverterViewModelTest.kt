package com.kwdcurrencyconverter.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kwdcurrencyconverter.domain.CurrencyConverterRepository
import com.kwdcurrencyconverter.domain.CurrencyItemEntity
import com.kwdcurrencyconverter.domain.CurrencyListEntity
import com.kwdcurrencyconverter.helper.MainCoroutineRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class CurrencyConverterViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()


    @Test
    fun checkIfInitialiseMethodCalls() = mainCoroutineRule.runBlockingTest{
            //arrange
        val currencyConverterRespository: CurrencyConverterRepository = mockk()
        val currencyListEntity = CurrencyListEntity(
            timeStamp = 123456,
            currencyItems = listOf(
                CurrencyItemEntity(
                    symbol = "AED",
                    conversionValue = 45.0
                ),
                CurrencyItemEntity(
                    symbol = "INR",
                    conversionValue = 250.0
                )
            ),
            isSuccess = true
        )
            coEvery { currencyConverterRespository.getCurrencyConversionValues() } returns Result.success(
                currencyListEntity
            )
        //act
        val sut = CurrencyConverterViewModel(currencyConverterRespository)
        sut.initialise()

        //assert
        coVerify { currencyConverterRespository.getCurrencyConversionValues() }


      }
    }
