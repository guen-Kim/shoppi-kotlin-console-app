package screen

class ShoppingCategory {

    fun showCategories() {
        val categories = arrayOf("전자기기", "패션", "음식")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요.")

        var selectedCategory = readLine()
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요.")
            selectedCategory = readLine()
        }
        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()

        } else {
            if(categories.contains(selectedCategory))
            {
                //TODO 2. 카테고리 상품 목록 보여주기
                val shoppingProductList =ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)

            } else{
                showErrorMessage(selectedCategory)
            }

        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("${selectedCategory} : 존재하지 않은 카테고리 입니다. 다시 입력해주세요.")
        showCategories()
    }

}