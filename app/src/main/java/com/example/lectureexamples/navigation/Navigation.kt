package com.example.lectureexamples.navigation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.HomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomeScreen(navController)
        }

        composable(
            route = "detail/{movieTitle}",
            arguments = listOf(navArgument("movieTitle"){
                type = NavType.StringType })
        ) {
            Log.d("args", it.arguments?.getString("movieTitle").toString())
            DetailScreen(navController = navController, movieTitle = it.arguments?.getString("movieTitle").toString()) }
    }
}
