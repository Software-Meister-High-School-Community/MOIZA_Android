package com.moizaandroid.moiza.ui.login

import android.content.Intent
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
import com.moizaandroid.moiza.ui.register.SignUpActivity
import com.moizaandroid.moiza.utils.NavGroup

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInScreen(
                onFinish = { finish() },
                onSignUpClick = { startActivity(Intent(this, SignUpActivity::class.java)) }
            )
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun SignInScreen(onFinish: () -> Unit, onSignUpClick: () -> Unit) {
        val navController: NavHostController = rememberAnimatedNavController()
        AnimatedNavHost(
            navController = navController,
            startDestination = NavGroup.SignInStep.title
        ) {
            authenticationGraph(
                navController = navController,
                onFinish = onFinish,
                onSignUpClick = onSignUpClick
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.authenticationGraph(
    navController: NavController,
    onFinish: () -> Unit,
    onSignUpClick: () -> Unit
) {
    val animationOffset = 1500
    val durationMillis = 250

    navigation(
        startDestination = NavGroup.SignInStep.SIGN_IN,
        route = NavGroup.SignInStep.title
    ) {
        composable(route = NavGroup.SignInStep.SIGN_IN, enterTransition = null) {
            SignInScreen(
                onBackButtonClick = { onFinish() },
                onLoginButtonClick = { /*TODO*/ },
                onSignUpClick = { onSignUpClick() },
                onFindIdClick = { navController.navigate(route = NavGroup.SignInStep.FIND_USER_ID_INPUT_EMAIL) },
                onFindPasswordClick = { }
            )
        }
        composable(
            route = NavGroup.SignInStep.FIND_USER_ID_INPUT_EMAIL,
            enterTransition = null
        ) {
            FindUserIdEmailScreen(
                toPrevious = onFinish,
                toNextStep = { navController.navigate(route = NavGroup.SignInStep.FIND_USER_ID_VERIFICATION_CODE) }
            )
        }
        composable(route = NavGroup.SignInStep.FIND_USER_ID_VERIFICATION_CODE, enterTransition = {
            if (this.initialState.destination.route.equals(NavGroup.SignInStep.FIND_USER_ID_INPUT_EMAIL)) slideInHorizontally(
                initialOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
            else slideInHorizontally(
                initialOffsetX = { -animationOffset },
                animationSpec = tween(durationMillis)
            )

        }, exitTransition = {
            if (this.targetState.destination.route.equals(NavGroup.SignInStep.FIND_USER_ID_CHECK_USER_ID))
                slideOutHorizontally(
                    targetOffsetX = { -animationOffset },
                    animationSpec = tween(durationMillis)
                )
            else slideOutHorizontally(
                targetOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
        }) {
            FindUserIdVerificationCode(
                toPrevious = { navController.popBackStack() },
                toNextStep = { navController.navigate(route = NavGroup.SignInStep.FIND_USER_ID_CHECK_USER_ID) }
            )
        }

        composable(route = NavGroup.SignInStep.FIND_USER_ID_CHECK_USER_ID, exitTransition = {
            if (this.targetState.destination.route.equals(NavGroup.SignInStep.FIND_USER_ID_CHECK_USER_ID))
                slideOutHorizontally(
                    targetOffsetX = { -animationOffset },
                    animationSpec = tween(durationMillis)
                )
            else slideOutHorizontally(
                targetOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
        }) {
            FindUserIdCheck(
                toPrevious = { navController.popBackStack() },
                toFindPassword = { },
                toSignIn = { navController.navigate(route = NavGroup.SignInStep.SIGN_IN) }
            )

        }
    }
}