package ramble.sokol.sberafisha.authentication_and_splash.view.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ramble.sokol.destinations.BottomMenuScreenDestination
import ramble.sokol.inversemarket.R
import ramble.sokol.inversemarket.authentication_and_splash.view.components.ButtonForLogin
import ramble.sokol.inversemarket.authentication_and_splash.view.components.ProgressBarAuth
import ramble.sokol.inversemarket.authentication_and_splash.view.components.TextInputEmailEntry
import ramble.sokol.inversemarket.authentication_and_splash.view.components.TextInputPasswordEntry
import ramble.sokol.inversemarket.ui.theme.ColorBorderTextInput
import ramble.sokol.inversemarket.ui.theme.ColorError

private lateinit var progressEntryState: MutableState<Boolean>

@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
){

    val mContext = LocalContext.current

    progressEntryState = remember {
        mutableStateOf(false)
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    var passwordError by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 76.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_logo_login),
                contentDescription = "image_logo_login"
            )
        }
        
        Spacer(modifier = Modifier.padding(top = 24.dp))
        
        TextInputEmailEntry(
            text = email,
            onValueChange = {
                emailError = false
                passwordError = false
                //incorrectData.value = false
                email = it
            },
            color = if (emailError) ColorError else ColorBorderTextInput,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {
                                emailError = false
                                passwordError = false
                                //incorrectData.value = false
                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 12.dp))

        TextInputPasswordEntry(
            text = password,
            onValueChange = {
                emailError = false
                passwordError = false
                //incorrectData.value = false
                password = it
            },
            color = if (passwordError) ColorError else ColorBorderTextInput,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {
                                emailError = false
                                passwordError = false
                                //incorrectData.value = false
                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 30.dp))

        if (progressEntryState.value){

            Box(
                modifier = Modifier.fillMaxWidth().height(52.dp),
                contentAlignment = Alignment.Center
            ){
                ProgressBarAuth()
            }
        }else{
            ButtonForLogin(text = stringResource(id = R.string.text_entry)){
                if (password.isEmpty()){
                    passwordError = true
                }
                if (email.isEmpty()){
                    emailError = true
                }
                if (!email.isEmpty() && !password.isEmpty()) {
                    progressEntryState.value = true
                    entry(mContext, navigator, email, password)
                }
            }

        }

    }

}

private fun entry(context: Context, navigator: DestinationsNavigator, email: String, password: String){
    navigator.popBackStack()
    navigator.navigate(BottomMenuScreenDestination)

//    val body = JsonObject().apply {
//        addProperty("email", email)
//        addProperty("password", password)
//    }
//    val call = apiAuth.entryAndGetToken(body)
//
//    call.enqueue(object : Callback<ResponseAuth> {
//        override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
//            if (response.isSuccessful) {
//                val responseBody = response.body()
//                tokenManager.saveToken(responseBody!!.authToken)
//                firstEntryManager.saveFirstEntry(true)
//                firstEntryManager.saveFirstTest(true)
//                progressEntryState.value = false
//                Toast.makeText(context, R.string.text_successful_entry, Toast.LENGTH_SHORT).show()
//                navigator.popBackStack()
//                navigator.navigate(BottomMenuScreenDestination)
//            } else {
//                progressEntryState.value = false
//                incorrectData.value = true
//            }
//        }
//
//        override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
//            Toast.makeText(context, R.string.text_toast_no_internet, Toast.LENGTH_SHORT).show()
//            progressEntryState.value = false
//        }
//    })


}