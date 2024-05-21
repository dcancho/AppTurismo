package com.appturismo.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.appturismo.ui.theme.AppTurismoTheme
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Home(
    goToFindPackageView: () -> Unit,
    goToShowFavouritesView: () -> Unit
) {
    val navController = rememberNavController()


    AppTurismoTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GlideImage(
                    imageModel = { "https://picsum.photos/1500" },
                    modifier = Modifier.size(250.dp)
                )
                ElevatedButton(onClick = { goToFindPackageView() }) {
                    Text(text = "Find Package", modifier = Modifier.fillMaxWidth())
                }
                ElevatedButton(onClick = { goToShowFavouritesView() }) {
                    Text(text = "Show Favourites", modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}