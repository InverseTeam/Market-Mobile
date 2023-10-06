package ramble.sokol.inversemarket.basket.view.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import ramble.sokol.sberafisha.afisha.model.data.ResponseEvents
import java.util.ArrayList

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CardEventsResponse(
    event: ResponseEvents,
    click: () -> Unit
){

    //Log.d("MyLog", "cardEvents")

    Column(modifier = Modifier
        .width(241.dp)
        .padding(horizontal = 4.dp)
        .clickable { click() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            modifier = Modifier
                .height(120.dp)
                .width(241.dp)
                .clip(RoundedCornerShape(16.dp)),
            painter = rememberAsyncImagePainter(event.cover),
            contentDescription = "image events",
            contentScale = ContentScale.Crop
        )


        Spacer(modifier = Modifier.padding(top = 12.dp))

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            var textName = ""
            textName = if (event.name.length < 20) event.name
            else "${event.name.substring(0, 18)}..."

            Text(
                text = textName,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 15.4.sp,
                    fontFamily = FontFamily(Font(R.font.sf_pro_display_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF222222),
                ),
                textAlign = TextAlign.Start
            )
        }
    }
}
