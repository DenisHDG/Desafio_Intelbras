package br.com.denis.desafio_intelbras.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import br.com.denis.desafio_intelbras.ui.theme.PrimaryColorIntelbras
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MyScreenContent() {
    // Lembre-se de obter o controller para a UI do sistema
    val systemUiController = rememberSystemUiController()
    // Defina a cor desejada para a status bar, por exemplo, azul (ou qualquer cor)
    val statusBarColor = PrimaryColorIntelbras // Exemplo: cor personalizada

    // Use SideEffect para aplicar a mudança sempre que a composição for executada
    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false // Ajuste para true se a cor for clara e você desejar ícones escuros
        )
    }

    // Aqui vem o conteúdo da tela do app
}