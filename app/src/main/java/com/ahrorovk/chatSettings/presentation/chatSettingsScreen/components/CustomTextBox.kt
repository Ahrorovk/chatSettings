package com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextBox(
    modifier: Modifier = Modifier,
    content: String,
    date: String,
    bottomStart:Int = 0,
    topEnd:Int = 0,
    alignment: Alignment,
    fontSize:Int,
    corners:Int
) {
    Box(modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp), contentAlignment = alignment) {
        Column(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        topStart = corners.dp,
                        topEnd = corners.dp,
                        bottomEnd = topEnd.dp,
                        bottomStart = bottomStart.dp
                    )
                )
//                .combinedClickable(
//                    onClick = {
//                    },
//                    onLongClick = {
//                    },
//                )
                .background(Color(0xA62B1A1A))
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = content, fontSize = fontSize.sp)
                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = date,
                    color = MaterialTheme.colors.onSecondary,
                    fontSize = (fontSize-2).sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}