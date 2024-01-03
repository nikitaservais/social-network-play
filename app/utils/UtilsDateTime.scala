package utils

import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDateTime, ZoneId, ZonedDateTime}
import java.util.concurrent.ThreadLocalRandom
val dateTimeFormat =
  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

/** Display a date time in a human readable format
  * @param dateTime
  * @return
  *   a string representation of the date time
  */
def displayDateTime(dateTime: ZonedDateTime): String = {
  dateTime.format(dateTimeFormat)
}

/** Display a date in a human readable format
  * @param dateTime
  * @return
  *   a string representation of the date
  */
def displayDate(dateTime: ZonedDateTime): String = {
  dateTime.format(dateFormat)
}

/** Generate a random date time between 2020-01-01 and 2023-12-31, this is used
  * for mocking data
  * @return
  *   a random ZonedDateTime between 2020-01-01 and 2023-12-31
  */
def randomDateTime(): ZonedDateTime = {
  val start = LocalDateTime.of(2020, 1, 1, 0, 0)
  val end = LocalDateTime.of(2023, 12, 31, 23, 59)
  val random = ThreadLocalRandom
    .current()
    .nextLong(
      start.toEpochSecond(ZoneId.systemDefault().getRules.getOffset(start)),
      end.toEpochSecond(ZoneId.systemDefault().getRules.getOffset(end))
    )
  ZonedDateTime.ofInstant(Instant.ofEpochSecond(random), ZoneId.systemDefault())
}
