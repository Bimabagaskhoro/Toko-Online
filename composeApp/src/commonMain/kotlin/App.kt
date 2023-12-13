import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.bimabagaskhoro.feature.home.Home
import com.bimabagaskhoro.libraries.core.viewmodel.LocalViewModelHost
import com.bimabagaskhoro.libraries.core.viewmodel.ViewModelHost

@Composable
fun App() {
    val viewModelHost = remember { ViewModelHost() }

    CompositionLocalProvider(
        LocalViewModelHost provides viewModelHost
    ) {
        MaterialTheme {
            Home()
        }
    }
}