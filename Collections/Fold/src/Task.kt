// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allOrdered = customers.flatMap { it.getOrderedProducts() }.toSet()

    return customers.fold(allOrdered, { orderdAcc, customer ->
        orderdAcc.intersect(customer.orders.flatMap { it.products })
    })
}

fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }


// 全ての注文されたProducts.fold(Aさんが注文したProducts,{B,C...さんが注文したProductsのラムダ式})