package com.example.testprojectincompany.app.presentation.screen.booking

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class TouristModel(
    val position: Int,
    val name: MutableState<String> = mutableStateOf(""),
    val secondName: MutableState<String> = mutableStateOf(""),
    val date: MutableState<String> = mutableStateOf(""),
    val citizenship: MutableState<String> = mutableStateOf(""),
    val passNum: MutableState<String> = mutableStateOf(""),
    val passPeriod: MutableState<String> = mutableStateOf(""),
    val nameError: MutableState<Boolean> = mutableStateOf(false),
    val secondNameError: MutableState<Boolean> = mutableStateOf(false),
    val dateError: MutableState<Boolean> = mutableStateOf(false),
    val citizenshipError: MutableState<Boolean> = mutableStateOf(false),
    val pussNumError: MutableState<Boolean> = mutableStateOf(false),
    val passPeriodError: MutableState<Boolean> = mutableStateOf(false),
)
