fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {
    // collection = listOf("", "", "", "", "a", "bb", "ccc", "dddd")
    // expected = listOf("", "", "", "")


    // lengthごとにグルーピングする
    val groupsByLength = collection.groupBy { s -> s.length }
    println(groupsByLength)
    // Map型のKeyとValuesを返す
    // {0=[, , , ], 1=[a], 2=[bb], 3=[ccc], 4=[dddd]}

    // 一番サイズの大きいグループの変数

    // groupByLength.values
    // abstract val values: Collection<V>
    // Returns a read-only Collection of all values in this map. Note that this collection may contain duplicate values.
    // Mapのvaluesをmapで取り出す
    // groupByLength.values = [[, , , ], [a], [bb], [ccc], [dddd]]

    // groupsByLength.values.map{ group -> group.size }
    // この中のグループのサイズ（要素数）をmapで返す
    // [4, 1, 1, 1, 1]

    // groupByLength.values.map{ group -> group.size }.max()
    // グループのサイズのmapの中から最も大きいものを取り出す
    // 4

    val maximumSizeOfGroup = groupsByLength.values.map { group -> group.size }.max()
    println("groupByLength.values = " + groupsByLength.values.map{group -> group.size})
    // 4

    // 最終的にグループのサイズがもっとも大きいグループのvaluesを返すことを目的としている
    // 最初に渡されたlistがnullの時に返り値はnullとなる
    println(groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup })
    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
    // [, , , ]

    // fun doSomethingWithCollectionOldStyle(
    //    collection: Collection
    //): Collection? {
    //    val groupsByLength = mutableMapOf&gt;()
    //    for (s in collection) {
    //        var strings: MutableList? = groupsByLength[s.length]
    //        if (strings == null) {
    //            strings = mutableListOf()
    //            groupsByLength[s.length] = strings
    //        }
    //        strings.add(s)
    //    }
    //
    //    var maximumSizeOfGroup = 0
    //    for (group in groupsByLength.values) {
    //        if (group.size &gt; maximumSizeOfGroup) {
    //            maximumSizeOfGroup = group.size
    //        }
    //    }
    //
    //    for (group in groupsByLength.values) {
    //        if (group.size == maximumSizeOfGroup) {
    //            return group
    //        }
    //    }
    //    return null
    //}

    //firstOrNull()
    //fun main(args: Array<String>) {
    //    val iterable = listOf(1, 2, 3, 4, 5)
    //
    //    println(iterable.firstOrNull())
    //    println(iterable.firstOrNull { it % 2 == 0 })
    //    println(iterable.firstOrNull { it % 6 == 0 })
    //}
    //実行結果
    //1
    //2
    //null
    //先頭の要素を取得する。
    //ラムダ式で条件を絞り込める。
    //該当する要素が存在しない場合は null が返される。
}

