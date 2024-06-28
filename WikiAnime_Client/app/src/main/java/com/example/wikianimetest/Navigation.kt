package com.example.wikianimetest

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wikianimetest.model.Recommandation
import com.example.wikianimetest.screen.AnimeDetailScreen
import com.example.wikianimetest.screen.HomePage
import com.example.wikianimetest.screen.HomeScreen
import com.example.wikianimetest.viewmodel.AnimeViewModel

sealed class Routes(val route: String) {

    // Route 1
    data object HomePage : Routes("HomePage")
    //Route 2
    data object PagePrincipal : Routes("PagePrincipal")

    //Route 3 avec paramètre
    data object AnimeDetailScreen : Routes("AnimeDetailScreen/{id}") {
        //Méthode(s) qui vienne(nt) remplit le ou les paramètres
        fun withId(id: Int) = "AnimeDetailScreen/$id"

        fun withObject(data: Recommandation) = "AnimeDetailScreen/${data.id}"
    }



}

@Composable
fun AppNavigation() {
    val navHostController: NavHostController = rememberNavController()
    val animeViewModel: AnimeViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = Routes.HomePage.route) {
        composable(Routes.HomePage.route) {
            HomePage(navHostController)
        }

        composable(Routes.PagePrincipal.route) {
            HomeScreen(navHostController, animeViewModel = animeViewModel)
        }

        composable(
            route = Routes.AnimeDetailScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val idNav = it.arguments?.getInt("id") ?: 10
            AnimeDetailScreen(id = idNav, navHostController, animeViewModel = animeViewModel)
        }
    }
}


