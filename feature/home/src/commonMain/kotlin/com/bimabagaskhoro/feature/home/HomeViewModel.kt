package com.bimabagaskhoro.feature.home

import com.bimabagaskhoro.api.product.ProductRepository
import com.bimabagaskhoro.api.product.model.ProductList
import com.bimabagaskhoro.libraries.core.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(private val productRepository: ProductRepository) : ViewModel() {
    val productList = MutableStateFlow<List<ProductList>>(emptyList())

    fun getProductList() = viewModelScope.launch {
        productRepository
            .getProductList()
            .stateIn(this)
            .collect(productList)
    }
}