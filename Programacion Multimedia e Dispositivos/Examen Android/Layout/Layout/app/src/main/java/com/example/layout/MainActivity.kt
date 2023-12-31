package com.example.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layout.ui.theme.LayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBox("Probando elemento BOX")
                    MyColumn()
                    MyRow()
                }
            }
        }
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(text = "Texto 1", modifier = Modifier.width(100.dp))
        Text(text = "Texto 2", modifier = Modifier.width(100.dp))
        Text(text = "Texto 3", modifier = Modifier.width(100.dp))
        Text(text = "Texto 4", modifier = Modifier.width(100.dp))
        Text(text = "Texto 5", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyColumn (){
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Red))
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.White))
        Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Blue))
        //Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Black).weight(4f))
        Text(text = "Ejemplo 4", modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .height(100.dp)
        )
        Text(text = "Ejemplo 5", modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .height(100.dp)
        )
        Text(text = "Ejemplo 6", modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .height(100.dp)
        )
        Text(text = "Ejemplo 7", modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .height(100.dp)
        )
        Text(text = "Ejemplo 8", modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .height(100.dp)
        )
        Text(text = "Ejemplo 9", modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .height(100.dp)
        )
    }
}


@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .background(Color.Red)
            .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Probando elemento BOX")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutTheme {
        //MyBox("Probando elemento BOX")
        //MyColumn()
        MyRow()
    }
}