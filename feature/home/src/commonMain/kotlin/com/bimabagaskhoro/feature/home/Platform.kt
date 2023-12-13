package com.bimabagaskhoro.feature.home

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform