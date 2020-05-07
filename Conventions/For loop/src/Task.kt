// 呼び出しもとはIterableな(反復可能な)MyDateを欲しているので
// 返り値はIterable<MyDate>とする
class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        // ここにiteratorの中身を書いていく
        return object : Iterator<MyDate> {
            var current: MyDate = start

            //
            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = current
                // Use the function MyDate.followingDate() defined in DateUtil.kt;
                // you don't have to implement the logic for finding the following date on your own.
                // らしいので
                current = current.followingDate()
                return result
            }

            // currentがendまでいったらfalse
            override fun hasNext(): Boolean = current <= end
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}