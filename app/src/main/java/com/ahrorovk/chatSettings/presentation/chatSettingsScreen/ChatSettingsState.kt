package com.ahrorovk.chatSettings.presentation.chatSettingsScreen

import androidx.compose.ui.graphics.Color
import com.ahrorovk.chatSettings.Constants.StateOfSwipe.ARCHIVE
import com.ahrorovk.chatSettings.Constants.StateOfSwipe.PIN
import com.ahrorovk.chatSettings.Constants.StateOfSwipe.DELETE

data class ChatSettingsState (
    val sizeOfText:Float = 16f,
    val messageCorners:Float = 15f,
    var stateOfChatsList:Boolean = false,
    val swipeLeftValues:List<String> = listOf(DELETE.name,PIN.name,ARCHIVE.name),
    val stateOfSwipeLeftInChatList:String = swipeLeftValues[0],
    val stateOfColor:Color = Color.White,
    val stateOfColorIndex:Int = 0,
)