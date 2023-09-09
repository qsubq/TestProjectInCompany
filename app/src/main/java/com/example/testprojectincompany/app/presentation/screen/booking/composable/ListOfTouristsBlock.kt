package com.example.testprojectincompany.app.presentation.screen.booking.composable

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testprojectincompany.R
import com.example.testprojectincompany.app.presentation.screen.booking.TouristModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOfTouristsBlock(listOfTourists: MutableState<MutableList<TouristModel>>) {
    // Мапа для порядковых числительных
    val positionMap: Map<Int, String> = mapOf(
        Pair(0, "Первый"),
        Pair(1, "Второй"),
        Pair(2, "Третий"),
        Pair(3, "Четвертый"),
        Pair(4, "Пятый"),
        Pair(5, "Шестой"),
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        for (i in listOfTourists.value) {
            val isCollapsedState = remember { mutableStateOf(false) }

            Card(
                modifier = Modifier.padding(top = 8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 13.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 13.dp,
                        ),
                ) {
                    positionMap.get(i.position)?.let {
                        Text(
                            text = stringResource(id = R.string.tourists_number, it),
                            fontSize = 22.sp,
                            color = Color.Black,
                            style = TextStyle(lineHeight = 26.4.sp),
                            fontWeight = FontWeight.Medium,
                        )
                    }
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(top = 3.dp)
                            .clickable {
                                isCollapsedState.value = !isCollapsedState.value
                            },
                        imageVector = if (isCollapsedState.value) {
                            ImageVector.vectorResource(id = R.drawable.arrow_to_the_downsvg)
                        } else {
                            ImageVector.vectorResource(id = R.drawable.arrow_to_the_up)
                        },
                        contentDescription = null,
                    )
                }

                if (!isCollapsedState.value) {
                    TextField(
                        modifier = Modifier
                            .border(width = 0.dp, color = Color.White)
                            .padding(top = 3.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        value = i.name.value,
                        onValueChange = {
                            i.name.value = it
                            i.nameError.value = it.isEmpty()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        ),
                        label = {
                            Text(
                                text = "Имя",
                                color = Color(0xFFA9ABB7),
                                fontSize = 17.sp,
                            )
                        },
                        isError = i.nameError.value,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF6F6F9),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = colorResource(id = R.color.error_red),
                        ),
                        shape = RoundedCornerShape(size = 10.dp),
                    )

                    TextField(
                        modifier = Modifier
                            .border(width = 0.dp, color = Color.White)
                            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        value = i.secondName.value,
                        onValueChange = {
                            i.secondName.value = it
                            i.secondNameError.value = it.isEmpty()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        ),
                        label = {
                            Text(
                                text = "Фамилия",
                                color = Color(0xFFA9ABB7),
                                fontSize = 17.sp,
                            )
                        },
                        isError = i.secondNameError.value,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF6F6F9),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = colorResource(id = R.color.error_red),
                        ),
                        shape = RoundedCornerShape(size = 10.dp),
                    )
                    TextField(
                        modifier = Modifier
                            .border(width = 0.dp, color = Color.White)
                            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        value = i.date.value,
                        onValueChange = {
                            i.date.value = it
                            i.dateError.value = it.isEmpty()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        ),
                        label = {
                            Text(
                                text = "Дата рождения",
                                color = Color(0xFFA9ABB7),
                                fontSize = 17.sp,
                            )
                        },
                        isError = i.dateError.value,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF6F6F9),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = colorResource(id = R.color.error_red),
                        ),
                        shape = RoundedCornerShape(size = 10.dp),
                    )
                    TextField(
                        modifier = Modifier
                            .border(width = 0.dp, color = Color.White)
                            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        value = i.citizenship.value,
                        onValueChange = {
                            i.citizenship.value = it
                            i.citizenshipError.value = it.isEmpty()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        ),
                        label = {
                            Text(
                                text = "Гражданство",
                                color = Color(0xFFA9ABB7),
                                fontSize = 17.sp,
                            )
                        },
                        isError = i.citizenshipError.value,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF6F6F9),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = colorResource(id = R.color.error_red),
                        ),
                        shape = RoundedCornerShape(size = 10.dp),
                    )
                    TextField(
                        modifier = Modifier
                            .border(width = 0.dp, color = Color.White)
                            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        value = i.passNum.value,
                        onValueChange = {
                            i.passNum.value = it
                            i.pussNumError.value = it.isEmpty()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        ),
                        label = {
                            Text(
                                text = "Номер загранпаспорта",
                                color = Color(0xFFA9ABB7),
                                fontSize = 17.sp,
                            )
                        },
                        isError = i.pussNumError.value,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF6F6F9),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = colorResource(id = R.color.error_red),
                        ),
                        shape = RoundedCornerShape(size = 10.dp),
                    )
                    TextField(
                        modifier = Modifier
                            .border(width = 0.dp, color = Color.White)
                            .padding(
                                top = 8.dp,
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 16.dp,
                            )
                            .fillMaxWidth(),
                        value = i.passPeriod.value,
                        onValueChange = {
                            i.passPeriod.value = it
                            i.passPeriodError.value = it.isEmpty()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        ),
                        label = {
                            Text(
                                text = "Срок действия загранпаспорта",
                                color = Color(0xFFA9ABB7),
                                fontSize = 17.sp,
                            )
                        },
                        isError = i.passPeriodError.value,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF6F6F9),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = colorResource(id = R.color.error_red),
                        ),
                        shape = RoundedCornerShape(size = 10.dp),
                    )
                }
            }
        }

        Card(
            modifier = Modifier.padding(top = 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 13.dp, start = 16.dp, end = 16.dp, bottom = 13.dp),
            ) {
                Text(
                    text = "Добавить туриста",
                    fontSize = 22.sp,
                    color = Color.Black,
                    style = TextStyle(lineHeight = 26.4.sp),
                    fontWeight = FontWeight.Medium,
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable {
                            val newList = listOfTourists.value.toMutableList()

                            newList.add(
                                TouristModel(
                                    position = listOfTourists.value.size,
                                ),
                            )

                            listOfTourists.value = newList
                            Log.e("Booking", "size list: ${listOfTourists.value.size}")
                        },
                    imageVector = ImageVector.vectorResource(id = R.drawable.plus_btn_icon),
                    contentDescription = null,
                )
            }
        }
    }
}
