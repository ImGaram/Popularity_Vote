package com.assignment.popularityvote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.assignment.popularityvote.common.navigation.Screen
import com.assignment.popularityvote.feature.login.LoginScreen
import com.assignment.popularityvote.feature.main.MainScreen
import com.assignment.popularityvote.feature.profile.ProfileScreen
import com.assignment.popularityvote.ui.theme.PopularityVoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PopularityVoteTheme {
                Navigation()
            }
        }
    }

    @Composable
    fun Navigation(modifier: Modifier = Modifier) {
        val navController = rememberNavController()

        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = Screen.LoginScreen
        ) {
            composable<Screen.LoginScreen> {
                LoginScreen(
                    navigateToMain = {
                        navController.navigate(Screen.MainScreen)
                    }
                )
            }

            composable<Screen.MainScreen> {
                MainScreen(
                    navigateToLogin = {
                        navController.popBackStack()
                    },
                    navigateToProfile = {
                        navController.navigate(Screen.ProfileScreen(it))
                    }
                )
            }

            composable<Screen.ProfileScreen> { backStackEntry ->
                ProfileScreen(
                    navigateToMain = {
                        navController.popBackStack()
                    },
                    args = backStackEntry.toRoute<Screen.ProfileScreen>()
                )
            }
        }
    }
}