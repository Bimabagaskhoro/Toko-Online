package com.bimabagaskhoro.api.product.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductListResponse(
    @SerialName("status")
    val status: Boolean? = false,

    @SerialName("message")
    val message: String? = "",

    @SerialName("data")
    val data: List<DataItem?>? = listOf()
) {
    @Serializable
    data class DataItem(
        @SerialName("id")
        val id: Int? = 0,

        @SerialName("name")
        val name: String? = "",

        @SerialName("sort_description")
        val sortDescription: String? = "",

        @SerialName("category")
        val category: CategoryItem? = null,

        @SerialName("price")
        val price: Double? = 0.0,

        @SerialName("rating")
        val rating: Double? = 0.0,

        @SerialName("discount")
        val discount: Int? = 0,

        @SerialName("images")
        val images: String? = "",

        ) {
        @Serializable
        data class CategoryItem(
            @SerialName("id")
            val id: Int? = 0,

            @SerialName("name")
            val name: String? = "",

            @SerialName("description")
            val description: String? = "",
        )
    }
}
