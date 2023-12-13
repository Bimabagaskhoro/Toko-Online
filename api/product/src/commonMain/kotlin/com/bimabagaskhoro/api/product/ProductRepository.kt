package com.bimabagaskhoro.api.product

import com.bimabagaskhoro.api.product.model.Mappers
import com.bimabagaskhoro.api.product.model.ProductList
import com.bimabagaskhoro.api.product.model.ProductListResponse
import com.bimabagaskhoro.api.product.model.BaseModelListResponse
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepository {
    private val dataSource by lazy { ProductDataSources() }
    suspend fun getProductList(): Flow<List<ProductList>> {
        val data = dataSource
            .getProductList()
            .body<BaseModelListResponse<ProductListResponse>>()
            .let { Mappers.mapToUi(it) }
        return flow {
            emit(data)
        }
    }
}