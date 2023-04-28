package com.ahrorovk.chatSettings

class Constants {
    enum class StateOfSwipe{
        DELETE,
        PIN,
        ARCHIVE
    }
}

sealed class Screens(val route:String){
    object ChatSettingsScreen : Screens("ChatSettingsScreen")
    object ChooseWallpaperScreen : Screens("ChooseWallpaperScreen")
}