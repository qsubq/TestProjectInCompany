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
fun DetailsDescriptionBlock(
    flightFromTextState: String,
    cityTextState: String,
    datesTextState: String,
    nightsTextState: String,
    roomTextState: String,
    nutritionTextState: String,
    nameOfHotelTextState: String,
) {
    Card(
        modifier = Modifier.padding(top = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.TopStart),
                    text = "Вылет из",
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
                        .width(203.dp),
                    text = flightFromTextState,
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
                    .padding(end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.TopStart),
                    text = "Страна, город",
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
                        .width(203.dp),
                    text = cityTextState,
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
                    .padding(end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.TopStart),
                    text = "Даты",
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
                        .width(203.dp),
                    text = datesTextState,
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
                    .padding(end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.TopStart),
                    text = "Кол-во ночей",
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
                        .width(203.dp),
                    text = nightsTextState,
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
                    .padding(end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.TopStart),
                    text = "Отель",
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
                        .width(203.dp),
                    text = nameOfHotelTextState,
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
                    .padding(end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.TopStart),
                    text = "Номер",
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
                        .width(203.dp),
                    text = roomTextState,
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
                    .padding(end = 16.dp, top = 16.dp),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.TopStart),
                    text = "Питание",
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
                        .width(203.dp),
                    text = nutritionTextState,
                    color = Color.Black,
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 19.2.sp,
                        fontWeight = FontWeight(400),
                    ),
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}
