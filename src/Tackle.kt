import kotlin.math.roundToInt

class Tackle(ap: Int, apd: Int, type: Types = Types.Normal, private var name: String = "Tackle"): Attacke(ap, apd, type) {
    private fun getEffectiveness(typ: Types): Double{
        return when (typ) {
            in this.attackTyp.getStrengths() -> 0.5
            in this.attackTyp.getWeaknesses() -> 2.0
            in this.attackTyp.getIneffectiveness() -> 0.0
            else -> 1.0
        }
    }

    override fun attack(pokemon: Pokemon) {
        val neuerGegner = pokemon.gegner
        if (neuerGegner != null) {
            if (pokemon.getHealth() > 0 && this.ap > 0) {
                val isCritical: Boolean = (1..10).random() == 5
                val pokemonTypes: List<Types> = neuerGegner.pokemonTypen
                val effectiveness: Double = getEffectiveness(pokemonTypes.first())
                val dmg = ((2 + ((0.2 * pokemon.atk) + (0.1 * apd))).roundToInt() * effectiveness).roundToInt() * if (isCritical) 4 else 1
                if (effectiveness != 1.0) {
                    println("${pokemon.getName()} setzt " + this.name + " ein!")
                    println("Es ist ${if (effectiveness == 0.5){ "nicht sehr Effektiv" } else if (effectiveness == 2.0 ){ "sehr Effektiv" } else { "Wirkungslos" }} gegen ${neuerGegner.getName()}.")
                } else {
                    println("${pokemon.getName()} setzt " + this.name + " ein!")
                }
                neuerGegner.setKP(-dmg)
                this.ap - 1
            }
        }
    }
}