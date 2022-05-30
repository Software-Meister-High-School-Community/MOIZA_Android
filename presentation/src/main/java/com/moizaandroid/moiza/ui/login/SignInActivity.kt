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
import com.moizaandroid.moiza.ui.main.MainActivity
import com.moizaandroid.moiza.ui.register.SignUpActivity
import com.moizaandroid.moiza.utils.NavDestination

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInScreen(
                onFinish = { finish() },
                onSignUpClick = { startActivity(Intent(this, SignUpActivity::class.java)) },
                doSignIn = { startActivity(Intent(this, MainActivity::class.java)) }
            )
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun SignInScreen(onFinish: () -> Unit, onSignUpClick: () -> Unit, doSignIn: () -> Unit) {
        val navController: NavHostController = rememberAnimatedNavController()
        AnimatedNavHost(
            navController = navController,
            startDestination = NavDestination.SignInStep.title
        ) {
            authenticationGraph(
                navController = navController,
                onFinish = onFinish,
                onSignUpClick = onSignUpClick,
                doSignIn = doSignIn
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.authenticationGraph(
    navController: NavController,
    onFinish: () -> Unit,
    onSignUpClick: () -> Unit,
    doSignIn: () -> Unit
) {
    val animationOffset = 1500
    val durationMillis = 250

    navigation(
        startDestination = NavDestination.SignInStep.SIGN_IN,
        route = NavDestination.SignInStep.title
    ) {
        composable(route = NavDestination.SignInStep.SIGN_IN, enterTransition = null) {
            SignInScreen(
                toPrevious = { onFinish() },
                doSignIn = doSignIn,
                toSignUp = { onSignUpClick() },
                toFindId = { navController.navigate(route = NavDestination.SignInStep.FIND_USER_ID_INPUT_EMAIL) },
                toFindPassword = { navController.navigate(route = NavDestination.SignInStep.FIND_PASSWORD_INPUT_ID) }
            )
        }

        composable(
            route = NavDestination.SignInStep.FIND_USER_ID_INPUT_EMAIL,
            enterTransition = null
        ) {
            FindUserIdEmailScreen(
                toPrevious = onFinish,
                toNextStep = { navController.navigate(route = NavDestination.SignInStep.FIND_USER_ID_VERIFICATION_CODE) }
            )
        }

        composable(route = NavDestination.SignInStep.FIND_USER_ID_VERIFICATION_CODE, enterTransition = {
            if (this.initialState.destination.route.equals(NavDestination.SignInStep.FIND_USER_ID_INPUT_EMAIL)) slideInHorizontally(
                initialOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
            else slideInHorizontally(
                initialOffsetX = { -animationOffset },
                animationSpec = tween(durationMillis)
            )

        }, exitTransition = {
            if (this.targetState.destination.route.equals(NavDestination.SignInStep.FIND_USER_ID_CHECK_USER_ID))
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
                toNextStep = { navController.navigate(route = NavDestination.SignInStep.FIND_USER_ID_CHECK_USER_ID) }
            )
        }

        composable(route = NavDestination.SignInStep.FIND_USER_ID_CHECK_USER_ID, exitTransition = {
            if (this.targetState.destination.route.equals(NavDestination.SignInStep.FIND_USER_ID_CHECK_USER_ID))
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
                toSignIn = { navController.navigate(route = NavDestination.SignInStep.SIGN_IN) }
            )

        }

        composable(
            route = NavDestination.SignInStep.FIND_PASSWORD_INPUT_ID,
            enterTransition = null
        ) {
            FindPasswordInputId(
                toPrevious = onFinish,
                toNextStep = { navController.navigate(route = NavDestination.SignInStep.FIND_PASSWORD_VERTIFICATION_CODE) }
            )
        }

        composable(route = NavDestination.SignInStep.FIND_PASSWORD_VERTIFICATION_CODE, enterTransition = {
            if (this.initialState.destination.route.equals(NavDestination.SignInStep.FIND_PASSWORD_INPUT_ID)) slideInHorizontally(
                initialOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
            else slideInHorizontally(
                initialOffsetX = { -animationOffset },
                animationSpec = tween(durationMillis)
            )

        }, exitTransition = {
            if (this.targetState.destination.route.equals(NavDestination.SignInStep.FIND_PASSWORD_RESET_PASSWORD))
                slideOutHorizontally(
                    targetOffsetX = { -animationOffset },
                    animationSpec = tween(durationMillis)
                )
            else slideOutHorizontally(
                targetOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
        }) {
            FindPasswordVerificationCode(
                toPrevious = { navController.popBackStack() },
                toNextStep = { navController.navigate(route = NavDestination.SignInStep.FIND_PASSWORD_RESET_PASSWORD) }
            )
        }

        composable(route = NavDestination.SignInStep.FIND_PASSWORD_RESET_PASSWORD, enterTransition = {
            if (this.initialState.destination.route.equals(NavDestination.SignInStep.FIND_PASSWORD_VERTIFICATION_CODE)) slideInHorizontally(
                initialOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
            else slideInHorizontally(
                initialOffsetX = { -animationOffset },
                animationSpec = tween(durationMillis)
            )

        }, exitTransition = {
            if (this.targetState.destination.route.equals(NavDestination.SignInStep.FIND_PASSWORD_FINISH_RESET))
                slideOutHorizontally(
                    targetOffsetX = { -animationOffset },
                    animationSpec = tween(durationMillis)
                )
            else slideOutHorizontally(
                targetOffsetX = { animationOffset },
                animationSpec = tween(durationMillis)
            )
        }) {
            FindPasswordResetPassword(
                toPrevious = { navController.popBackStack() },
                toNextStep = { navController.navigate(route = NavDestination.SignInStep.FIND_PASSWORD_FINISH_RESET) }
            )
        }

        composable(route = NavDestination.SignInStep.FIND_PASSWORD_FINISH_RESET, enterTransition = {
            if (this.targetState.destination.route.equals(NavDestination.SignInStep.FIND_PASSWORD_RESET_PASSWORD))
                slideInHorizontally(
                    initialOffsetX = { animationOffset },
                    animationSpec = tween(durationMillis)
                )
            else slideInHorizontally(
                initialOffsetX = { -animationOffset },
                animationSpec = tween(durationMillis)
            )
        }) {
            FindPasswordFinishReset(
                toPrevious = { navController.popBackStack() },
                toSignIn = { navController.navigate(route = NavDestination.SignInStep.SIGN_IN) }
            )

        }
    }
}