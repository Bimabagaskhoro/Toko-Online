package com.bimabagaskhoro.api.product

import com.bimabagaskhoro.libraries.core.network.NetworkDataSource
import io.ktor.client.statement.HttpResponse

class ProductDataSources : NetworkDataSource("https://marketfake.fly.dev/") {
    suspend fun getProductList(): HttpResponse {
        val endPoint = "product"
        return getHttpResponse(endPoint)
    }
}