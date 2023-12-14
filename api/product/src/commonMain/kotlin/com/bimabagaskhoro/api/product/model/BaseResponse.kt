package com.bimabagaskhoro.api.product.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseModelListResponse<T>(
    @SerialName("status")
    val status: Boolean? = false,

    @SerialName("message")
    val message: String? = "",

    @SerialName("data")
    val data: List<T?>? = listOf()
)

@Serializable
data class BaseModelResponse<T>(
    @SerialName("status")
    val status: Boolean? = false,

    @SerialName("message")
    val message: String? = "",

    @SerialName("data")
    val data: T? = null
)