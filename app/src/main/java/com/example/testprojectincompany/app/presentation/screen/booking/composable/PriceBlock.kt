package com.example.testprojectincompany.app.presentation.screen.booking.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testprojectincompany.R

@Composable
fun PriceBlock(
    tourTextState: String,
    gasTextState: String,
    serviceTextState: String,
    finalPriceTextState: String,
) {
    Card(
        modifier = Modifier.padding(top = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = "Тур",
                    color = colorResource(id = R.color.grey_200),
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(400),
                    ),
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(132.dp),
                    text = tourTextState,
                    color = Color.Black,
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(400),
                    ),
                    textAlign = TextAlign.End,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = "Топливный сбор",
                    color = colorResource(id = R.color.grey_200),
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(400),
                    ),
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(132.dp),
                    text = gasTextState,
                    color = Color.Black,
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(400),
                    ),
                    textAlign = TextAlign.End,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = "Сервисный сбор",
                    color = colorResource(id = R.color.grey_200),
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(400),
                    ),
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(132.dp),
                    text = serviceTextState,
                    color = Color.Black,
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(400),
                    ),
                    textAlign = TextAlign.End,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp,
                    ),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = "К оплате",
                    color = colorResource(id = R.color.grey_200),
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(400),
                    ),
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(132.dp),
                    text = finalPriceTextState,
                    color = Color(0xFF0D72FF),
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(600),
                    ),
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}
