package screen




//프로그램 내에서 전역으로 화면이동 담당
object ScreenStack {
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen){
        screenStack.add(screen)
    }

    fun pop() {
        // 리스트에 원소가 없을 경우, null 반환하여 런타임 에러 발생 시키지 않음
        screenStack.removeLastOrNull()
    }
    fun peek(): Screen? {
        // 리스트에 원소가 없을 경우, null 반환하여 런타임 에러 발생 시키지 않음
        return screenStack.lastOrNull()
    }

}

sealed class Screen