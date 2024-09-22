package org.example

import java.security.SecureRandom

open class Unit(val job:String,var hp : Int, var atk : Int, var dfs : Int, var luk : Int){
    val MAX_HP : Int  = hp


    protected fun getLucky() = SecureRandom().nextInt(luk/3,luk + 1)

    fun attack(target: Unit){
        var damage = atk + getLucky() - SecureRandom().nextInt(0,target.dfs / 2)
        if( damage <0) damage = 0

        target.hp -= damage

        if (target.hp < 0) target.hp = 0

        println("${this.job}이(가) ${target.job} 공격!")
        println("${damage}의 피해를 입혔습니다. ${target.job} 남은 체력 : ${target.hp}")

        if (target.hp == 0){
            println("${target.job}의 체력이 0이 되었습니다.")
        }
    }

    override fun toString(): String {
        return "직업 : $job, 체력 : $hp, 공격력 : $atk, 방어력 : $dfs, 행운 : $luk"
    }
}

class Programmer(job:String,hp : Int, atk : Int, dfs : Int, luk : Int) : Unit(job,hp,atk,dfs,luk){
    init{
        super.hp += getLucky()
        super.atk += getLucky()
        super.dfs += getLucky()
    }

    fun heal(){
        hp += getLucky() + 10

        if(hp > MAX_HP){
            hp = MAX_HP
        }
        println("HP를 ${getLucky() + 10}만큼 회복했습니다. 현재 HP : $hp")
    }
}

class Monster(job:String,hp : Int, atk : Int, dfs : Int, luk : Int) : Unit(job,hp,atk,dfs,luk){
    fun copy() : Monster{
        return Monster(job,hp,atk,dfs,luk)
    }
}

class Game {

    private val jobMap = mapOf(
        "1" to Programmer("서버개발자",200,100,150,50),
        "2" to Programmer("클라이언트개발자",150,150,100,50),
        "3" to Programmer("데이터 사이언티스트",100,170,150,80),
        "2" to Programmer("인공지능 개발자",130,130,130,110),

    )

    private val monsters = listOf(
        Monster("슬라임",30,50,50,0),
        Monster("고블린",60,70,80,50),
        Monster("늑대",100,80,90,30),
        Monster("오크",200,150,200,0),
        Monster("다크엘프",140,200,100,30),
        Monster("드래곤",3000,300,200,50),
    )
    private fun createCharacter() : Unit{
        println("[캐릭터 생성]")
        println("[1] 서버개발자 [2] 클라이언트개발자 [3] 데이터 사이언티스트 [4] 인공지능개발자 [그외] 무직")
        val jobNum = readln()
        if(jobMap.containsKey(jobNum)){
            return jobMap.getValue(jobNum)
        }
        return Programmer("평민",100,100,100,100)
    }

    private fun battle(programmer : Unit, monster : Unit){
        fun battleUser(){
            println("[1] 공격 [2] 회복")
            when(readln()){
                "1" -> programmer.attack(monster)
                "2" -> (programmer as Programmer).heal()
            }
            if(monster.hp == 0){
                println("${monster.job}을(를) 물리쳤습니다.")
                throw Exception("전투 종료")
            }
        }
        
        fun battleMonster(){
            monster.attack(programmer)
            if(programmer.hp == 0){
                throw Exception("[전투 종료] 유저가 전투 불능 상태가 되어 들것에 실려갑니다.")
            }
        }
        val firstAttack = SecureRandom().nextInt(2) + 1
        while (true){
            try{
                if(firstAttack % 2 == 0){
                    // 프로그래머가 선공
                    battleUser()
                    battleMonster()
                }else{
                    // 몬스터가 선공
                    battleMonster()
                    battleUser()
                }
            }catch (e: Exception){
                println(e.message)
                break
            }
        }
    }

    private fun goDungeon(programmer: Unit){
        println("던전에 입장합니다.")
        val monster = monsters.random()
        println("${monster.job} 등장!")
        println(monster)
        println("[1] 전투 [2] 도망")
        when(readln()){
            "1" -> battle(programmer, monster.copy())
            "2" -> if ((programmer.luk - monster.luk) * SecureRandom().nextInt(1,30) > 50){
                    println("도망쳤습니다.")
                }else{
                    println("도망치는 것에 실패했습니다. 전투를 실행합니다.")
                    battle(programmer, monster.copy())
            }
        }
    }

    fun run(){
        """
            특이하게도 이 던전에는 프로그래머만 들어갈 수 있으며,
            디지털 몬스터와 키보드로 배틀을 하게 됩니다.
            던전을 탐험하고 귀환 아이템을 손에 얻으세요!
        """.trimIndent().forEach {
            print(it)
            Thread.sleep(20)
        }
        val programmer = createCharacter()
        println("${programmer.job} 생성!")
        println(programmer)
        while(true){
            println("===========================")
            println("[1] 던전탐험 [2] 휴식 [그 외] 종료")
            when(readln()){
                "1" -> goDungeon(programmer)
                "2" -> (programmer as Programmer).heal()
                else -> break
            }
        }
    }
}

fun main(){
    Game().run()
}