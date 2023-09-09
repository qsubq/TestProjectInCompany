package com.example.testprojectincompany.app.presentation.screen.booking.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testprojectincompany.R

@Preview
@Composable
fun ToolBar(navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp, top = 14.dp)
                    .clickable {
                        navController.navigate(R.id.action_bookingFragment_to_roomFragment)
                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.arrow_to_the_leftsvg),
                contentDescription = null,
            )
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 16.dp),
                text = "Бронирование",
                color = Color.Black,
                fontSize = 18.sp,
                style = TextStyle(
                    lineHeight = 21.6.sp,
                    fontWeight = FontWeight(500),
                ),
                textAlign = TextAlign.Center,
            )
        }
    }
}
