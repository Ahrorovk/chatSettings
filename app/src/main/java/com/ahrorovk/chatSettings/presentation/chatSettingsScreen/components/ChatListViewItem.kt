package com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ChatListViewItem(
    isActive:Boolean,
    title:String,
    repeat: Int,
    onCLick:()->Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row( modifier = Modifier
            .width(185.dp)
            .height(90.dp)
            .padding(start = 15.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(if (isActive) MaterialTheme.colors.background else MaterialTheme.colors.onBackground)
            .clickable { onCLick() }, verticalAlignment = Alignment.CenterVertically) {
            Column {
                Spacer(modifier = Modifier.padding(1.dp))
                ViewItem(color = Color.DarkGray, repeat = repeat)
                ViewItem(color = Color(0xFF949292), repeat = repeat)
            }
            IconToggleButton(
                checked = true,
                onCheckedChange = {
                    onCLick()
                },
                modifier = Modifier.padding(10.dp)
            ) {
                val transition = updateTransition(isActive, label = "")

                val tint by transition.animateColor(label = "iconColor") { isChecked ->
                    if (isChecked) Color.Green else MaterialTheme.colors.background
                }
                val size by transition.animateDp(
                    transitionSpec = {
                        if (false isTransitioningTo true) {
                            keyframes {
                                durationMillis = 250
                                30.dp at 0 with LinearOutSlowInEasing
                                35.dp at 15 with FastOutLinearInEasing
                                40.dp at 75
                                35.dp at 150
                            }
                        } else {
                            spring(stiffness = Spring.StiffnessVeryLow)
                        }
                    },
                    label = "Size"
                ) { 25.dp }

                Icon(
                    imageVector = if (isActive) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                    contentDescription = "Icon",
                    tint = tint,
                    modifier = Modifier.size(size)
                )
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
       Text(text = title)
    }
}
@Composable
fun ViewItem(color: Color,repeat:Int){
    Row(modifier=Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(color))
        Spacer(modifier = Modifier.padding(4.dp))
        Column {
            Box(modifier = Modifier
                .width(60.dp)
                .height(if(repeat==2)5.dp else 7.dp)
                .clip(CircleShape)
                .background(color))
            repeat(repeat) {
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .width(70.dp)
                        .height(5.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
            }
        }
    }
}