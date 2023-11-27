package com.example.warzywniak

import androidx.compose.runtime.MutableState
import kotlinx.serialization.Serializable

@Serializable
data class Drink(
    val idDrink: String,
    val strDrink: String,
    val strTags: String?,
    val strCategory: String,
    val strInstructions: String?,
    val strGlass: String?,
)

@Serializable
data class Drinks(
    val drinks: List<Drink>
)