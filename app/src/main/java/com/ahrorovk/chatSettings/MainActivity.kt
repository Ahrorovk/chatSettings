package com.ahrorovk.chatSettings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.ChatSettingsScreen
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.ChatSettingsViewModel
import com.ahrorovk.chatSettings.presentation.navigation.Navigation
import com.ahrorovk.chatSettings.ui.theme.ChatSettingsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatSettingsTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChatSettingsTheme {
        Greeting("Android")
    }
}