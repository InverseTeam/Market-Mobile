package ramble.sokol.sberafisha.authentication_and_splash.view.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import ramble.sokol.destinations.LoginScreenDestination
import ramble.sokol.inversemarket.R

@Destination(start = true)
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {

    val mContext = LocalContext.current

    val transition = rememberInfiniteTransition(label = "")
    val alpha by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    LaunchedEffect(
        key1 = true
    ) {
        delay(3000L)
        navigator.popBackStack()
        navigator.navigate(LoginScreenDestination)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp)
                .alpha(alpha = alpha),
            painter = painterResource(R.drawable.image_splash_screen),
            contentDescription = "imageSplashScreen"
        )

        Spacer(modifier = Modifier.padding(top = 50.dp))

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp)
                .alpha(alpha = alpha),
            painter = painterResource(R.drawable.image_text_splash_screen),
            contentDescription = "TextSplashScreen"
        )
    }
}
