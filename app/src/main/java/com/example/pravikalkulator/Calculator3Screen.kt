package com.example.pravikalkulator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculator3Screen() {
    val calcViewModel: CalculatorViewModel = viewModel()

    Column() {
        TextField(
            value = calcViewModel.rezultat.value?.toString()
                ?: (calcViewModel.prviBroj.value + (calcViewModel.operacija.value?.toString()
                    ?: "") + calcViewModel.drugiBroj.value),
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Kalkulator") }
        )
        Row {
            Button(onClick = {
                stvoriBrojVM(
                    "1",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "1") }
            Button(onClick = {
                stvoriBrojVM(
                    "2",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "2") }
            Button(onClick = {
                stvoriBrojVM(
                    "3",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "3") }
        }
        Row {
            Button(onClick = {
                stvoriBrojVM(
                    "4",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "4") }
            Button(onClick = {
                stvoriBrojVM(
                    "5",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "5") }
            Button(onClick = {
                stvoriBrojVM(
                    "6",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "6") }
        }
        Row {
            Button(onClick = {
                stvoriBrojVM(
                    "7",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "7") }
            Button(onClick = {
                stvoriBrojVM(
                    "8",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "8") }
            Button(onClick = {
                stvoriBrojVM(
                    "9",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "9") }
            Button(onClick = {
                stvoriBrojVM(
                    "0",
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija
                )
            }) { Text(text = "0") }
        }
        Row {
            Button(onClick = { calcViewModel.operacija.value = '+' }) { Text("+") }
            Button(onClick = { calcViewModel.operacija.value = '*' }) { Text("*") }
            Button(onClick = { calcViewModel.operacija.value = '/' }) { Text("/") }
            Button(onClick = { calcViewModel.operacija.value = '-' }) { Text("-") }
        }
        Row {
            Button(onClick = {
                izracunaj(
                    calcViewModel.prviBroj,
                    calcViewModel.drugiBroj,
                    calcViewModel.operacija,
                    calcViewModel.rezultat
                )
            }) { Text("=") }
            Button(onClick = {
                calcViewModel.rezultat.value = null
                calcViewModel.prviBroj.value = ""
                calcViewModel.drugiBroj.value = ""
                calcViewModel.operacija.value = null
            }) { Text("Brisi") }
        }
    }
}



fun stvoriBrojVM(
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

fun izracunajVM(
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
