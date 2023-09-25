import java.sql.RowId

open class Pokemon(private var name: String = "Ditto", private var lvl: Int = 1, val gender: String, val pokedexId: Int) {
    fun getName(): String{
        return this.name
    }
    protected fun getLevel(): Int{
        return this.lvl
    }
    protected fun increaseLevel(){
        lvl += 1
    }

    protected fun setName(newName: String){
        this.name = newName
    }

}