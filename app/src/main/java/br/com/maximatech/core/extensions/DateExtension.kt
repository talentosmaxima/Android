package br.com.maximatech.core.extensions

import java.text.SimpleDateFormat
import java.util.*

private val locale = Locale("pt", "BR")

fun getCurrentTime(): String {
    val currentTime = Calendar.getInstance().time
    return SimpleDateFormat("dd/MM/yyyy HH:mm", locale).format(currentTime)
}