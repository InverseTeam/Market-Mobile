@file:OptIn(ExperimentalMaterial3Api::class)

package ramble.sokol.inversemarket.authentication_and_splash.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramble.sokol.inversemarket.R
import ramble.sokol.inversemarket.ui.theme.ColorBorderTextInput
import ramble.sokol.inversemarket.ui.theme.ColorTextField
import ramble.sokol.inversemarket.ui.theme.ColorTextHint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputPasswordEntry(
    text: String,
    onValueChange: (String) -> Unit,
    color: Color = ColorBorderTextInput,
    interactionSource: MutableInteractionSource
){

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(width = 1.dp, color = color, shape = RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        value = text,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
            fontWeight = FontWeight(400),
            color = ColorTextField,
            letterSpacing = 0.32.sp
            ),
        interactionSource = interactionSource,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                stringResource(id = R.string.text_hint_password),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = ColorTextHint,
                    fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
                    fontWeight = FontWeight(400),
                    letterSpacing = 0.32.sp
                    )
            ) },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = ColorTextField,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            containerColor = Color.Transparent
        ),
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
}