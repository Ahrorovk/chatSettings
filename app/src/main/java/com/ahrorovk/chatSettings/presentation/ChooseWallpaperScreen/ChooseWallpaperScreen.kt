package com.ahrorovk.chatSettings.presentation.ChooseWallpaperScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ahrorovk.chatSettings.presentation.ChooseWallpaperScreen.components.WallpaperItem
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.ChatSettingsEvent
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.ChatSettingsState

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseWallpaperScreen(
    state:ChatSettingsState,
    onEvent:(ChatSettingsEvent)->Unit
) {

    fun mp(i:Int,color:Color):Map<Int,Color> {
        return mapOf<Int,Color>(pair = Pair(i,color))
    }
    val list = listOf(mp(0, MaterialTheme.colors.onBackground),mp(1,MaterialTheme.colors.background),mp(2,Color.Red),mp(3,Color.Green),mp(4,Color.Yellow),mp(5,Color.Blue),mp(6,Color.Magenta))
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        content = {
            itemsIndexed(list) { index, i ->
                WallpaperItem(color = i[index]!!, isSelected = (index == state.stateOfColorIndex)) {
                    onEvent(ChatSettingsEvent.OnStateOfColorIndexChange(index))
                }
            }
        }
    )
    Box(modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Button(onClick = {
            onEvent(ChatSettingsEvent.OnStateOfColorChange(list[state.stateOfColorIndex][state.stateOfColorIndex]!!))
            onEvent(ChatSettingsEvent.PopBackStack)
        }) {
            Text(text = "Save")
        }
    }
}