package com.example.warzywniak

import kotlinx.serialization.Serializable

@Serializable
data class Food(
    val food: List<FoodX>
)

