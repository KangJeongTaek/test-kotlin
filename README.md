# Kotlin-TEST
## 코틀린 문법 공부

### 1.1 Hello World
```kotlin
println("hello world")
```
### 1.2 변수 VAL, VAR
- val 은 불변인 변수를 선언시 사용
- var 은 가변인 변수를 선언시 사용

```kotlin
val a = 1
/*a = 2  에러 */

var b = 1
b = 2
```
### 1.3 문자열 템플릿
- 문자열 내에 변수나 표현식을 사용하여 값을 문자열에 포함시킬 수 있게 하는 가능

```kotlin
val num = 42
println("num = $num")

val a = 1
val b = 2
println("$a + $b = ${a + b}")
```

### 1.4 자료형
1. 정수형
   1. Byte 8비트
   2. Short 16비트
   3. Int 32비트
   4. Long 64비트
2. 실수형
   1. Float 32비트 부동소수점
   2. Double 64비트 부동소수점
3. 문자 (Char)
   1. Char : 16비트 유니코드 문자 (이모지는 안 됨)
4. 문자열 (String)
   1. String
5. 논리 (Boolean)
   1. Boolean true false
6. 배열
   1. 고쟁된 크기를 가지며 같은 타입의 요소들을 순차적으로 저장하는 데이터 타입
   2. Array 클래스로 제공
   3. 배열 사용시는 배열의 크기와 초기화를 어떻게 할지 결정해야 한다
    ```kotlin
    val numbers = arrayOf(1,2,3,4,5)
    println(numbers.joinToString())
    
    val fiveZeros = Array(5){0}
    println(fiveZeros.joinToString())
    ```

7. 컬렉션
   1. 크기를 동적으로 변경할 수 있는 데이터 타입
   2. 리스트, 세트, 맵이 대표적인 데이터 타입
        1. 리스트 : 순서대로 데이터가 저장되는 타입, 중복허용
        2. 세트 : 순서가 유지 되지 않으나 중복이 없음
        3. 맵 : 키와 값의 쌍으로 데이터를 저장. 키는 중복 안 됨
    ```kotlin
    val fruits = listOf("Apple","Banana","Cherry")
   
   val uniqueNumbers = setOf(1,2,3,4,5)
   
   val capitals = mapOf("대한민국" to "서울","프랑스" to "파리")
    ```
8. 가변 컬렉션
   1. 컬렉션의 리스트, 세트, 맵에 대해 불변과 가변(mutable) 버전이 있다.
   2. 불변 컬렉션은 생성 후 변경이 불가
   3. 가면 컬렉션은 생성 후 요소 추가, 제거, 변경 가능

### 1.5 함수
- 반복 사용을 위한 코드 문치
- fun 키워드로 선언 가능
- 이름, 파람터 선언부, 반환값 선언부, 몸체 및 반환값으로 구성되어 있음
- 함수 안에 함수 선언 가능

1.5.1 함수 선언법 1
```kotlin
fun sum(a: Int, b : Int) : Int{
    return a + b
}
```
1.5.2 함수 선언법 2
```kotlin
fun addTwo(num : Int) = num + 2
```

1.5.3 함수 선언법 3
- 람다식으로 익명함수를 만든 다음 addThree 변수에 할당
```kotlin
val addThree = {num :Int  -> num +3}
```

### 1.6 조건문
- 코틀린은 기본적으로 if와 when을 사용
- if 문을 기본적인 조건문
- when은 자바의 switch에 해당하며 여러 조건 중 하나 선택
- if, when 둘 다 표현식으로 사용가능하여, 조건문의 결과값을 값에 할당가능
