package com.bimabagaskhoro.libraries.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform