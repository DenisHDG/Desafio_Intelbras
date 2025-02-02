package br.com.denis.desafio_intelbras.core.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import br.com.denis.desafio_intelbras.core.ui.theme.PrimaryColorIntelbras
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MyScreenContent() {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = PrimaryColorIntelbras
    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false
        )
    }
}