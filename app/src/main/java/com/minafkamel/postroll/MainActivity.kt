package com.minafkamel.postroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.minafkamel.postroll.navigation.NavRoutes
import com.minafkamel.postroll.ui.allposts.AllPostsScreen
import com.minafkamel.postroll.ui.details.DetailsScreen
import com.minafkamel.postroll.ui.details.DetailsViewModel
import com.minafkamel.postroll.ui.theme.PostRollTheme
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostRollTheme {
                MainNavigation()
            }
        }
    }
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.AllPosts.route
    ) {
        composable(NavRoutes.AllPosts.route) {
            AllPostsScreen(navController = navController)
        }

        composable(
            NavRoutes.Details.route,
            arguments = listOf(navArgument("postId") { NavType.StringType })
        ) {
            getViewModel<DetailsViewModel>(
                parameters = { parametersOf(it.arguments?.getString("postId")!!) }
            )
            DetailsScreen()
        }
    }
}
