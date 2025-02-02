package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import br.com.denis.desafio_intelbras.R
import br.com.denis.desafio_intelbras.ui.component.MyScreenContent
import br.com.denis.desafio_intelbras.ui.theme.PrimaryColorIntelbras
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {

    MyScreenContent()

    LaunchedEffect(key1 = true) {
        delay(3000L)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColorIntelbras),
        contentAlignment = Alignment.Center,

        ) {
        Image(
            painter = painterResource(id = R.drawable.splash_i),
            contentDescription = "Splash Image"
        )
    }
}