import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*


fun main() {
    val serverTimeZone = "EST" // Replace with the actual server timezone
//    val formattedTime = getCurrentTimeInEST(serverTimeZone)
//    val format = DateTimeFormatter.ofPattern("hh:mm a")
//    val a = SimpleDateFormat("hh:mm a").format(changeTimezoneOfDate(
//        Calendar.getInstance().time,
//        TimeZone.getDefault(),
//        TimeZone.getTimeZone("EST")
//    ).timeInMillis)
    val calendar = Calendar.getInstance()
    val fromTimeZone = calendar.timeZone
    val toTimeZone = TimeZone.getTimeZone("EST")

    calendar.timeZone = fromTimeZone
    calendar.add(Calendar.MILLISECOND, fromTimeZone.rawOffset * -1)
    if (fromTimeZone.inDaylightTime(calendar.time)) {
        calendar.add(Calendar.MILLISECOND, calendar.timeZone.dstSavings * -1)
    }

    calendar.add(Calendar.MILLISECOND, toTimeZone.rawOffset)
    if (toTimeZone.inDaylightTime(calendar.time)) {
        calendar.add(Calendar.MILLISECOND, toTimeZone.dstSavings)
    }

    println(SimpleDateFormat("hh:mm a").format(calendar.time))
}

//fun getCurrentTimeInEST(serverTimeZone: String): String {
//    val currentTime = Calendar.getInstance()
//
//    val estTimeZone = if (serverTimeZone == "EST") {
//        TimeZone.getTimeZone("EST")
//    } else {
//        // Handle other potential server time zone formats (optional)
//        TimeZone.getDefault()
//    }
//
//    currentTime.timeZone = estTimeZone
//
//    val rawOffset = estTimeZone.rawOffset
//    val dstOffset = estTimeZone.getOffset(currentTime.timeInMillis)
//    val isDaylightSavingTime = dstOffset > rawOffset
//
//    if (isDaylightSavingTime) {
//        currentTime.add(Calendar.HOUR_OF_DAY, -1)
//    }
//
//    val dateFormat = SimpleDateFormat("hh:mm a")
//    dateFormat.timeZone = estTimeZone
//    return dateFormat.format(currentTime.time)
//}

fun getCurrentTimeInEST(serverTimeZone: String): String {
    val currentInstant = Instant.now()
    val estZoneId = if (serverTimeZone == "EST") {
        // timezoneMap.put("PST", "America/Los_Angeles")
        // timezoneMap.put("CST", "America/Chicago")
        // timezoneMap.put("MST", "America/Denver")
        ZoneId.of("America/New_York") // More specific EST identifier
    } else {
        // Handle other potential server time zone formats (optional)
        ZoneId.of(serverTimeZone) // Try parsing the server zone string
    }
    val zonedDateTime = currentInstant.atZone(estZoneId)

    val format = DateTimeFormatter.ofPattern("hh:mm a")
    return format.format(zonedDateTime)
}

fun changeTimezoneOfDate(date: Date?, fromTZ: TimeZone, toTZ: TimeZone): Calendar {
    val calendar = Calendar.getInstance()
    calendar.time = date
    val millis = calendar.timeInMillis
    val fromOffset = fromTZ.getOffset(millis).toLong()
    val toOffset = toTZ.getOffset(millis).toLong()
    val convertedTime = millis - (fromOffset - toOffset)
    val c = Calendar.getInstance()
    c.timeInMillis = convertedTime
    return c
}

private fun shiftTimeZone(date: Date, sourceTimeZone: TimeZone, targetTimeZone: TimeZone): Date {
    val sourceCalendar = Calendar.getInstance()
    sourceCalendar.time = date
    sourceCalendar.timeZone = sourceTimeZone

    val targetCalendar = Calendar.getInstance()
    for (field in intArrayOf(
        Calendar.YEAR,
        Calendar.MONTH,
        Calendar.DAY_OF_MONTH,
        Calendar.HOUR,
        Calendar.MINUTE,
        Calendar.SECOND,
        Calendar.MILLISECOND
    )) {
        targetCalendar[field] = sourceCalendar[field]
    }
    targetCalendar.timeZone = targetTimeZone
    println("........" + targetCalendar.timeZone)
    return targetCalendar.time
}
