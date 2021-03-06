package com.moizaandroid.moiza.ui.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.moizaandroid.moiza.utils.NavDestination

class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpScreen(onFinish = { finish() })
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun SignUpScreen(onFinish: () -> Unit) {
        val navController: NavHostController = rememberAnimatedNavController()
        AnimatedNavHost(
            navController = navController,
            startDestination = NavDestination.SignUpStep.title
        ) {
            authenticationGraph(navController = navController, onFinish = onFinish)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.authenticationGraph(navController: NavController, onFinish: () -> Unit) {
    val animationOffset = 1500
    val durationMillis = 150

    navigation(
        startDestination = NavDestination.SignUpStep.AGREED,
        route = NavDestination.SignUpStep.title
    ) {
        composable(route = NavDestination.SignUpStep.AGREED, enterTransition = null) {
            SignUpAgreedScreen(
                toPrevious = onFinish,
                toNextStep = { navController.navigate(route = NavDestination.SignUpStep.INPUT_STUDENT_INFO) }
            )
        }
        composable(route = NavDestination.SignUpStep.INPUT_STUDENT_INFO, enterTransition = {
            if (this.initialState.destination.route.equals(NavDestination.SignUpStep.AGREED)) slideInHorizontally(
                initialOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
            else slideInHorizontally(initialOffsetX = { -animationOffset }, animationSpec = tween(durationMillis))

        }, exitTransition = {
            if (this.targetState.destination.route.equals(NavDestination.SignUpStep.SET_SIGN_IN))
                slideOutHorizontally(targetOffsetX = { -animationOffset }, animationSpec = tween(durationMillis))
            else slideOutHorizontally(targetOffsetX = { animationOffset }, animationSpec = tween(durationMillis))
        }) {
            SignUpInputStudentScreen(
                toPrevious = { navController.popBackStack() },
                toNextStep = { navController.navigate(route = NavDestination.SignUpStep.SET_SIGN_IN) }
            )
        }

        composable(route = NavDestination.SignUpStep.SET_SIGN_IN, exitTransition = {
            if (this.targetState.destination.route.equals(NavDestination.SignUpStep.INPUT_STUDENT_INFO))
                slideOutHorizontally(targetOffsetX = { -animationOffset }, animationSpec = tween(durationMillis))
            else slideOutHorizontally(targetOffsetX = { animationOffset }, animationSpec = tween(durationMillis))
        }) {
            SignUpSignInSettings(
                toPrevious = { navController.popBackStack() },
                finishSignUp = onFinish
            )

        }
    }
}