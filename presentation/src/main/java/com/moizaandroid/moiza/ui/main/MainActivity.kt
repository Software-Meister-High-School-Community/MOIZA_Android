package com.moizaandroid.moiza.ui.main


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.moiza_design.icon.MoizaIcons
import com.moiza_design.theme.Blue
import com.moiza_design.theme.Gray500
import com.moizaandroid.moiza.ui.board.BoardScreen
import com.moizaandroid.moiza.ui.home.HomeScreen
import com.moizaandroid.moiza.ui.notification.NotificationScreen
import com.moizaandroid.moiza.ui.profile.ProfileScreen
import com.moizaandroid.moiza.utils.NavDestination
import com.moizaandroid.moiza.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        itemList = listOf(
                            BottomNavItem(
                                route = NavDestination.BottomNav.HOME,
                                icon = MoizaIcons.home
                            ),
                            BottomNavItem(
                                route = NavDestination.BottomNav.BOARD,
                                icon = MoizaIcons.board
                            ),
                            BottomNavItem(
                                route = NavDestination.BottomNav.NOTIFICATION,
                                icon = MoizaIcons.notification
                            ),
                            BottomNavItem(
                                route = NavDestination.BottomNav.PROFILE,
                                icon = MoizaIcons.profile
                            )
                        ),
                        modifier = Modifier,
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        })
                }
            ) {
                Navigation(navController = navController)
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavDestination.BottomNav.HOME) {
        composable(route = NavDestination.BottomNav.HOME) {
            HomeScreen()
        }
        composable(route = NavDestination.BottomNav.BOARD) {
            BoardScreen()
        }
        composable(route = NavDestination.BottomNav.NOTIFICATION) {
            NotificationScreen()
        }
        composable(route = NavDestination.BottomNav.PROFILE) {
            ProfileScreen()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationBar(
    itemList: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White
    ) {
        itemList.forEach{ item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Blue,
                unselectedContentColor = Gray500,
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.route,
                        modifier = Modifier.height(20.dp)
                    )
                }
            )
        }
    }
}
