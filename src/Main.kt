@Suppress("UNUSED")

val pokedex = mapOf(
    1 to mapOf(
        "Name" to "Bisasam",
        "NextEvo" to 2,
        "Types" to listOf(Types.Pflanze, Types.Gift),
        "MaxEvo" to 3
    ),
    2 to mapOf(
        "Name" to "Bisaknosp",
        "Prodecessor" to 1,
        "NextEvo" to 3,
        "Types" to listOf(Types.Pflanze, Types.Gift),
        "MaxEvo" to 3
    ),
    3 to mapOf(
        "Name" to "Bisaflor",
        "Prodecessor" to 2,
        "Types" to listOf(Types.Pflanze, Types.Gift),
        "MaxEvo" to 3
    ),
    4 to mapOf(
        "Name" to "Glumanda",
        "NextEvo" to 5,
        "Types" to listOf(Types.Feuer),
        "MaxEvo" to 3
    ),
    5 to mapOf(
        "Name" to "Glutexo",
        "Prodecessor" to 4,
        "NextEvo" to 6,
        "Types" to listOf(Types.Feuer),
        "MaxEvo" to 3
    ),
    6 to mapOf(
        "Name" to "Glurak",
        "Prodecessor" to 5,
        "Types" to listOf(Types.Feuer, Types.Flug),
        "MaxEvo" to 3
    ),
    7 to mapOf(
        "Name" to "Schiggy",
        "NextEvo" to 8,
        "Types" to listOf(Types.Wasser),
        "MaxEvo" to 3,
    ),
    8 to mapOf(
        "Name" to "Schillok",
        "Prodecessor" to 7,
        "NextEvo" to 9,
        "Types" to listOf(Types.Wasser),
        "MaxEvo" to 3
    ),
    9 to mapOf(
        "Name" to "Turtok",
        "Prodecessor" to 8,
        "Types" to listOf(Types.Wasser),
        "MaxEvo" to 3
    )
)

val player = Player()

fun dialoge(szene: String, dialogs: MutableList<String>){
    for (text in dialogs) {
        val formatted = text.replace("@", player.name)
        if (dialogs.indexOf(text) == 4 && szene == "Szene1") {
            print("\r$formatted")
            readln()
        } else if (dialogs.indexOf(text) == 3 && szene == "Szene1") {
            print("\r$formatted")
            print("\nWie Heißt du: ")
            player.name = readln()
        } else {
            print("\r$formatted")
            if ("ü" in readln()) { //überspringen mit ü
                break
            }
        }
    }
}

val starterPokemon = mutableListOf(
    Bisasam("Bisasam", 5, listOf("Weiblich", "Männlich").random(), 1, false, 1),
    Glumanda("Glumanda", 5, listOf("Weiblich", "Männlich").random(), 1, false, 4),
    Schiggy("Schiggy", 5, listOf("Weiblich", "Männlich").random(), 1, false, 7)
)

val dialogScenes: MutableMap<String, MutableList<String>> = mutableMapOf(
    "Szene1" to mutableListOf(
        "[Mysteriöser Mann]: Hallo Abenteurer! Wenn ich mich vorstellen darf, ich bin Prof. Eich.",
        "[Prof. Eich]: In diese Welt in der wir reisen gibt es eine unzählige art verschiedener Pokémon.",
        "[Prof. Eich]: Lass mich dich also mitnehmen in die Wundervolle welt der Pokémon.",
        "[Prof. Eich]: Zunächst möchte ich aber gerne wissen wie du heißt.",
        "[Prof. Eich]: Du heißt also @ was ein schöner Name.",
        "[Prof. Eich]: Also dann lass uns in die Wunderschöne welt der Pokemon eintauchen."),
    "Szene2" to mutableListOf(
        "[Mutter]: SCHATZ DU KOMMST NOCH ZU SPÄT WENN DU NICHT AUFSTEHST!",
        "@ *geht die Treppe herunter*",
        "[Mutter]: Da bist du ja mein Schatz deine Freunde warten doch schon draußen auf dich.",
        "[Mutter]: Aber bevor du gehst nimm doch noch die 3 Dinge mit",
        "@ *hat ein paar Laufschuhe erhalten und hat sie in seinen Beutel verstaut*",
        "@ *hat ein Pokedex erhalten und hat ihn in seinen Beutel verstaut*",
        "@ *hat ein paar Beeren und hat sie in seinen Beutel verstaut*",
        "[Mutter]: Deine Freunde warten draußen auf dich, lass sie nicht all zu lange warten."),
    "Szene3" to mutableListOf(
        "[Daniel]: Hey, man wo warst du so lange wir warten hier schon eine Ewigkeit.",
        "[Marlene]: Daniel, lass @ einfach in ruhe. Er hat doch gerade erst ein Umzug hinter sich.",
        "[Daniel]: Ja schon klar, tut mir leid @ aber ich freu mich schon wir bekommen doch heute unsere Pokemon.",
        "[Marlene]: Nun gut, lass uns gemeinsam zu Prof. Eich gehen.",
        "*Ihr geht zu Prof. Eich's Labor*"),
    "Szene4" to mutableListOf(
        "*Ihr Betretet das Labor von Prof. Eich.*",
        "[Daniel]: Woah wie cool sieht es denn hier aus...",
        "[Prof. Eich]: Das bringen nun mal eine Große anzahl von Forschungen mit sich.",
        "[Prof. Eich]: Ihr wollt euch heute also euer Pokemon aussuchen und euer Abenteuer starten?",
        "[Ihr]: Ja wir freuen uns schon Mega auf unser Abenteuer!",
        "[Prof. Eich]: ALSO DANN! Lasst uns zu dem Inkubator gehen und ihr könnt euch euer Pokemon aussuchen. \n[Prof. Eich]: Ich bin mir sicher, dass sie bald Schlüpfen werden.",
        "*Ihr tretet gemeinsam mit Prof. Eich vor dem Inkubator und Prof. Eich öffnet diesen.*",
        "[Prof. Eich]: Also wer möchte sich zuerst ein aussuchen?",
        "[Daniel und Marlene]: @, er hat gerade sowieso einen Umzug hinter sich, sie es als Willkommensgeschenk!",
        "[Prof. Eich]: Also Gut, Welches Pokemon soll es sein?",
    ),
)


fun listStarter() {
    println("Welches Pokemon wählst du?")
    for (pokemon in starterPokemon) {
        val pokemonType = pokedex[pokemon.pokedexId]?.get("Types")
        val textColor = when {
            Types.Wasser in enumValues<Types>() -> blueFG
            Types.Pflanze in enumValues<Types>() -> greenFG
            Types.Feuer in enumValues<Types>() -> brightRedFG
            else -> resetFG
        }
        println("$magentaFG${starterPokemon.indexOf(pokemon) + 1}. $textColor${pokemon.getName()}$resetFG")
    }
}

fun main() {
    dialoge("Szene1", dialogScenes["Szene1"]!!)
    dialoge("Szene2", dialogScenes["Szene2"]!!)
    dialoge("Szene3", dialogScenes["Szene3"]!!)
    dialoge("Szene4", dialogScenes["Szene4"]!!)

    listStarter()


}