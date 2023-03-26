package com.example.lectureexamples.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.getMovies

fun getMovieDetails(movieId: String?): Movie{
    val movies = getMovies()
    var selectedMovie:Movie = movies[0]

    for (movie in movies){
        if (movie.id == movieId)
        {
            selectedMovie = movie;
        }
    }
    return selectedMovie
}
@Composable
fun DetailScreen(navController: NavController, movieTitle: String) {

    val selectedMovie = getMovieDetails(movieTitle)

    /*   movieTitle?.let {
        Text(text = "Hello Detailscreen $movieTitle")
    }*/

    var showMenu by remember { mutableStateOf(false) } // remember state variable to toggle the DropDownMenu
    Column {
        TopAppBar(
            title = { Text(text = "$movieTitle") },
            actions = {
                IconButton(onClick = { showMenu = true }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = null)
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ) {
                    DropdownMenuItem(onClick = { /* Handle favorites click */ }) {
                        Text("Favorites")
                    }
                }
            }
        )
        MovieRow(movie=selectedMovie)


    }
}


