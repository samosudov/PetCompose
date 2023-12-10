package com.example.petcompose.business.updater

import com.example.petcompose.ui.model.Position
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.logging.Logger
import kotlin.random.Random

internal class PositionUpdater {

    private val _nextTime = MutableSharedFlow<Position>(replay = 1)
    val nextTime: SharedFlow<Position> = _nextTime.asSharedFlow()

    private var previousPosition = Position()

    suspend fun start() {
        while (true) {
            val nextX = Random.nextInt(-1, 2)
            val nextY = Random.nextInt(-1, 2)
            println("nextX=$nextX, nextY=$nextY")
            previousPosition = Position(
                (previousPosition.xPos + nextX).coerceAtLeast(0).coerceAtMost(2),
                (previousPosition.yPos + nextY).coerceAtLeast(0).coerceAtMost(2)
            )
            _nextTime.emit(previousPosition)
            delay(1000)
        }
    }




}