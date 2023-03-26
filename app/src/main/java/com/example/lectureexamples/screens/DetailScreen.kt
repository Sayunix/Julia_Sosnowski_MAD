package com.example.lectureexamples.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.navigation.Screen


fun getMovieDetails(movieId: String?): Movie {
    val movies = getMovies()
    var selectedMovie: Movie = movies[0]

    for (movie in movies) {
        if (movie.id == movieId) {
            selectedMovie = movie;
        }
    }
    return selectedMovie
}

@Composable
fun DetailScreen(navController: NavController, movieTitle: String, movieId: String) {
    val selectedMovie = getMovieDetails(movieTitle)

    var showMenu by remember { mutableStateOf(false) } // remember state variable to toggle the DropDownMenu

    Column {
        TopAppBar(
            title = { Text(text = "$movieTitle") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = { showMenu = true }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = null)
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ) {
                    DropdownMenuItem(onClick = {
                        navController.navigate(Screen.Detail(movieTitle, movieId).route) {
                            popUpTo("home") {
                                inclusive = true
                            }
                        }
                        showMenu = false
                    }) {
                        Text("Favorites")
                    }
                }
            }
        )
        MovieRow(movie = selectedMovie)

        ImageList(selectedMovie.images)
    }
}


@Composable
fun ImageList(images: List<String>) {
    Column(Modifier.padding(top = 8.dp)) {
        Text(
            text = "Movie Images",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            images.forEach { url ->
                item {
                    Card(
                        modifier = Modifier.size(180.dp, 270.dp),
                        shape = MaterialTheme.shapes.small.copy(CornerSize(8.dp)),
                        elevation = 4.dp
                    ) {
                        AsyncImage(
                            model = url,
                            contentDescription = "Movie Poster",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
