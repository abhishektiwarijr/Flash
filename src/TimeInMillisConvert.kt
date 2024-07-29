import java.util.concurrent.TimeUnit

fun main() {
//    val time1 = 9_000_00L
//    val time2 = 4320000L
//    println(convertMillisToTimeStringX(time1))
//    println(convertMillisToTimeString(time1))
//    println(convertMillisToTimeStringZ(time1))

    val duration1 = formatDuration(4800000) // 1 hour 20 mins
    val duration2 = formatDuration(7500000) // 2 hours 5 mins
    val duration3 = formatDuration(18060000) // 5 hours 1 min
    val duration4 = formatDuration(2100000) // 35 mins
    val duration5 = formatDuration(18000000) // 5 hours 0 mins

    println(duration1)
    println(duration2)
    println(duration3)
    println(duration4)
    println(duration5)
}

fun convertMillisToTimeStringX(milliseconds: Long): String {
    val seconds = (milliseconds / 1000 % 60).toInt()
    val minutes = ((milliseconds / (1000 * 60)) % 60).toInt()
    val hours = (milliseconds / (1000 * 60 * 60)).toInt()

    var timeString = ""
    if (hours > 0) {
        timeString += "$hours hour"
        if (hours > 1) {
            timeString += "s" // Add "s" for plural hours
        }
        if (minutes > 0) {
            timeString += " $minutes min"
        }
    } else if (minutes > 0) {
        timeString = "$minutes min"
    } else {
        timeString = "$seconds sec"
    }
    return timeString
}


fun formatDuration(milliseconds: Long): String {
    val seconds = milliseconds / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val remainingMinutes = minutes % 60

    return when {
        hours > 0 -> {
            if (remainingMinutes > 0) {
                "$hours hour${if (hours > 1) "s" else ""} $remainingMinutes min${if (remainingMinutes != 1L) "s" else ""}"
            } else {
                "$hours hour${if (hours > 1) "s" else ""}"
            }
        }

        remainingMinutes > 0 -> "$remainingMinutes min${if (remainingMinutes != 1L) "s" else ""}"
        else -> "0 mins"
    }
}


fun convertMillisToTimeString(milliseconds: Long): String {
    val hours = TimeUnit.MILLISECONDS.toHours(milliseconds)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds))
    val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds))

    var timeString = ""
    if (hours > 0) {
        timeString += "$hours hour"
        if (hours > 1) {
            timeString += "s"
        }
    }
    if (minutes > 0) {
        if (timeString.isNotEmpty()) {
            timeString += " "
        }
        timeString += "$minutes min"
    } else if (seconds > 0) {
        if (timeString.isNotEmpty()) {
            timeString += " "
        }
        timeString += "$seconds sec"
    }
    return timeString
}

fun convertMillisToTimeStringZ(milliseconds: Long): String {
    val hours = TimeUnit.MILLISECONDS.toHours(milliseconds)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds))

    var timeString = ""
    if (hours > 0) {
        timeString += "$hours hour"
        if (hours > 1) {
            timeString += "s"
        }
    }
    if (minutes > 0) {
        if (timeString.isNotEmpty()) {
            timeString += " "
        }
        timeString += "$minutes min"
    } else {
        timeString = "less than a minute"  // Handle case for milliseconds less than a minute
    }
    return timeString
}