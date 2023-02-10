import kotlin.io.*

fun main(args: Array<String>) {
    println("안녕하세요. Shoppi 에 오신 것을 환영합니다.")
    println("쇼핑을 계속 하시려면 이름을 입력해주세요.")

    val input = readLine()

    //triple quoates - original text
    println("""
        감사합니다.$input 님 원하시는 카테고리 입력해줘
        ---------------------------
    """.trimIndent())

}