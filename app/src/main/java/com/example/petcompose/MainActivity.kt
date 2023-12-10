package com.example.petcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petcompose.ui.elements.ButtonsControl
import com.example.petcompose.ui.elements.FrameBackground
import com.example.petcompose.ui.model.Position
import com.example.petcompose.ui.theme.PetComposeTheme
import com.example.petcompose.ui.viewmodel.ContentViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = ContentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen(viewModel)
                }
            }
        }

        viewModel.startPositionUpdater()
    }
}

@Composable
private fun Screen(viewModel: ContentViewModel) {
    val state by viewModel.position.collectAsState()
    Column {
        FrameBackground(viewModel)
        ButtonsControl(
            onLeftClick = {
                val newXpos = state.xPos - 1
                viewModel.updatePosition(state.copy(xPos = newXpos.coerceAtLeast(0)))
            },
            onTopClick = {
                val newYpos = state.yPos + 1
                viewModel.updatePosition(state.copy(yPos = newYpos.coerceAtMost(2)))
            },
            onRightClick = {
                val newXpos = state.xPos + 1
                viewModel.updatePosition(state.copy(xPos = newXpos.coerceAtMost(2)))
            },
            onBottomClick = {
                val newYpos = state.yPos - 1
                viewModel.updatePosition(state.copy(yPos = newYpos.coerceAtLeast(0)))
            },
        )
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PetComposeTheme {
        Greeting("Android")
    }
}