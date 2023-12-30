package utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

val dateTimeFormat =
  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

def displayDateTime(dateTime: ZonedDateTime): String = {
  dateTime.format(dateTimeFormat)
}

def displayDate(dateTime: ZonedDateTime): String = {
  dateTime.format(dateFormat)
}
