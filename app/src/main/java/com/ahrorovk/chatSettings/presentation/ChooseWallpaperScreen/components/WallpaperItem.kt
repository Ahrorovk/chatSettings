package com.ahrorovk.chatSettings.presentation.ChooseWallpaperScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WallpaperItem(
    color: Color,
    isSelected:Boolean,
    onClick:()->Unit
) {
    Box(modifier = Modifier
        .height(150.dp)
        .width(30.dp)
        .padding(2.dp)
        .background(color).clickable { onClick() }.padding(12.dp), contentAlignment = Alignment.Center) {
        if(isSelected){
            Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = Color.Cyan)
        }
    }
}