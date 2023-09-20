fun main() {
    Types.entries.forEach {
        println("------->$it<-------")
        println("$it ist effektive gegen "+ it.getStrengths())
        println("$it ist Schwach gegen "+it.getWeaknesses())
        println("$it ist nicht Wirksam gegen "+it.getIneffectiveness())
        println()
    }
}