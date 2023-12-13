package com.bimabagaskhoro.api.product.model

object Mappers {
    fun mapToUi(response: ProductListResponse?): List<ProductList> {
        return response?.data?.map {
            mapItemToUi(it)
        }.orEmpty()
    }

    private fun mapItemToUi(response: ProductListResponse.DataItem?): ProductList {
        return ProductList(
            id = response?.id ?: 0,
            name = response?.name.orEmpty(),
            price = response?.price ?: 0.0,
            image = response?.images.orEmpty(),
            discount = response?.discount ?: 0
        )
    }
}