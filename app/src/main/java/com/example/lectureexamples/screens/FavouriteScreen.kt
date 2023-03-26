package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.getMovies

@Composable
fun FavoriteScreenAppBar(text: String, navController: NavController) {
    var showMenu by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        IconButton(onClick = {
            navController.navigateUp()
        }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "backButton"
            )
        }
        Text(text = text, color = MaterialTheme.colors.onSurface)
        Spacer(Modifier.weight(1f))
        Box() {
            IconButton(onClick = { showMenu = true }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Open Menu")
            }
            DropdownMenuItem(onClick = {
                navController.navigate("favourites") {
                    popUpTo("home") {
                        inclusive = true
                    }
                }
                showMenu = false
            }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Menu Favourites"
                )
                Text(text = "Favourites")
            }
        }
    }
}


@Composable
fun FavouriteScreen(navController: NavController) {

    Column {
        FavoriteScreenAppBar(navController = navController, text = "Favorites")

        val movies = getMovies().take(4)

        LazyColumn {
            itemsIndexed(movies) { index, movie ->
                MovieRow(movie = movie, onItemClick = { movieId ->
                    navController.navigate(route = "detailscreen/$movieId")
                })
                if (index < movies.size - 1) {
                    Divider()
                }
            }
        }
    }
}


