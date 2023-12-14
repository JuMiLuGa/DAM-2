package com.example.ud1_tarea_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ud1_tarea_4.ui.theme.UD1_Tarea_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UD1_Tarea_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBoxTop()
                    MyBoxBottom()
                    MyBoxCenter()
                }
            }
        }
    }
}

@Composable
fun MyBoxTop() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Estoy Arriba")
        }
    }
}

@Composable
fun MyBoxBottom() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Estoy Abajo")
        }
    }
}

@Composable
fun MyBoxCenter() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(0.35f)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Izquierda")
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(0.35f)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Derecha")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UD1_Tarea_4Theme {
        MyBoxTop()
        MyBoxBottom()
        MyBoxCenter()
    }
}