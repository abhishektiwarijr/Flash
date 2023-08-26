fun main() {
    println(formatDurationInHRForm(62)) //"1 minute and 2 seconds"
    println(formatDurationInHRForm(3662)) //"1 hour, 1 minute and 2 seconds"
    println(formatDurationInHRForm(59)) //"59 seconds"
    println(formatDurationInHRForm(60)) //"1 minute"
    println(formatDurationInHRForm(31536000)) //"1 year"
}

fun formatDurationInHRForm(seconds: Int): String {
    if (seconds == 0) return "now"

    var mDuration = seconds
    val result = arrayListOf<String>()
    val oneMinute = 60
    val oneHour = 60 * oneMinute
    val oneDay = 24 * oneHour
    val oneYear = 365 * oneDay

    val years = mDuration / oneYear
    if (years > 0) {
        if (years > 1) {
            result.add("$years years")
        } else {
            result.add("$years year")
        }
        mDuration %= oneYear
    }
    val days = mDuration / oneDay
    if (days > 0) {
        if (days > 1) {
            result.add("$days days")
        } else {
            result.add("$days day")
        }
        mDuration %= oneDay
    }

    val hours = mDuration / oneHour
    if (hours > 0) {
        if (hours > 1) {
            result.add("$hours hours")
        } else {
            result.add("$hours hour")
        }
        mDuration %= oneHour
    }

    val minutes = mDuration / oneMinute
    if (minutes > 0) {
        if (minutes > 1) {
            result.add("$minutes minutes")
        } else {
            result.add("$minutes minute")
        }
        mDuration %= oneMinute
    }

    val leftSeconds = mDuration
    if (leftSeconds > 0) {
        if (leftSeconds > 1) {
            result.add("$leftSeconds seconds")
        } else {
            result.add("$leftSeconds second")
        }
    }
    return when (result.size) {
        2 -> {
            result.joinToString( " and ")
        }
        1 -> {
            result.joinToString("")
        }
        else -> {
            val last = result.removeAt(result.size-1)
            result.joinToString( ", ") + " and $last"
        }
    }
}