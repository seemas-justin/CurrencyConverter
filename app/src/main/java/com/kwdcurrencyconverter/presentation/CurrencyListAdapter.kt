package com.kwdcurrencyconverter.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kwdcurrencyconverter.databinding.ListItemCurrencyBinding
import com.kwdcurrencyconverter.domain.CurrencyItemEntity
import javax.inject.Inject
import javax.inject.Singleton


//@Singleton
//class CurrencyListAdapter @Inject constructor() : ListAdapter<CurrencyItemEntity, CurrencyListAdapter.ViewHolder>(() {
//
//}) {
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//
//    inner class ViewHolder constructor(private val binding: ListItemCurrencyBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(currencyItemEntity: CurrencyItemEntity) {
//            binding.textviewConversion.text = currencyItemEntity.symbol
//            if(currencyItemEntity.calculatedValue == 0.0) {
//                binding.textviewCalculatedvalue.visibility = View.GONE
//            }else{
//                binding.textviewCalculatedvalue.visibility = View.VISIBLE
//                binding.textviewCalculatedvalue.text = currencyItemEntity.calculatedValue.toString()
//            }
//            binding.textviewConversion.text = currencyItemEntity.conversionValue.toString()
//        }
//    }
//
//}