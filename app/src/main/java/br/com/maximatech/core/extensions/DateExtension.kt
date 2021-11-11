package br.com.maximatech.core.extensions

import android.os.Build
import androidx.annotation.RequiresApi
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*

private val locale = Locale("pt", "BR")

fun getCurrentTime(): String {
    val currentTime = Calendar.getInstance().time
    return SimpleDateFormat("dd/MM/yyyy HH:mm", locale).format(currentTime)
}

fun String.formatDate(): String{
    val inputDateTime = this
    val inputParser = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendLiteral('T')
            .append(DateTimeFormatter.ISO_LOCAL_TIME)
            .appendPattern("X")
            .toFormatter(locale)
    } else {
        return this
    }
    val offsetDateTime = OffsetDateTime.parse(inputDateTime, inputParser)
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMM", locale)
    return offsetDateTime.format(outputFormatter)
}