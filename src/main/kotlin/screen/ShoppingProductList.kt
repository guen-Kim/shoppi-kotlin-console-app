package screen

import data.Product

class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("패션", "겨울 패딩"),
        Product("전자기기", "이어폰"),
        Product("전자기기", "키보드"),
        Product("애견용품", "샴푸"),
        Product("애견용품", "간식"),
    )
// products-> products.categoryLabel을 키로하여 value 그룹화
    private val categories:Map<String, List<Product>> = products.groupBy { products-> products.categoryLabel }

    fun showProducts(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()) {
            println("""
                ========================================================
                선택하신 {$selectedCategory} 카테고리 상품입니다.
                ========================================================
            """.trimIndent())
            val productSize = categoryProducts.size
            for(index in 0  until  productSize) {
                println("${index}. ${categoryProducts[index].name}")
            }
        }else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("{$selectedCategory} 카테고리의 상품이 등록되기 전입니다.")
    }


}