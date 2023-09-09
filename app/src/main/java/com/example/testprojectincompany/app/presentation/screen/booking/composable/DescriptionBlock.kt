package com.example.testprojectincompany.app.presentation.screen.booking.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testprojectincompany.R

@Composable
fun DescriptionBlock(
    rateTextState: String,
    nameOfHotelTextState: String,
    addressOfHotelTextState: String,
) {
    Card(
        modifier = Modifier.padding(top = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)) {
            Card(
                modifier = Modifier.padding(top = 16.dp),
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0x33FFC700)),
            ) {
                Row(Modifier.padding(end = 10.dp, top = 5.dp, bottom = 5.dp)) {
                    Image(
                        modifier = Modifier.padding(
                            start = 10.dp,
                        ).align(Alignment.CenterVertically),
                        imageVector = ImageVector.vectorResource(id = R.drawable.rate_icon),
                        contentDescription = null,
                    )
                    Text(
                        modifier = Modifier.padding(start = 2.dp).align(Alignment.CenterVertically),
                        text = rateTextState,
                        color = Color(0xFFFFA800),
                        fontSize = 16.sp,
                        style = TextStyle(
                            lineHeight = 19.2.sp,
                            fontWeight = FontWeight(500),
                        ),
                        textAlign = TextAlign.Center,
                    )
                }
            }

            Text(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(343.dp),
                text = nameOfHotelTextState,
                color = Color.Black,
                fontSize = 22.sp,
                style = TextStyle(
                    lineHeight = 26.4.sp,
                    fontWeight = FontWeight(500),
                ),
                textAlign = TextAlign.Start,
            )

            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = addressOfHotelTextState,
                color = Color(0xFF0D72FF),
                fontSize = 14.sp,
                style = TextStyle(
                    lineHeight = 26.4.sp,
                    fontWeight = FontWeight(500),
                ),
                textAlign = TextAlign.Center,
            )
        }

    }
}
