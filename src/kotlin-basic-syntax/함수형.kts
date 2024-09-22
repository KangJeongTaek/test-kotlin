// 순수 함수
fun add(a: Int, b: Int) : Int{
    return a + b
}

// 순수하지 않는 함수
var count = 0
fun incr() = count++

// 부수 효과
class BankAccount(var balance: Double){
    fun deposit(amount: Double){
        balance += amount
    }

    fun withdraw(amount: Double){
        balance -= amount
    }
}
fun 부수효과(){
    fun minusTenByHacker(account:BankAccount){
        account.balance -=  10
    }

    val account = BankAccount(100.0)

}

// 부수 효과 제거
data class ImmutableBankAccount(val balance: Double){
    fun deposit(amount: Double) : ImmutableBankAccount {
        return ImmutableBankAccount(balance + amount)
    }

    fun withdraw(amount: Double) : ImmutableBankAccount {
        return ImmutableBankAccount(balance - amount)
    }
}

fun 부수효과제거(){
    fun minusTenByHacker(account:ImmutableBankAccount) : ImmutableBankAccount{
        return ImmutableBankAccount(account.balance - 10)
    }
}


