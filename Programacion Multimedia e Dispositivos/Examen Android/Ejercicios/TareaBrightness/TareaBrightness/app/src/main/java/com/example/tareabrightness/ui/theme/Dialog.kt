package com.example.tareabrightness.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun MyBrightnessDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Column (
                Modifier
                    .fillMaxWidth()
                    .background(Color.Black)

            ){
                MyTitulo(text = "Brightness")
                Divider(Modifier.fillMaxWidth(), color = Color.Blue, thickness = 1.dp)
                MyCheckBoxButton("Automatic Brightness")
                MySlider()
                Row(Modifier.align(Alignment.End)) {

                    TextButton(onClick = {  }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = "OK")
                    }
                }

            }
        }
    }
}

@Composable
fun MyTitulo(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp,
        modifier = Modifier.padding(12.dp),
        color = Color.Blue
    )
}

@Composable
fun MyCheckBoxButton(text: String) {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off)}
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {


    TriStateCheckbox(
        state = status,
        onClick = {
            status = when(status){
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.On
                ToggleableState.Indeterminate -> ToggleableState.Off
            }
        }
    )
    Text(text = text,
         color = Color.White)
    }
}

@Composable
fun MySlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp)) {
        var sliderPosition by remember{ mutableStateOf(0f) }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it},
            valueRange= 0f..1f,
            enabled = true,
            colors= SliderDefaults.colors()
        )

    }
}

@Composable
fun MyButtonRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .border(1.dp, Color.White),

        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = {  },
            modifier = Modifier.background(color = Color.Black)
        ) {
            Text("Cancelar", fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = {  },
            modifier = Modifier.background(color = Color.Black)
        ) {
            Text("OK", fontWeight = FontWeight.Bold)
        }
    }
}
