package ramble.sokol.inversemarket.markets.view.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ramble.sokol.destinations.CurrentMarketDestination
import ramble.sokol.inversemarket.R
import ramble.sokol.inversemarket.authentication_and_splash.view.components.ProgressBarAuth
import ramble.sokol.inversemarket.basket.view.components.CardEventsResponse
import ramble.sokol.inversemarket.model_project.RetrofitHelper
import ramble.sokol.inversemarket.ui.theme.ColorBackMarkets
import ramble.sokol.inversemarket.ui.theme.ColorFalseHome
import ramble.sokol.inversemarket.ui.theme.ColorTrueNav
import ramble.sokol.sberafisha.afisha.model.data.ResponseEvents
import ramble.sokol.sberafisha.afisha.model.service.APIAfisha
import ramble.sokol.sberafisha.model_project.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var check: MutableState<Boolean>
private lateinit var list: ArrayList<ResponseEvents>
private lateinit var apiAfisha: APIAfisha
private lateinit var tokenManager: TokenManager

@Composable
@Destination
fun MarketsScreen(
    navigator: DestinationsNavigator
){

    val context = LocalContext.current

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    list = arrayListOf()

    check = remember {
        mutableStateOf(false)
    }

    tokenManager = TokenManager(context = context)

    apiAfisha = RetrofitHelper.getInstance().create(APIAfisha::class.java)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ColorBackMarkets,
                    shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)
                )
                .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Row(
                    modifier = Modifier
                        .weight(0.5f)
                        .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
                        .padding(start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp)
                        .clickable { selectedItem = 0 },
                    horizontalArrangement = Arrangement.Center
                ){

                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.icon_bag),
                        contentDescription = "Poster",
                        tint = if (selectedItem == 0) ColorTrueNav else ColorFalseHome
                    )

                    Spacer(modifier = Modifier.padding(start = 8.dp))

                    Text(
                        text = "Доставка",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
                            fontWeight = FontWeight(500),
                            color = if (selectedItem == 0) ColorTrueNav else ColorFalseHome,
                            textAlign = TextAlign.Center,
                        )
                    )

                }
                
                Spacer(modifier = Modifier.padding(start = 16.dp))

                Row(
                    modifier = Modifier
                        .weight(0.5f)
                        .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
                        .padding(start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp)
                        .clickable { selectedItem = 1 },
                    horizontalArrangement = Arrangement.Center
                ){

                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.icon_home),
                        contentDescription = "icon_home",
                        tint = if (selectedItem == 1) ColorTrueNav else ColorFalseHome
                    )

                    Spacer(modifier = Modifier.padding(start = 8.dp))

                    Text(
                        text = "Столовая",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
                            fontWeight = FontWeight(500),
                            color = if (selectedItem == 1) ColorTrueNav else ColorFalseHome,
                            textAlign = TextAlign.Center,
                        )
                    )

                }

            }

        }

        Spacer(modifier = Modifier.padding(top = 16.dp))

        Text(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
            text = "Супермаркеты",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            ),
            textAlign = TextAlign.Start
        )
        
        Spacer(modifier = Modifier.padding(top = 16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Image(
                modifier = Modifier.clickable {
                                              navigator.navigate(CurrentMarketDestination)},
                painter = painterResource(id = R.drawable.markets_image), contentDescription = "markets_image")

//            if (!check.value) {
//                ProgressBarAuth()
//            } else {
//                LazyColumn() {
//                    Log.d("MyLog", "LazyRowTheater")
//                    items(list) { event: Int ->
//                        CardEventsResponse(event = event) {
//
//                        }
//                    }
//                }
//            }
        }

    }

}

//private fun getData(context: Context, date: String, category: Int?){
//
//    val call = apiAfisha.getAllEvents(date, category, "Token ${tokenManager.getToken()!!}")
//
//    call.enqueue(object : Callback<ArrayList<ResponseEvents>> {
//        override fun onResponse(call: Call<ArrayList<ResponseEvents>>, response: Response<ArrayList<ResponseEvents>>) {
//            if (response.isSuccessful) {
//                val responseBody = response.body()
//                list = responseBody!!
//                //Log.d("MyLog", listRecommendEvents.toString())
//                check.value = list.isNotEmpty()
//            } else {
//                Log.d("MyLog", response.toString())
//                Toast.makeText(context, R.string.text_appeared_error, Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        override fun onFailure(call: Call<ArrayList<ResponseEvents>>, t: Throwable) {
//            Toast.makeText(context, R.string.text_toast_no_internet, Toast.LENGTH_SHORT).show()
//        }
//    })
//
//}