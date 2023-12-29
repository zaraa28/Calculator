package com.example.pravikalkulator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculator2Screen() {
    var prviBroj = remember { mutableStateOf("") }
    var drugiBroj = remember { mutableStateOf("") }
    var operacija = remember { mutableStateOf<Char?>(null) }
    var rezultat = remember { mutableStateOf<Double?>(null) }

    Column() {
        TextField(
            value = rezultat.value?.toString()
                ?: (prviBroj.value + (operacija.value?.toString() ?: "") + drugiBroj.value),
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Kalkulator") }
        )
        Row {
            Button(onClick = { stvoriBroj("1", prviBroj, drugiBroj, operacija) }) { Text(text = "1") }
            Button(onClick = { stvoriBroj("2", prviBroj, drugiBroj, operacija) }) { Text(text = "2") }
            Button(onClick = { stvoriBroj("3", prviBroj, drugiBroj, operacija) }) { Text(text = "3") }
        }
        Row {
            Button(onClick = { stvoriBroj("4", prviBroj, drugiBroj, operacija) }) { Text(text = "4") }
            Button(onClick = { stvoriBroj("5", prviBroj, drugiBroj, operacija) }) { Text(text = "5") }
            Button(onClick = { stvoriBroj("6", prviBroj, drugiBroj, operacija) }) { Text(text = "6") }
        }
        Row {
            Button(onClick = { stvoriBroj("7", prviBroj, drugiBroj, operacija) }) { Text(text = "7") }
            Button(onClick = { stvoriBroj("8", prviBroj, drugiBroj, operacija) }) { Text(text = "8") }
            Button(onClick = { stvoriBroj("9", prviBroj, drugiBroj, operacija) }) { Text(text = "9") }
            Button(onClick = { stvoriBroj("0", prviBroj, drugiBroj, operacija) }) { Text(text = "0") }
        }
        Row {
            Button(onClick = { operacija.value = '+' }) { Text(text = "+") }
            Button(onClick = { operacija.value = '-' }) { Text(text = "-") }
            Button(onClick = { operacija.value = '*' }) { Text(text = "*") }
            Button(onClick = { operacija.value = '/' }) { Text(text = "/") }
            Button(onClick = {  izracunaj(prviBroj, drugiBroj, operacija, rezultat) }) { Text(text = "/") }
        }
        Row {
            Button(onClick = { operacija.value = '+' }) { Text("+") }
            Button(onClick = { operacija.value = '*' }) { Text("*") }
            Button(onClick = { operacija.value = '/' }) { Text("/") }
            Button(onClick = { operacija.value = '-' }) { Text("-") }
        }
        Row {
            Button(onClick = { izracunaj(prviBroj, drugiBroj, operacija, rezultat) }) { Text("=") }
            Button(onClick = {
                rezultat.value = null
                prviBroj.value = ""
                drugiBroj.value = ""
                operacija.value = null
            }) { Text("Brisi") }
        }
    }
}

fun stvoriBroj(
    znamenka: String,
    prviBroj: MutableState<String>,
    drugiBroj: MutableState<String>,
    operacija: MutableState<Char?>
) {
    if (operacija.value == null)
        prviBroj.value = prviBroj.value + znamenka
    else
        drugiBroj.value = prviBroj.value + znamenka
}

fun izracunaj(
    prviBroj: MutableState<String>,
    drugiBroj: MutableState<String>,
    operacija: MutableState<Char?>,
    rezultat: MutableState<Double?>
) {
    val br1 = prviBroj.value.toDoubleOrNull()
    val br2 = drugiBroj.value.toDoubleOrNull()

    if (br1 != null && br2 != null) {
        rezultat.value = when (operacija.value) {
            '+' -> br1 + br2
            '-' -> br1 + br2
            '*' -> br1 + br2
            '/' -> br1 + br2
            else -> null
        }
    }
}



