package com.example.basket.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.auth.login.LoginScreen
import com.example.auth.signup.SignUpScreen
import com.example.cart.presentation.CartScreen
import com.example.cart.presentation.CartTopBar
import com.example.core.ui.icons.HomeFill
import com.example.core.ui.icons.HomeOut

import com.example.details.presentation.DetailsScreen
import com.example.explore.presentation.ExploreScreen
import com.example.home.presentation.CategoryScreen
import com.example.home.presentation.HomeScreen
import com.example.home.presentation.HomeTopBar
import com.example.profile.presentation.ProfileScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val scrollBehaviour = TopAppBarDefaults.pinnedScrollBehavior()
    val items  = listOf(
        BottomBarItem(
            title = "Home",
            selectedIcon = HomeFill,
            unselectedIcon = HomeOut,
            route = "home"
        ),
        BottomBarItem(
            title = "Explore",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            route = "explore"
        ),
        BottomBarItem(
            title = "Cart",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            route = "cart"
        ),
        BottomBarItem(
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = "profile"
        )
    )
    val showBottomBar = currentRoute in listOf(
        "home",
        "explore",
        "cart",
        "details",
        "profile"
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehaviour.nestedScrollConnection),

        topBar = {
            when(currentRoute){
                "home" -> HomeTopBar(scrollBehaviour,navController, viewModel())
                "cart" -> CartTopBar(scrollBehaviour)
                else -> Unit
            }
        },
        bottomBar = {
            if (showBottomBar){
            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 0.dp
            ) {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route)
                        },
                        label = {
                            Text(item.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (currentRoute == item.route) {
                                    item.selectedIcon
                                } else {
                                    item.unselectedIcon
                                }, contentDescription = item.title
                            )
                        }
                    )

                }
            }
            }
        }
    ) { innerPadding->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login"){
                LoginScreen(navController = navController)
            }
            composable("signup"){
                SignUpScreen(navController = navController)
            }
            composable("profile"){
                ProfileScreen(navController = navController)
            }
            composable("home"){
                HomeScreen(navController = navController)
            }
            composable("explore"){
                ExploreScreen(navController = navController)
            }
            composable("cart"){
                CartScreen(navController = navController)
            }
            composable(
                route = "details/{id}",
                arguments = listOf(
                    navArgument("id"){
                        type = NavType.IntType
                    }
                )


            ) {
                DetailsScreen(navController = navController)
            }
            composable("category/{category}"){
                CategoryScreen(navController = navController, category = String())
            }
        }


    }

}