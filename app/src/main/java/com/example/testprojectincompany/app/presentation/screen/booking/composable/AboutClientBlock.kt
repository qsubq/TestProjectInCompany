package com.example.testprojectincompany.app.presentation.screen.booking.composable

import android.util.Patterns
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testprojectincompany.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutClientBlock(
    emailTextState: MutableState<String>,
    numberTextState: MutableState<String>,
    emailErrorState: MutableState<Boolean>,
    numberErrorState: MutableState<Boolean>,
) {
    Card(
        modifier = Modifier.padding(top = 8.dp),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(top = 16.dp, start = 16.dp, bottom = 16.dp, end = 16.dp),
        ) {
            Text(
                modifier = Modifier,
                text = "Информация о покупателе",
                color = Color.Black,
                fontSize = 22.sp,
                style = TextStyle(
                    lineHeight = 26.4.sp,
                    fontWeight = FontWeight(500),
                ),
                textAlign = TextAlign.End,
            )

            PhoneField(
                phone = numberTextState.value,
                errorState = numberErrorState.value,
                mask = "+7 (***) ***-**-**",
                maskNumber = '*',
                onPhoneChanged = { numberTextState.value = it },
            )

            TextField(
                modifier = Modifier
                    .border(width = 0.dp, color = Color.White)
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                value = emailTextState.value,
                onValueChange = { it ->
                    if (it.isNotEmpty()) {
                        emailErrorState.value = false
                    }

                    emailTextState.value = it

                    emailErrorState.value = !Patterns.EMAIL_ADDRESS
                        .matcher(emailTextState.value)
                        .matches()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                isError = emailErrorState.value,
                placeholder = {
                    Text(
                        "examplemail.000@mail.ru",
                        color = Color(0xFF14142B),
                        fontSize = 16.sp,
                    )
                },
                label = {
                    Text(text = "Почта", color = Color(0xFFA9ABB7), fontSize = 17.sp)
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF6F6F9),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = colorResource(id = R.color.error_red),
                ),
                shape = RoundedCornerShape(size = 10.dp),
            )

            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Эти данные никому не передаются. После оплаты мы\nвышли чек на указанный вами номер и почту",
                color = colorResource(
                    id = R.color.grey_200,
                ),
                fontSize = 14.sp,
                style = TextStyle(lineHeight = 16.8.sp),
            )
        }
    }
}
