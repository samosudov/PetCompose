package com.example.petcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petcompose.business.updater.PositionUpdater
import com.example.petcompose.ui.model.Position
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ContentViewModel: ViewModel() {

    private val positionUpdater = PositionUpdater()

    private val _position = MutableStateFlow(Position(1, 1))
    val position: StateFlow<Position> = _position.asStateFlow()

    fun updatePosition(position: Position) {
        _position.update {
            position
        }
    }

    fun startPositionUpdater() {
        viewModelScope.launch {
            positionUpdater.start()
        }
        viewModelScope.launch {
            positionUpdater.nextTime.collect {
                updatePosition(it)
            }
        }
    }

}