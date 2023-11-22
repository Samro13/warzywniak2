package com.example.warzywniak

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.call.body
import io.ktor.http.isSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class TargViewModel: ViewModel() {
    private val _items = MutableStateFlow(mutableStateListOf<FoodX>())
    private val _drinks = MutableStateFlow(mutableStateListOf<Drink>())

    private val restApi = RestAPI()
    val items = _items.asStateFlow()
    var drinks = _drinks.asStateFlow()

    fun cos(){
        val targ= Json.decodeFromString<Food>(test)
        _items.value=targ.food.toMutableStateList()
    }

    fun getDrinksBy(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = restApi.getDrinksBy(name)
            if (response.status.isSuccess()) {
                val drinks = response.body() as Drinks
                _drinks.value = drinks.drinks.toMutableStateList()
                Log.d("TEST", "$drinks")
            }
        }
    }
}
