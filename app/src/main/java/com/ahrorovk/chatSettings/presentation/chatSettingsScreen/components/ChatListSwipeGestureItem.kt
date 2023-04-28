package com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ChatListSwipeGestureItem(
    color: Color,
    icon:ImageVector
) {
    Row(modifier= Modifier
        .width(180.dp)
        .height(40.dp)
        .border(1.dp,Color.DarkGray, RoundedCornerShape(12.dp))
        .clip(
            RoundedCornerShape(12.dp)
        )
        .background(color),
        verticalAlignment = Alignment.CenterVertically
        ) {
        Row(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(MaterialTheme.colors.background)
                ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp))
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column {
                Box(
                    modifier = Modifier
                        .width(70.dp)
                        .height(5.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(5.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
        }
        Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colors.onBackground, modifier = Modifier.padding(start = 10.dp))
    }
}