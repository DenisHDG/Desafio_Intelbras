package br.com.denis.desafio_intelbras.feature.products.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import br.com.denis.desafio_intelbras.R
import br.com.denis.desafio_intelbras.feature.products.navigation.ROUT_HOME
import br.com.denis.desafio_intelbras.feature.products.navigation.ROUT_SPLASH
import br.com.denis.desafio_intelbras.ui.component.MyScreenContent
import br.com.denis.desafio_intelbras.ui.theme.PrimaryColorIntelbras
import kotlinx.coroutines.delay

const val delayTime = 3000L

@Composable
fun SplashScreen(navController: NavController) {

    MyScreenContent()

    LaunchedEffect(key1 = true) {
        delay(delayTime)
        navController.navigate(ROUT_HOME) {
            popUpTo(ROUT_SPLASH) { inclusive = true }
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