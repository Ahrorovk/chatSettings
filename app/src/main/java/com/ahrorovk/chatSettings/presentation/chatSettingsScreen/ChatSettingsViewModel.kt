package com.ahrorovk.chatSettings.presentation.chatSettingsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChatSettingsViewModel @Inject constructor(

):ViewModel() {
    private val _state = MutableStateFlow(ChatSettingsState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        ChatSettingsState()
    )
    fun onEvent(event: ChatSettingsEvent){
        when(event){
            is ChatSettingsEvent.OnStateOfSwipeChange ->{
                _state.update {
                    it.copy(stateOfSwipeLeftInChatList = event.value)
                }
            }
            is ChatSettingsEvent.OnSizeOfTextChange->{
                _state.update {
                    it.copy(sizeOfText = event.value)
                }
            }
            is ChatSettingsEvent.OnMessageCornersChange ->{
                _state.update {
                    it.copy(messageCorners = event.value)
                }
            }
            is ChatSettingsEvent.OnStateOfColorChange->{
                _state.update {
                    it.copy(stateOfColor = event.color)
                }
            }
            is ChatSettingsEvent.OnStateOfColorIndexChange->{
                _state.update {
                    it.copy(stateOfColorIndex = event.index)
                }
            }
            is ChatSettingsEvent.OnStateOfSwipeLeftInChatList->{
                _state.update {
                    it.copy(stateOfSwipeLeftInChatList = event.state)
                }
            }
            is ChatSettingsEvent.OnStateOfChatsList->{
                _state.update {
                    it.copy(stateOfChatsList = event.state)
                }
            }
        }
    }
}