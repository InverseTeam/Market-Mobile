package ramble.sokol.inversemarket.main.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.annotation.Destination
import ramble.sokol.inversemarket.R
import ramble.sokol.inversemarket.basket.view.screens.BasketScreen
import ramble.sokol.inversemarket.markets.view.screens.MarketsScreen
import ramble.sokol.inversemarket.menu.view.screens.MenuScreen
import ramble.sokol.inversemarket.profile.view.screens.ProfileScreen
import ramble.sokol.inversemarket.ui.theme.ColorFalseNav
import ramble.sokol.inversemarket.ui.theme.ColorTrueNav

@Destination
@Composable
fun BottomMenuScreen(
    navigator: DestinationsNavigator
){

    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomNavigation (
            modifier = Modifier
                .shadow(elevation = 39.dp, spotColor = Color(0x0FFF9A42), ambientColor = Color(0x0FFF9A42))
                .wrapContentSize()
                .clip(RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)),
            elevation = 4.dp,
            backgroundColor = Color.White,
        ){

            BottomNavigationItem(
                selected = selectedItem == 0,
                onClick = {
                    selectedItem = 0
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.icon_markets),
                        contentDescription = "Poster",
                        tint = if (selectedItem == 0) ColorTrueNav else ColorFalseNav
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.text_markets),
                        color = if (selectedItem == 0) ColorTrueNav else ColorFalseNav,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
                            fontWeight = FontWeight(500),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.16.sp,
                        )
                    )
                }
            )
            BottomNavigationItem(
                selected = selectedItem == 1,
                onClick = {
                    selectedItem = 1
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.icon_menu),
                        contentDescription = "Route",
                        tint = if (selectedItem == 1) ColorTrueNav else ColorFalseNav
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.text_menu),
                        color = if (selectedItem == 1) ColorTrueNav else ColorFalseNav,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
                            fontWeight = FontWeight(500),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.16.sp,
                        )
                    )
                }
            )
            BottomNavigationItem(
                selected = selectedItem == 2,
                onClick = {
                    selectedItem = 2
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.icon_basket),
                        contentDescription = "Actually",
                        tint = if (selectedItem == 2) ColorTrueNav else ColorFalseNav
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.text_basket),
                        color = if (selectedItem == 2) ColorTrueNav else ColorFalseNav,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
                            fontWeight = FontWeight(500),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.16.sp,
                        )
                    )
                }
            )
            BottomNavigationItem(
                selected = selectedItem == 3,
                onClick = {
                    selectedItem = 3
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .width(23.dp)
                            .height(23.dp),
                        painter = painterResource(id = R.drawable.icon_profile),
                        contentDescription = "Profile",
                        tint = if (selectedItem == 3) ColorTrueNav else ColorFalseNav
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.text_profile),
                        color = if (selectedItem == 3) ColorTrueNav else ColorFalseNav,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
                            fontWeight = FontWeight(500),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.16.sp,
                        )
                    )
                }
            )
        }
    }

    when (selectedItem){
        0 -> MarketsScreen(navigator)
        1 -> MenuScreen(navigator)
        2 -> BasketScreen(navigator)
        3 -> ProfileScreen(navigator)
    }

}