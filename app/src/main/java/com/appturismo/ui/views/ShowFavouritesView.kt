package com.appturismo.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.appturismo.ui.theme.AppTurismoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowFavouritesView(
    goToMenu: () -> Unit
){
    AppTurismoTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "My favourite packages") },
                    navigationIcon = {
                        IconButton(onClick = { goToMenu() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    })
            }
        ) {paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ) {

            }
        }
    }
}