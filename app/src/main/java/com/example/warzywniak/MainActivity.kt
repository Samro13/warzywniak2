package com.example.warzywniak

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.warzywniak.ui.theme.WarzywniakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WarzywniakTheme {
                val viewModel: TargViewModel = viewModel()
                val items = viewModel.items.collectAsStateWithLifecycle()
                val drinks = viewModel.drinks.collectAsStateWithLifecycle()
                // A surface container using the 'background' color from the theme
                LaunchedEffect(Unit) {
                    viewModel.cos()
                    viewModel.getDrinksBy("")
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    sklep(list = drinks.value)
                }
            }
        }
    }
}
@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun sklep(list: SnapshotStateList<Drink>) {
    val klikanie = remember {
        mutableStateOf<Boolean>(false)
    }
    val opis = remember {
        mutableStateOf<Drink?>(null)
    }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn {
            items(list) { item ->
                ElevatedCard(
                    modifier = Modifier
                        .padding(20.dp),
                    colors = CardDefaults.elevatedCardColors(containerColor = Color(0xFFF5FF65)),
                    onClick = {

                        klikanie.value = true
                        opis.value = item

                    },
                    shape = RoundedCornerShape(10.dp),


                    ) {
                    Column() {
                        Text(
                            text = "${item.strDrink}",
                            fontSize = 20.sp,
                            color = Color.Black
                        )

                        Text(
                            text = "${item.strCategory.substringBefore(delimiter = ".")}",
                            fontSize = 15.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxSize()
                        )


                    }

                }
            }
        }
        AnimatedVisibility(
            visible = klikanie.value && opis.value != null,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Surface(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                )
                {

                    BackHandler { klikanie.value = false }
                    Text(
                        text = "${opis.value?.strDrink ?: ""}",
                        fontSize = 20.sp
                    )
                    Text(
                        text = "${opis.value?.strCategory ?: ""}"
                    )
                    Text(
                        text = "${opis.value?.idDrink ?: ""}"
                    )

                    IconButton(onClick = { klikanie.value = false }) {

                        Icon(
                            contentDescription = "cos",
                            imageVector = Icons.Filled.ArrowBack
                        )
                    }
                }
            }
        }

    }
}


