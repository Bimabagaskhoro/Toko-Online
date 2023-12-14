package com.bimabagaskhoro.libraries.core.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.ViewModel as AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import androidx.lifecycle.viewModelScope as lifecycleViewModelScope

actual abstract class ViewModel : AndroidViewModel() {
    actual val viewModelScope: CoroutineScope = lifecycleViewModelScope
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    actual fun cleared() {
        super.onCleared()
    }
}

@Composable
actual fun <T : ViewModel> rememberViewModel(isRetain: Boolean, viewModel: () -> T): T {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val host = LocalViewModelHost.current
    val vm = remember {
        if (isRetain) {
            host.getViewModel(viewModel.invoke())
        } else {
            viewModel.invoke()
        }
    }

    if (!isRetain) {
        DisposableEffect(lifecycle) {
            onDispose {
                vm.cleared()
            }
        }
    }
    return vm
}