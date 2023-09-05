package com.example.testprojectincompany.app.presentation.screen.booking

import androidx.compose.runtime.MutableState

data class TouristModel(
    val name: MutableState<String>,
    val secondName: MutableState<String>,
    val date: MutableState<String>,
    val citizenship: MutableState<String>,
    val passNum: MutableState<String>,
    val passPeriod: MutableState<String>,
)
