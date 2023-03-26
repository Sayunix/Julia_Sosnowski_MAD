package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, movieTitle: String) {

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

    }
}