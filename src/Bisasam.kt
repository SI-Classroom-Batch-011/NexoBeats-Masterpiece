import kotlin.math.roundToInt
@Suppress("UNUSED", "UNCHECKED_CAST")

class Bisasam(name: String, lvl: Int, gender: String, private var cEvo: Int, private var isWild: Boolean, pokedexId: Int, attacks: MutableList<Attacke>): Pokemon(name, lvl, gender, pokedexId, attacks){
    private val maxEvo = pokedex[this.pokedexId]?.get("MaxEvo").toString().toInt()
    private val nextEvo = pokedex[this.pokedexId]?.get("NextEvo")
    override var pokemonTypen: List<Types> = pokedex[this.pokedexId]?.get("Types") as List<Types>
    private val maxKp = (10 + (5 * lvl)) * cEvo
    private val kp = this.maxKp
    override var atk = (2 + (1 * lvl)) * cEvo
    override var def = (1 + (1 * lvl)) * cEvo
    override var spAtk = (2 + (1 * lvl)) * cEvo
    override var spDef = (1 + (1 * lvl)) * cEvo
    override var init = (2 + (1 * lvl)) * cEvo

    private val maxXP: Int = 10 * lvl
    private var xp: Int = 0
        set(value){
            field += value
            checkXP()
        }
    private var xpReward: Int = setXpReward()

    override var maxHealth = this.maxKp
    private var health = this.kp
        set(value){
            field += value
            checkKP()
        }

    override fun showPokemonInfo(){
        println("""$blueBG$whiteFG----------[${if ("w" in this.gender.lowercase()) { "♀" }else if ("m" in this.gender.lowercase()){"♂"} else{"nA"}} ${this.getName()} lvl.${this.getLevel()}]----------$greenBG 
        KP           $whiteBG$blackFG    ${this.maxKp}/${this.kp}    $greenBG$whiteFG
        Atk.         $whiteBG$blackFG    ${this.atk}    $greenBG$whiteFG
        Def.         $whiteBG$blackFG    ${this.def}    $greenBG$whiteFG
        Sp. Atk.     $whiteBG$blackFG    ${this.spAtk}    $greenBG$whiteFG
        Sp. Def.     $whiteBG$blackFG    ${this.spDef}    $greenBG$whiteFG
        Init.        $whiteBG$blackFG    ${this.init}    $greenBG$whiteFG
        $blueBG$whiteFG--------------------------------------------------$resetBG$resetFG""".trimIndent())
    }
    private fun checkKP(){
        if (health <= 0) {
            beated()
        }
    }

    private fun beated(){
        val neuerGegner = this.gegner
        if (neuerGegner != null) {
            println(this.getName() + " wurde von " + neuerGegner.getName() + " besiegt!")
            neuerGegner.setXP(this.xpReward)
            println(neuerGegner.getName() + " Erhält " + this.xpReward + " Erfahrungspunkte durch den sieg an " + this.getName())
            this.gegner = null
        }
    }


    override fun setXP(value: Int){
        this.xp = value
    }

    override fun setKP(value: Int) {
        this.health = value
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

    override fun getHealth(): Int {
        return health
    }
}