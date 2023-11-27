package com.example.warzywniak

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.ktor.http.parameters

@Composable
fun ScreenNavigator() {
    val navController = rememberNavController()

    navController.navigate("detale/12345}")
    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {
        composable("lista") {
            // LIsta(navController)
        }
        composable(
            route = "detale/{id}",
            arguments = listOf(
               navArgument("id") {
                   type = NavType.StringType
                   defaultValue = ""
               }
            )
        ) { entry ->
            val id = entry.arguments?.getString("id")
            // Detale(id)
        }
    }
}