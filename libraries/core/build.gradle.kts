plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "core"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            api(libs.kotlin.coroutine)
            api(libs.ktor.client.core)
            api(libs.ktor.client.contentNegotiation)
            api(libs.ktor.client.serialization)
            api(libs.ktor.client.loggin)
        }
        androidMain.dependencies {
            api(libs.android.viewmodel)
            api(libs.android.viewmodel.compose)
            api(libs.ktor.client.okhttp)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            api(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.bimabagaskhoro.libraries.core"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}