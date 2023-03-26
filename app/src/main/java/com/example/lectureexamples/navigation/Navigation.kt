package com.example.lectureexamples.navigation

import android.util.Log
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.FavouriteScreen
import com.example.lectureexamples.screens.HomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") { HomeScreen(navController) }
        composable("favourites") { FavouriteScreen(navController) }

        composable(
            route = "detail/{movieTitle}",
            arguments = listOf(navArgument("movieTitle"){
                type = NavType.StringType })
        ) {
            Log.d("args", it.arguments?.getString("movieTitle").toString())
            DetailScreen(
                navController = navController,
                movieTitle = it.arguments?.getString("movieTitle").toString(),
                movieId = it.arguments?.getString("movieId").toString() ) }


    }


}
