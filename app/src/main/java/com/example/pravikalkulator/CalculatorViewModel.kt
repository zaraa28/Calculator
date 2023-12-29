package com.example.pravikalkulator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var prviBroj =  mutableStateOf("")
    var drugiBroj =  mutableStateOf("")
    var operacija =  mutableStateOf<Char?>(null)
    var rezultat =  mutableStateOf<Double?>(null)

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
}