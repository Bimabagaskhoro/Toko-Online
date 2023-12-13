package com.bimabagaskhoro.feature.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.bimabagaskhoro.api.product.ProductRepository
import com.bimabagaskhoro.api.product.model.ProductList
import com.bimabagaskhoro.libraries.core.viewmodel.rememberViewModel

@Composable
fun Home() {
    val productRepository = remember { ProductRepository() }
    val homeViewModel = rememberViewModel { HomeViewModel(productRepository) }
    val productList by homeViewModel.productList.collectAsState()

    LaunchedEffect(Unit) {
        homeViewModel.getProductList()
    }

    LazyColumn {
        items(productList) {
            ProductListItem(it)
        }
    }
}

@Composable
fun ProductListItem(productList: ProductList) {
    Text(
        text = productList.name
    )
}