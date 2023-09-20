enum class Types{
    Elektro {
        override fun getStrengths(): MutableList<Types> = mutableListOf(Wasser, Flug)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Drache, Pflanze, this)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf(Boden)
    },
    Feuer{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Pflanze, Kaefer, Stahl, Eis)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(this, Wasser, Gestein, Drache)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Wasser{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Feuer, Boden, Gestein)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(this, Pflanze, Drache)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Flug{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Pflanze, Kampf, Kaefer)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Elektro, Gestein, Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Gestein{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Feuer, Eis, Flug, Kaefer)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Kampf, Boden, Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Boden{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Feuer, Elektro, Gift, Gestein, Stahl)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Pflanze, Kaefer)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf(Flug)
    },
    Pflanze{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Wasser, Boden, Gestein)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Feuer, Pflanze, Gift, Flug, Kaefer, Drache, Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Geist{
        override fun getStrengths(): MutableList<Types> = mutableListOf(this, Psycho)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Unlicht, Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf(Normal)
    },
    Fee{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Kampf, Drache, Unlicht)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Feuer, Gift, Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Normal{
        override fun getStrengths(): MutableList<Types> = mutableListOf()
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Gestein, Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf(Geist)
    },
    Gift{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Pflanze, Fee)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(this, Boden, Gestein, Geist)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf(Stahl)
    },
    Kaefer{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Pflanze, Psycho, Unlicht)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Feuer, Kampf, Gift, Flug, Geist, Stahl, Fee)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Drache{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Drache)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf(Fee)
    },
    Unlicht{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Psycho, Geist)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Kampf, this, Stahl, Fee)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Stahl{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Eis, Gestein, Fee)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Feuer, Wasser, this)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    },
    Psycho{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Kampf, Gift)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(this, Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf(Unlicht)
    },
    Kampf{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Normal, Eis, Gestein, Unlicht, Stahl)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Gift, Flug, Psycho, Kaefer, Fee)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf(Geist)
    },
    Eis{
        override fun getStrengths(): MutableList<Types> = mutableListOf(Pflanze, Boden, Flug, Drache)
        override fun getWeaknesses(): MutableList<Types> = mutableListOf(Feuer, Wasser, this, Stahl)
        override fun getIneffectiveness(): MutableList<Types> = mutableListOf()
    };

    abstract fun getStrengths(): MutableList<Types>
    abstract fun getWeaknesses(): MutableList<Types>
    abstract fun getIneffectiveness(): MutableList<Types>
}