// Return customers who have more undelivered orders than delivered
// customersの中から届いてないものが多い人だけをセットにして返す
// customerの届いたものと届いてないものを分ける
// 届いてないもののサイズが大きい時だけのフィルターをかける

fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = customers.filter {
       val (delivered, undelivered) = it.orders.partition { it.isDelivered }
            undelivered.size > delivered.size
}.toSet()