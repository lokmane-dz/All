package me.lokmvne.kotlinflows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.lokmvne.kotlinflows.ui.theme.KotlinFlowsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewmodel by viewModels<MyviewModel>()
            //val count = viewmodel.counDown.collectAsState(initial = 10)
            val state = viewmodel.stateFlow.collectAsState(12)

            KotlinFlowsTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Countdown: ${viewmodel.count.value}")
                    Spacer(modifier = Modifier.height(50.dp))
                    Button(
                        onClick = {
                            viewmodel.collectFlow()
                        },
                        enabled = viewmodel.enabled.value
                    ) {
                        Text(text = "START: ${state.value}")
                    }

                }
            }
        }
    }
}

