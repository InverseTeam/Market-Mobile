package ramble.sokol.inversemarket.basket.view.components

import android.util.Log
import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ramble.sokol.inversemarket.R
import ramble.sokol.sberafisha.afisha.model.data.AllEventsItem

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CardEvents(
    event: AllEventsItem,
    click: () -> Unit
){

    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { click() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(16.dp)),
            painter = rememberAsyncImagePainter("https://inverse-tracker.store/${event.cover}"),
            contentDescription = "image events",
            contentScale = ContentScale.Crop
        )


        Spacer(modifier = Modifier.padding(top = 12.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = event.name,
            style = TextStyle(
                fontSize = 19.7.sp,
                lineHeight = 21.67.sp,
                fontFamily = FontFamily(Font(R.font.sf_pro_display_bold)),
                fontWeight = FontWeight(700),
                color = Color(0xFF222222),
            ),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.padding(top = 20.dp))
    }
}
