object TimeFormatter {

    fun formatDuration(seconds: Int): String {
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
                result.joinToString(" and ")
            }
            1 -> {
                result.joinToString("")
            }
            else -> {
                val last = result.removeAt(result.size - 1)
                result.joinToString(", ") + " and $last"
            }
        }
    }
    fun f(s: String, time: Int) = if(time==0) "" else time.toString()+" "+s+(if(time==1)"" else "s")
    fun formatDurationX(s:Int)=if(s==0) "now" else listOf(
        f("year",s/31536000),
        f("day", (s/86400)%365),
        f("hour",(s/3600)%24),
        f("minute", (s/60)%60),
        f("second", (s%3600)%60)).filter { e-> e.isNotBlank() }.joinToString(", ").replace(Regex(", (?!.+,)"), " and ")
}