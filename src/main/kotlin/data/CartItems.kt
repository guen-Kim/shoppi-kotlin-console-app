package data

object CartItems {
    private val mutableProducts = mutableMapOf<Product, Int>()
    val product: Map<Product, Int> = mutableProducts //public 상수

    fun addProduct(product: Product) {
        mutableProducts[product]?.let {//이미 상품이 있는 경우
            mutableProducts[product] = it + 1
        } ?: kotlin.run { // 상품이 없는 경우
            mutableProducts[product] = 1
        }
    }

}