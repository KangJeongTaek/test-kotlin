fun String.느낌표추가(): String = this + "!".repeat(4)

fun 확장함수1() {
    val greeting: String = "Hello"
    println(greeting.느낌표추가())
}

확장함수1()