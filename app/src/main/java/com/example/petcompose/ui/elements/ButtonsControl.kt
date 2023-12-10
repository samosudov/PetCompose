package com.example.petcompose.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.petcompose.ui.model.Position

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonsControl(
    onLeftClick: () -> Unit,
    onTopClick: () -> Unit,
    onRightClick: () -> Unit,
    onBottomClick: () -> Unit,
) {
    Row {
        Button(onClick = onLeftClick) { }
        Button(onClick = onTopClick) { }
        Button(onClick = onRightClick) { }
        Button(onClick = onBottomClick) { }
    }
}