package com.appturismo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appturismo.ui.theme.AppTurismoTheme
import com.appturismo.ui.views.FindPackageView
import com.appturismo.ui.views.Home
import com.appturismo.ui.views.ShowFavouritesView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTurismoTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Routes.Home.route) {
                    composable(Routes.Home.route) {
                        Home(
                            goToFindPackageView = { navController.navigate(Routes.FindPackage.route) },
                            goToShowFavouritesView = { navController.navigate(Routes.ShowFavourites.route) }
                        )
                    }
                    composable(Routes.FindPackage.route) {
                        FindPackageView(
                            goToMenu = { navController.navigate(Routes.Home.route) }
                        )
                    }
                    composable(Routes.ShowFavourites.route) {
                        ShowFavouritesView(
                            goToMenu = { navController.navigate(Routes.Home.route) }
                        )
                    }
                }
            }
        }
    }
}

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object FindPackage : Routes("find_package")
    data object ShowFavourites : Routes("show_favourites")
}