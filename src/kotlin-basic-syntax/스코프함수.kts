data class Person(var name: String, var age: Int? = null)

fun letTest(){
    val name : String ? = "승귤"
    name?.let {
        println(it)
    }

    val nullName : String? = null

    nullName?.let{
        println(it)
    }

    val length = name?.let{
        it.length
    } ?: 0 // 엘비스 표현(?:) null 일 때 기본 값
    println(length)
}

fun runTest(){
    // 객체 초기화 및 메서드 호출
    val message = "안녕하세요, 반가워요".run{
        val words = split(", ")
        words[1]
    }
    println(message)

    val result = run{
        val x = 1_000_000_000
        val y = 1
        x + y
    }
    println(result)
}

fun withTest(){
    val list = mutableListOf<Int>()
    val size = with(list) {
        add(1)
        add(2)
        add(3)
        add(4)
        size
    }

    val stringDescription : String = with(StringBuilder()){
        append("Kotlin")
        append("Scope")
        toString()
    }
}

fun applyTest(){
    val Person = Person().apply {
        name = "강정택"
        age = 29
    }
}

fun alsoTest(){
    val numbers = mutableListOf(1,2,3)
    val newNumbers = numbers.also{
        it.add(5)
    }
}