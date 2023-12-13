package com.bimabagaskhoro.api.product

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform