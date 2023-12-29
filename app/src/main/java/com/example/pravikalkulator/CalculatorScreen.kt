package com.example.pravikalkulator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CalculatorScreen() {
    var prviBroj by remember { mutableStateOf(0.0) }
    var drugiBroj by remember { mutableStateOf(0.0) }
    var rezultat by remember { mutableStateOf(0.0) }
    Column() {
        TextField(
            value = prviBroj.toString(),
            onValueChange = {
                if (it.toDoubleOrNull() != null)
                    prviBroj = it.toDouble()
            },
            label = {
                Text(text = "Prvi broj")
            }
        )

        TextField(
            value = drugiBroj.toString(),
            onValueChange = {
                if (it.toDoubleOrNull() != null)
                    drugiBroj = it.toDouble()
            },
            label = {
                Text(text = "Drugi broj")
            }
        )
        Text(text = rezultat.toString())

        Row() {
            Button(
                onClick = {
                    if (prviBroj != null || drugiBroj != null)
                        rezultat = prviBroj + drugiBroj
                }
            ) {
                Text(text = "+")
            }
            Button(
                onClick = {
                    if (prviBroj != null || drugiBroj != null)
                        rezultat = prviBroj - drugiBroj
                }
            ) {
                Text(text = "-")
            }
            Button(
                onClick = {
                    if (prviBroj != null || drugiBroj != null)
                        rezultat = prviBroj * drugiBroj
                }
            ) {
                Text(text = "*")
            }
            Button(
                onClick = {
                    if (prviBroj != null || drugiBroj != null)
                        rezultat = prviBroj / drugiBroj
                }
            ) {
                Text(text = "/")
            }
        }
    }
}