package com.example.view_model_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.view_model_intro.ui.theme.ViewModelIntroTheme
import com.example.view_model_intro.viewModals.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val counterViewModel: CounterViewModel by viewModels()
            ViewModelIntroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding),
                        counterViewModel = counterViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier, counterViewModel: CounterViewModel) {


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Count: ${counterViewModel.getCount()}",
        )

        Row {

            Button(onClick = { counterViewModel.decrement() }) {
                Text(text = "Decrement")
            }

            Spacer(modifier = modifier.width(8.dp))

            Button(onClick = { counterViewModel.increment() }) {
                Text(text = "Increment")
            }
        }
    }

}
