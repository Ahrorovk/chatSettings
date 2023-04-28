package com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomSlider(
    value:Float,
    onValueChange:(Float)->Unit,
    title:String,
    valueRange:ClosedFloatingPointRange<Float>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth().background(MaterialTheme.colors.background)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = title,modifier=Modifier.padding(horizontal = 15.dp), fontSize = 18.sp, color = MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(value = value, onValueChange = onValueChange,
            valueRange = valueRange, modifier = Modifier.fillMaxWidth(0.95f))
            Text(text = "${value.toInt()}")
        }
    }
}