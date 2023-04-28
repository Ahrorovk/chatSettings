package com.ahrorovk.chatSettings.presentation.chatSettingsScreen

import androidx.compose.ui.graphics.Color

sealed class ChatSettingsEvent {
    data class OnStateOfSwipeChange(val value:String):ChatSettingsEvent()
    data class OnSizeOfTextChange(val value:Float):ChatSettingsEvent()
    data class OnMessageCornersChange(val value:Float):ChatSettingsEvent()
    data class OnStateOfColorChange(val color:Color):ChatSettingsEvent()
    data class OnStateOfColorIndexChange(val index:Int):ChatSettingsEvent()
    data class OnStateOfSwipeLeftInChatList(val state:String):ChatSettingsEvent()
    data class OnStateOfChatsList(val state:Boolean):ChatSettingsEvent()
    object NavigateToChooseWallpaperScreen: ChatSettingsEvent()
    object PopBackStack: ChatSettingsEvent()
}