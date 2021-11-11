package br.com.maximatech.core.helpers

import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*

private val generalLocale = Locale("pt", "BR")

object DateHelper {
    fun formatDate(textDate: String): String {
        val inputParser =
            DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral('T')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .appendPattern("X")
                .toFormatter(generalLocale)
        val offsetDateTime = OffsetDateTime.parse(textDate, inputParser)
        val outputFormatter = DateTimeFormatter.ofPattern("dd MMM", generalLocale)
        return offsetDateTime.format(outputFormatter)
    }

    fun getCurrentDate(pattern: String, locale: Locale = generalLocale): String {
        val currentTime = Calendar.getInstance().time
        return SimpleDateFormat(pattern, locale).format(currentTime)
    }
}



