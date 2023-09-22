import kotlin.math.roundToInt
@Suppress("UNUSED")

class Glumanda(name: String, lvl: Int, gender: String, private var cEvo: Int, private var isWild: Boolean, private var pokedexId: Int): Pokemon(name, lvl, gender){
    private val maxEvo = pokedex[this.pokedexId]?.get("MaxEvo").toString().toInt()
    private val nextEvo = pokedex[this.pokedexId]?.get("NextEvo")
    val pokemonTypen = pokedex[this.pokedexId]?.get("Types")
    private val maxKp = (10 + (2 * lvl)) * cEvo
    private val kp = this.maxKp
    private val atk = (5 + (1 * lvl)) * cEvo
    private val def = (5 + (1 * lvl)) * cEvo
    private val spAtk = (5 + (1 * lvl)) * cEvo
    private val spDef = (5 + (1 * lvl)) * cEvo
    private val init = (5 + (1 * lvl)) * cEvo

    lateinit var gegner: Pokemon
    private val maxXP: Int = 10 * lvl
    private var xp: Int = 0
        set(value){
            field += value
            checkXP()
        }
    private var xpReward: Int = setXpReward()

    val maxHealth = this.maxKp
    private var health = this.kp
        set(value){
            field += value
            checkKP()
        }

    private fun checkKP(){
        if (health <= 0) {
            beated()
        }
    }

    private fun beated(){
//        gegner.setXP(this.xpReward)
    }

    fun setXP(value: Int){
        this.xp = value
    }

    private fun checkXP(){
        if (this.xp >= this.maxXP) {
            levelUp()
        }
    }
    private fun setXpReward(): Int {
        return if (this.isWild) {
            10 * this.getLevel()
        } else {
            ((10 * this.getLevel()) * 1.40).roundToInt()
        }
    }
    private fun levelUp(){
        this.increaseLevel()
        println("${this.getName()} hat level ${this.getLevel()} erreicht")
        if (this.getLevel() >= 15 && this.cEvo < 2 && this.maxEvo > 1){
            this.evolve()
        } else if (this.getLevel() >= 32 && this.cEvo < 3 && this.maxEvo > 1) {
            this.evolve()
        }
    }
    private fun evolve(){
        val previousName = this.getName()
        this.setName(pokedex[this.nextEvo]?.get("Name").toString())
        println("Glückwunsch! $previousName hat sich zu ${this.getName()} entwickelt!")
    }
}
