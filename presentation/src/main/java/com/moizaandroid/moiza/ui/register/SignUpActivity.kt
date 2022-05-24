package com.moizaandroid.moiza.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class SignUpActivity : AppCompatActivity() {

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
            startDestination = NavGroup.SignUpStep.title
        ) {
            authenticationGraph(navController = navController, onFinish = onFinish)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.authenticationGraph(navController: NavController, onFinish: () -> Unit) {
    navigation(
        startDestination = NavGroup.SignUpStep.AGREED,
        route = NavGroup.SignUpStep.title
    ) {
        composable(route = NavGroup.SignUpStep.AGREED, enterTransition = null) {
            SignUpAgreedScreen(
                toPrevious = onFinish,
                toNextStep = { navController.navigate(route = NavGroup.SignUpStep.INPUT_STUDENT_INFO) }
            )
        }
        composable(route = NavGroup.SignUpStep.INPUT_STUDENT_INFO, enterTransition = {
            if (this.initialState.destination.route.equals(NavGroup.SignUpStep.AGREED)) slideInHorizontally(
                initialOffsetX = { 1500 },
                animationSpec = tween(250)
            )
            else slideInHorizontally(initialOffsetX = { -1500 }, animationSpec = tween(250))

        }, exitTransition = {
            if (this.targetState.destination.route.equals(NavGroup.SignUpStep.SET_SIGN_IN))
                slideOutHorizontally(targetOffsetX = { -1500 }, animationSpec = tween(250))
            else slideOutHorizontally(targetOffsetX = { 1500 }, animationSpec = tween(250))
        }) {
            SignUpInputStudentScreen(
                toPrevious = { navController.popBackStack() },
                toNextStep = { navController.navigate(route = NavGroup.SignUpStep.SET_SIGN_IN) }
            )
        }

        composable(route = NavGroup.SignUpStep.SET_SIGN_IN, exitTransition = {
            if (this.targetState.destination.route.equals(NavGroup.SignUpStep.INPUT_STUDENT_INFO))
                slideOutHorizontally(targetOffsetX = { -1500 }, animationSpec = tween(250))
            else slideOutHorizontally(targetOffsetX = { 1500 }, animationSpec = tween(250))
        }) {
            SignUpSetSign(
                isBackBtnClick = { navController.popBackStack() }
            )

        }
    }
}