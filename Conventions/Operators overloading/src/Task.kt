import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)
data class PluralPlus (val timeInterval: TimeInterval, val number: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }
operator fun TimeInterval.times(number: Int) = PluralPlus(this, number)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(timeIntervals: PluralPlus): MyDate = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
