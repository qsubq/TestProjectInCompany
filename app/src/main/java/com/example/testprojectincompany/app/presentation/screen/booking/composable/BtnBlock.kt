package com.example.testprojectincompany.app.presentation.screen.booking.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testprojectincompany.R
import com.example.testprojectincompany.app.presentation.screen.booking.TouristModel

@Composable
fun ButtonBlock(
    listOfTourists: MutableState<MutableList<TouristModel>>,
    navController: NavController,
    btnMakeOrderTextState: String,
    emailErrorState: MutableState<Boolean>,
    emailTextState: MutableState<String>,
    numberTextState: MutableState<String>,
    numberErrorState: MutableState<Boolean>,
) {
    Card(
        modifier = Modifier.padding(top = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 13.dp, bottom = 13.dp),
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 12.dp,
                        bottom = 20.dp,
                    )
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    for (i in listOfTourists.value) {
                        if (i.name.value.isEmpty()) {
                            i.nameError.value = true
                        }
                        if (i.secondName.value.isEmpty()) {
                            i.secondNameError.value = true
                        }
                        if (i.date.value.isEmpty()) {
                            i.dateError.value = true
                        }
                        if (i.citizenship.value.isEmpty()) {
                            i.citizenshipError.value = true
                        }
                        if (i.passNum.value.isEmpty()) {
                            i.pussNumError.value = true
                        }
                        if (i.passPeriod.value.isEmpty()) {
                            i.passPeriodError.value = true
                        }
                    }

                    if (emailTextState.value.isEmpty() && numberTextState.value.isEmpty()) {
                        if (emailTextState.value.isEmpty()) {
                            emailErrorState.value = true
                        }
                        if (numberTextState.value.isEmpty()) {
                            numberErrorState.value = true
                        }
                    }
                    if (!emailErrorState.value && !numberErrorState.value &&
                        !listOfTourists.value.first().nameError.value &&
                        !listOfTourists.value.first().secondNameError.value &&
                        !listOfTourists.value.first().dateError.value &&
                        !listOfTourists.value.first().citizenshipError.value &&
                        !listOfTourists.value.first().pussNumError.value &&
                        !listOfTourists.value.first().passPeriodError.value &&

                        !listOfTourists.value[1].nameError.value &&
                        !listOfTourists.value[1].secondNameError.value &&
                        !listOfTourists.value[1].dateError.value &&
                        !listOfTourists.value[1].citizenshipError.value &&
                        !listOfTourists.value[1].pussNumError.value &&
                        !listOfTourists.value[1].passPeriodError.value &&

                        !listOfTourists.value.last().nameError.value &&
                        !listOfTourists.value.last().secondNameError.value &&
                        !listOfTourists.value.last().dateError.value &&
                        !listOfTourists.value.last().citizenshipError.value &&
                        !listOfTourists.value.last().pussNumError.value &&
                        !listOfTourists.value.last().passPeriodError.value
                    ) {
                        navController.navigate(R.id.action_bookingFragment_to_orderSuccessFragment)
                    }
                },
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(
                        0xFF0D72FF,
                    ),
                ),
            ) {
                Text(
                    text = btnMakeOrderTextState,
                    color = Color.White,
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 17.6.sp,
                        fontWeight = FontWeight(500),
                    ),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
