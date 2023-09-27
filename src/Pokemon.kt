
open class Pokemon(private var name: String = "Ditto", private var lvl: Int = 1, val gender: String, val pokedexId: Int, var attacks: MutableList<Attacke>) {
    open var init: Int = 0
    open var atk: Int = 0
    open var def: Int = 0
    open var spAtk: Int = 0
    open var spDef: Int = 0
    open var pokemonTypen: List<Types> = listOf(Types.Normal)
    var gegner: Pokemon? = null
    open var maxHealth = 0

    fun getName(): String{
        return this.name
    }
    protected fun getLevel(): Int{
        return this.lvl
    }
    protected fun increaseLevel(){
        lvl += 1
    }

    protected fun setName(newName: String) {
        this.name = newName
    }

    open fun showPokemonInfo(){

    }

    open fun setXP(value: Int){

    }

    open fun setKP(value: Int){

    }
    open fun getHealth(): Int{
        return 0
    }
}