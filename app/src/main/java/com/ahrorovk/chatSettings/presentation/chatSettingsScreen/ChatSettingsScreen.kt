package com.ahrorovk.chatSettings.presentation.chatSettingsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components.ChatListSwipeGestureItem
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components.ChatListViewItem
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components.CustomSlider
import com.ahrorovk.chatSettings.presentation.chatSettingsScreen.components.CustomTextBox
import com.chargemap.compose.numberpicker.ListItemPicker
import java.time.LocalDateTime

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "NewApi")
@Composable
fun ChatSettingsScreen(
    state:ChatSettingsState,
    onEvent: (ChatSettingsEvent)->Unit
) {
    val firstDate = LocalDateTime.now().plusMinutes(1)
    val secondDate = LocalDateTime.now()

    LazyColumn(modifier= Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.secondary)) {
        item {
                CustomSlider(
                    value = state.sizeOfText,
                    onValueChange = {
                        onEvent(ChatSettingsEvent.OnSizeOfTextChange(it))
                    },
                    title = "Size of message`s text",
                    12f..30f
                )
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .height((if (state.sizeOfText * 10 >= 150) state.sizeOfText.toInt() * 10 else 150).dp)
                    .background(state.stateOfColor)) {
                    item{
                        Spacer(modifier = Modifier.height(25.dp))
                        CustomTextBox(
                            content = "What books do you recommend",
                            date =  "${if(secondDate.hour>9) "" else "0"}${secondDate.hour}:${if(secondDate.minute>9) "" else "0"}${secondDate.minute}",
                            bottomStart = state.messageCorners.toInt(),
                            alignment = Alignment.CenterEnd,
                            fontSize = state.sizeOfText.toInt(),
                            corners = state.messageCorners.toInt()
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomTextBox(
                            content = "I recommend book 'Rich Dad and Poor Dad'",
                            date = "${if(firstDate.hour>9) "" else "0"}${firstDate.hour}:${if(firstDate.minute>9) "" else "0"}${firstDate.minute}",
                            topEnd = state.messageCorners.toInt(),
                            alignment = Alignment.CenterStart,
                            fontSize = state.sizeOfText.toInt(),
                            corners = state.messageCorners.toInt()
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            Row(modifier= Modifier
                .fillMaxWidth()
                .clickable { onEvent(ChatSettingsEvent.NavigateToChooseWallpaperScreen) }
                .background(MaterialTheme.colors.background),
                verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.padding(horizontal = (7.5).dp))
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(text = "Change Chat Wallpaper",modifier=Modifier.padding(vertical = 10.dp))
            }

            Spacer(modifier = Modifier.padding(10.dp))
            CustomSlider(
                    value = state.messageCorners,
                    onValueChange = {
                        onEvent(ChatSettingsEvent.OnMessageCornersChange(it))
                    },
                    title = "Message corners",
                    0f..17f
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
                .background(MaterialTheme.colors.background),) {
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Chat list view",
                    color = MaterialTheme.colors.primary,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ChatListViewItem(
                        isActive = state.stateOfChatsList,
                        title = "Two lines",
                        repeat = 1
                    ) {
                        onEvent(ChatSettingsEvent.OnStateOfChatsList(true))
                    }
                    ChatListViewItem(
                        isActive = !state.stateOfChatsList,
                        title = "Three lines",
                        repeat = 2
                    ) {
                        onEvent(ChatSettingsEvent.OnStateOfChatsList(false))
                    }
                    Spacer(modifier = Modifier.padding(15.dp))
                }
                Spacer(modifier = Modifier.padding(10.dp))
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .background(MaterialTheme.colors.background)) {
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Chat list swipe gesture",
                    color = MaterialTheme.colors.primary,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {

                        ChatListSwipeGestureItem(
                            color = (if (state.stateOfSwipeLeftInChatList == state.swipeLeftValues[0]) Color.Red else Color.Blue),
                            icon = if (state.stateOfSwipeLeftInChatList == state.swipeLeftValues[0]) Icons.Filled.Delete else if (state.stateOfSwipeLeftInChatList == state.swipeLeftValues[1]) Icons.Filled.PlayArrow else Icons.Default.AccountBox
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                    }
                    Column(modifier = Modifier) {
                        ListItemPicker(
                            dividersColor = MaterialTheme.colors.primary,
                            label = { it },
                            value = state.stateOfSwipeLeftInChatList,
                            onValueChange = {
                                onEvent(
                                    ChatSettingsEvent.OnStateOfSwipeLeftInChatList(
                                        it
                                    )
                                )
                            },
                            list = state.swipeLeftValues
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                    }
                }
            }
        }
    }
}