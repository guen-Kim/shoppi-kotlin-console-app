package screen

import LINE_DIVIDER
import data.CartItems
import extensions.getNotEmptyString

class ShoppingCart: Screen() {
    private val  products = CartItems.product //?

    fun showCartItems() {
        ScreenStack.push(this)
        if(products.isNotEmpty()) {
            println(
                products.keys.joinToString (
                    separator = ", \n",
                    prefix = """
                       $LINE_DIVIDER
                        장바구니에 담은 상품 목록 입니다.
                        """.trimIndent()
                ){ product
                    -> "카테고리: ${product.categoryLabel} / 싱품명: ${product.name} / 수량: ${products[product]}"
                }
            )
        } else {
            println("""
                장바구니에 담긴 상품이 없습니다.
                """".trimIndent())
        }
        showPreviousScreenOption()
    }

    fun showPreviousScreenOption(){
        print("""
            $LINE_DIVIDER
            이전 화면으로 이동하겠습니까? (y/n)
        """.trimIndent()
        )
        when(readLine().getNotEmptyString()) {
            "y" -> {
                moveToPreviousScreen()
            }
            "n" -> {
                showCartItems()
            }
            else -> {
                //TODO: 재입력 요청
            }
        }
    }

   fun moveToPreviousScreen() {
       ScreenStack.pop()
       when(val previousScreen = ScreenStack.peek()) {
           is ShoppingCategory -> {
               previousScreen.showCategories()
           }
           is ShoppingProductList -> {
               previousScreen.showProducts()
           }
           is ShoppingCart, is ShoppingHome -> {
               //아무것도 안함
           }
           null -> println("null")
       }
   }
}
