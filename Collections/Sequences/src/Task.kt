// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.

// 遅延操作についてのもの？
//顧客が注文したすべての配達済み製品の中で最も高価な製品を見つけます。
// `Order.isDelivered`フラグを使用します。

fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer
            .getOrderedProducts()
            .maxBy { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.

//製品が注文された回数をカウントします。
//顧客は同じ製品を数回注文する場合があることに注意してください。

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
            .asSequence()
            .flatMap { it.orders.asSequence() }
            .flatMap{ it.products.asSequence() }
            .count{ it == product }
}

fun Customer.getOrderedProducts(): Sequence<Product> =
        orders.asSequence().filter { it.isDelivered }.flatMap { it.products.asSequence() }
