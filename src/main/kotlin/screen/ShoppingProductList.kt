package screen

import data.CartItems
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
            /*val productSize = categoryProducts.size
            for(index in 0  until  productSize) {
                println("${index}. ${categoryProducts[index].name}")
            }*/
            // Refactor 컬렉션,고차함수
            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }
            
            showCartOption(categoryProducts,selectedCategory)
        }else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts:List<Product>, selectedCategory: String) {
        println("""
            **========================================**
            장바구니에 담을 상품 번호를 선택해주세요.
        """.trimIndent())

        val selectedIndex = readLine()?.toIntOrNull()!!


        println("""
            **========================================**
            장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *을 눌러주세요.
        """.trimIndent())
        categoryProducts.getOrNull(selectedIndex)?.let {
            product ->
            CartItems.addProduct(product)
            val answer = readLine()
            if(answer == "#") {
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            }else if (answer =="*"){
                showProducts(selectedCategory)
            } else {
                //TODO 그 외 값을 입력한 경우에
            }

        }
    }


    private fun showEmptyProductMessage(selectedCategory: String) {
        println("{$selectedCategory} 카테고리의 상품이 등록되기 전입니다.")
    }

}