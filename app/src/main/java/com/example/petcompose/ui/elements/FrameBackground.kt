package com.example.petcompose.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.petcompose.ui.viewmodel.ContentViewModel

@Composable
internal fun FrameBackground(
    viewModel: ContentViewModel
) {
    val state by viewModel.position.collectAsState()
    Column {
        Row {
            repeat(3) {
                if (state.xPos == 0 && state.yPos == it) {
                    GridItem(true)
                } else {
                    GridItem()
                }
            }
        }
        Row {
            repeat(3) {
                if (state.xPos == 1 && state.yPos == it) {
                    GridItem(true)
                } else {
                    GridItem()
                }
            }
        }
        Row {
            repeat(3) {
                if (state.xPos == 2 && state.yPos == it) {
                    GridItem(true)
                } else {
                    GridItem()
                }
            }
        }
    }
}

@Composable
fun GridItem(isSelected: Boolean = false) {
    Box(
        Modifier
            .height(60.dp)
            .width(60.dp)
            .background(if (isSelected) Color.Black else Color.White)
    )
}