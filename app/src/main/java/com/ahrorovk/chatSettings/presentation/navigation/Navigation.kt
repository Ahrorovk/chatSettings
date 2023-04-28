package com.ahrorovk.chatSettings.presentation.navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ahrorovk.chatSettings.Screens
import com.ahrorovk.chatSettings.presentation.ChooseWallpaperScreen.ChooseWallpaperScreen
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.ChatSettingsEvent
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.ChatSettingsScreen
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.ChatSettingsViewModel
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components.CustomIconButton

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<ChatSettingsViewModel>()
    val state =viewModel.state.collectAsState()
    val currentScreen = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    Scaffold(topBar = {
        TopAppBar(
            title = {
                if(currentScreen == Screens.ChooseWallpaperScreen.route)
                    Text(text = "Choose Wallpaper")
                else
                    Text(text = "Settings of chats")
            },
            elevation = 0.dp, backgroundColor = MaterialTheme.colors.background,
            navigationIcon = {
                CustomIconButton(icon = Icons.Filled.ArrowBack) {
                    if(currentScreen == Screens.ChooseWallpaperScreen.route)
                        navController.popBackStack()
                }
            },
            actions = {
                CustomIconButton(icon = Icons.Default.Menu) {
                }
            }
        )
    }) {
        NavHost(
            navController = navController,
            startDestination = Screens.ChatSettingsScreen.route
        ) {
            composable(Screens.ChatSettingsScreen.route) {
                ChatSettingsScreen(state = state.value, onEvent = { event ->
                    when (event) {
                        is ChatSettingsEvent.NavigateToChooseWallpaperScreen->{
                            navController.navigate(Screens.ChooseWallpaperScreen.route)
                        }
                        is ChatSettingsEvent.PopBackStack->{
                            //
                        }
                        else -> {
                            viewModel.onEvent(event)
                        }
                    }
                }
                )
            }
            composable(Screens.ChooseWallpaperScreen.route) {
                ChooseWallpaperScreen(state = state.value, onEvent = { event ->
                    when (event) {
                        is ChatSettingsEvent.PopBackStack->{
                            navController.popBackStack()
                        }
                        else -> {
                            viewModel.onEvent(event)
                        }
                    }
                })
            }
        }
    }
}