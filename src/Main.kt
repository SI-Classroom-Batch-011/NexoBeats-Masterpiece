@file:Suppress("UNCHECKED_CAST")
import kotlin.Exception

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

fun validUserInput(input: String): String{
    val regex = Regex("[a-zA-Z]+")
    if (!regex.matches(input)){
        throw Exception("Deine Eingabe darf nicht leer sein!")
    }
    else return input
}

val player = Player()

fun dialoge(szene: String, dialogs: MutableList<String>){
    for (text in dialogs) {
        val formatted = text.replace("@", player.name)
        if (dialogs.indexOf(text) == 4 && szene == "Szene1") {
            print("\r$formatted")
            readln()
        } else if (dialogs.indexOf(text) == 3 && szene == "Szene1") {
            print("\r$formatted")
            var input = ""
            do {
                print("\n${resetFG}Wie Heißt du: ")
                try {
                    input = validUserInput(readln())
                    player.name = input
                } catch (e: Exception) {
                    println("$redFG${e.message}")
                }
            }while (!input.contains(Regex("[a-zA-Z]+")))
        } else {
            print("\r$formatted")
            if ("ü" in readln()) { //überspringen mit ü
                break
            }
        }
    }
}

val starterPokemon = mutableListOf(
    Bisasam(pokedex[1]?.get("Name") as String, 5, listOf("Weiblich", "Männlich").random(), 1,  false, 1, mutableListOf(Tackle(35, 50))),
    Glumanda(pokedex[4]?.get("Name") as String, 5, listOf("Weiblich", "Männlich").random(), 1,  false, 4, mutableListOf(Tackle(35, 50))),
    Schiggy(pokedex[7]?.get("Name") as String, 5, listOf("Weiblich", "Männlich").random(), 1, false, 7, mutableListOf(Tackle(35, 50)))
)

val dialogScenes: MutableMap<String, MutableList<String>> = mutableMapOf(
    "Szene1" to mutableListOf(
        "${blueFG}[Mysteriöser Mann]${resetFG}: ${greenFG}Hallo Abenteurer${resetFG}! ${greenFG}Wenn ich mich vorstellen darf, ich bin ${blueFG}Prof. Eich${resetFG}.",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}In diese Welt in der wir reisen gibt es eine unzählige art verschiedener Pokémon${resetFG}.",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Lass mich dich also mitnehmen in die Wundervolle welt der Pokémon${resetFG}.",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Zunächst möchte ich aber gerne wissen wie du heißt${resetFG}.",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Du heißt also $redFG@ ${greenFG}was ein schöner Name${resetFG}.",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Also dann lass uns in die Wunderschöne welt der Pokemon eintauchen${resetFG}."),
    "Szene2" to mutableListOf(
        "${blueFG}[Mutter]${resetFG}: ${greenFG}SCHATZ DU KOMMST NOCH ZU SPÄT WENN DU NICHT AUFSTEHST${resetFG}!",
        "$redFG@ $whiteFG*${resetFG}geht die Treppe herunter$whiteFG*${resetFG}",
        "${blueFG}[Mutter]${resetFG}: ${greenFG}Da bist du ja mein Schatz deine Freunde warten doch schon draußen auf dich${resetFG}.",
        "${blueFG}[Mutter]${resetFG}: ${greenFG}Aber bevor du gehst nimm doch noch die 3 Dinge mit${resetFG}.",
        "$redFG@ $whiteFG*${resetFG}hat ein paar ${yellowFG}Laufschuhe${resetFG} erhalten und hat sie in seinen Beutel verstaut$whiteFG*${resetFG}",
        "$redFG@ $whiteFG*${resetFG}hat ein ${yellowFG}Tagebuch${resetFG} erhalten und hat ihn in seinen Beutel verstaut$whiteFG*${resetFG}",
        "$redFG@ $whiteFG*${resetFG}hat ein paar ${yellowFG}Beeren${resetFG} und hat sie in seinen Beutel verstaut$whiteFG*${resetFG}",
        "${blueFG}[Mutter]${resetFG}: ${greenFG}Deine Freunde warten draußen auf dich, lass sie nicht all zu lange warten${resetFG}."),
    "Szene3" to mutableListOf(
        "${blueFG}[Daniel]${resetFG}: ${greenFG}Hey, man wo warst du so lange wir warten hier schon eine Ewigkeit${resetFG}.",
        "${blueFG}[Marlene]${resetFG}: ${blueFG}Daniel${greenFG}, lass $redFG@ ${greenFG}einfach in ruhe. Er hat doch gerade erst ein Umzug hinter sich${resetFG}.",
        "${blueFG}[Daniel]${resetFG}: ${greenFG}Ja schon klar, tut mir leid $redFG@ ${greenFG}aber ich freu mich schon wir bekommen doch heute unsere Pokemon${resetFG}.",
        "${blueFG}[Marlene]${resetFG}: ${greenFG}Nun gut, lass uns gemeinsam zu ${blueFG}Prof. Eich ${greenFG}gehen${resetFG}.",
        "$whiteFG*${resetFG}Ihr geht zu ${blueFG}Prof. Eich's${resetFG} Labor$whiteFG*${resetFG}"),
    "Szene4" to mutableListOf(
        "$whiteFG*${resetFG}Ihr Betretet das Labor von ${blueFG}Prof. Eich${resetFG}.$whiteFG*${resetFG}",
        "${blueFG}[Daniel]${resetFG}: ${greenFG}Woah wie cool sieht es denn hier aus${resetFG}...",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Das bringen nun mal eine Große anzahl von Forschungen mit sich${resetFG}.",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Ihr wollt euch heute also euer Pokemon aussuchen und euer Abenteuer starten${resetFG}?",
        "${blueFG}[Ihr]${resetFG}: ${greenFG}Ja wir freuen uns schon Mega auf unser Abenteuer${resetFG}!",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}ALSO DANN! Lasst uns zu dem ${yellowFG}Inkubator ${greenFG}gehen und ihr könnt euch euer Pokemon aussuchen$resetFG. \n${blueFG}[Prof. Eich]$resetFG: ${greenFG}Ich bin mir sicher, dass sie bald Schlüpfen werden${resetFG}.",
        "$whiteFG*${resetFG}Ihr tretet gemeinsam mit ${blueFG}Prof. Eich ${resetFG}vor dem ${yellowFG}Inkubator ${resetFG}und ${blueFG}Prof. Eich ${resetFG}öffnet diesen.$whiteFG*${resetFG}",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Also wer möchte sich zuerst ein aussuchen${resetFG}?",
        "${blueFG}[Daniel und Marlene]${resetFG}: $redFG@${greenFG}, er hat gerade sowieso einen Umzug hinter sich, sie es als Willkommensgeschenk$resetFG!",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Also Gut $redFG@${greenFG}, Welches Pokemon soll es sein$resetFG?"),
    "Szene5" to mutableListOf(
        "${blueFG}[Marlene]$resetFG: ${greenFG}Mein Pokemon ist sooo Süß$resetFG!",
        "${blueFG}[Daniel]$resetFG: ${greenFG}Mein Pokemon wird euch alle besiegen$resetFG! ${greenFG}>:D$resetFG",
        "${blueFG}[Prof. Eich]$resetFG: ${greenFG}Wenn ihr eure Pokemon mal gegeneinander kämpfen lassen wollt, wir haben gleich hier eine Arena$resetFG.",
        "${blueFG}[Ihr]$resetFG: ${greenFG}Ja wir wollen unbedingt mal ausprobieren wie so ein Pokemon kampf abläuft$resetFG!",
        "${blueFG}[Prof. Eich]$resetFG: ${greenFG}Dann folgt mir mal bitte$resetFG.",
        "$whiteFG*${resetFG}Ihr Folgt ${blueFG}Prof. Eich ${resetFG}in die Labor Arena$whiteFG*$resetFG",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Wer sind die ersten beiden gegner${resetFG}?",
        "${blueFG}[Daniel]$resetFG: ${greenFG}Ich und $redFG@${greenFG}, was sagst du dazu${resetFG}? ${greenFG}ist das nicht eine gute idee$resetFG?",
        "${blueFG}[Marlene]$resetFG: ${greenFG}Ich finde auch das ist ein gute idee, keine sorge den gewinner werde ich wieder aufpäppeln damit es fair bleibt$resetFG.",
        "$whiteFG*$redFG@ ${resetFG}und ${blueFG}Daniel$resetFG gehen an ihre Positionen$whiteFG*$resetFG",
        "${blueFG}[Prof. Eich]$resetFG: ${greenFG}1. Runde $redFG@ ${greenFG}gegen ${blueFG}Daniel$resetFG!"),
    "Szene6" to mutableListOf(
        "${blueFG}[Prof. Eich]${resetFG}: $redFG@ ${greenFG}hat den Kampf gewonnen${resetFG}! ${greenFG}Herzlichen Glückwunsch${resetFG}!",
        "${blueFG}[Marlene]${resetFG}: ${greenFG}Wow $redFG@${greenFG}, bist du etwa schon ein Profi${resetFG}? ${greenFG}Du hast richtig Gut gekämpft${resetFG}!",
        "${blueFG}[Marlene]${resetFG}: ${greenFG}nagut $redFG@${greenFG}, lass mich deine Pokemon eben wieder aufpeppeln${resetFG}.",
        "$whiteFG*${blueFG}Marlene ${resetFG}hat deine Pokemon geheilt$whiteFG*${resetFG}",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Der Nächste Kampf ist $redFG@ ${greenFG}gegen ${blueFG}Marlene${resetFG}.",
        "${blueFG}[Prof. Eich]${resetFG}: ${greenFG}Trainer geht an eure Plätze${resetFG}!",
        "*$redFG@ ${resetFG}und ${blueFG}Marlene ${resetFG}gehen an ihre Plätze$whiteFG*$resetFG",
        "${blueFG}[Marlene]${resetFG}: ${greenFG}Bitte tuh meinen süßen Pokemon nicht zusehr weh$resetFG!",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Keine Sorge all eure Pokemon werden nach den Kämpfen geheilt$resetFG.",
        "$blueFG[Marlene]$resetFG: ${greenFG}Puuuh :)$resetFG",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Lasst den Kampf Beginnen$resetFG!"),
    "Szene7" to mutableListOf(
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}der Kampf ist vorbei! der sieger ist $redFG@$resetFG!",
        "$blueFG[Marlene]$resetFG: ${greenFG}Mein Pokemon was ist nur mit dir passiert$resetFG!",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Keine sorge ich peppel all eure Pokemon wieder auf$resetFG.",
        "$whiteFG*${blueFG}Prof. Eich$resetFG hat eure Pokemon geheilt$whiteFG*$resetFG",
        "$blueFG[Marlene]$resetFG: ${greenFG}Danke Professor$resetFG!",
        "$blueFG[Daniel]$resetFG: ${greenFG}Ja, danke$resetFG!",
        "$whiteFG*${blueFG}Daniel${resetFG} und ${blueFG}Marlene$resetFG verlassen voreilig das Labor$whiteFG*$resetFG",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Die beiden mal wieder, sind immer auf dem Sprung$resetFG.",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Achso ja das kannst du ja nicht wissen... Ich kenn die beiden schon eine gefühlte ewigkeit$resetFG.",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Die beiden sind hier in diese Süße kleine Stadt gezogen als die beiden noch 5 Jahre alt waren$resetFG.",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Die beiden haben sich aber auch über diese zeit nicht verändert. Bitte pass mir gut auf die beiden auf$resetFG.",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Achso ich hab noch was für euch drei$resetFG.",
        "$whiteFG*${resetFG}Du hast ${greenFG}3x$resetFG einen ${yellowFG}Pokedex$resetFG erhalten$whiteFG*$resetFG",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Einer davon ist für Marlene und einer ist für Daniel. Guck nicht so, du bekommst auch einen$resetFG.",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Dieses schlaue ding kann Pokemon von einer Entfernung von bis zu 10km scannen und ihre daten erfassen$resetFG.",
        "$blueFG[Prof. Eich]$resetFG: ${greenFG}Der Pokedex kann dir dann sämtliche daten über die Pokemon geben, welches geschlecht sie haben und sogar welche davon du schon gefangen hast$resetFG!",
        "",
        "Danke fürs Spielen der DEMO von Poke${brightRedFG}mon$resetFG Syntax." +
                "\n${brightYellowFG}Credits$resetFG:" +
                "\n${magentaFG}Mitwirkende ~ Contributors$resetFG" +
                "\n${greenFG}Cristian Wietzke$resetFG mit der ${blueFG}erstellung des Farbsystems$resetFG." +
                "\n${greenFG}Gordon Lucas$resetFG mit der hilfe mit den ${blueFG}Project Modul$resetFG." +
                "\n${greenFG}Max Krass$resetFG mit der hilfe bei den ${blueFG}Nullable wert$resetFG." +
                "\n${greenFG}Anna Hoff$resetFG mit der hilfe bei den ${blueFG}Lambda's$resetFG." +
                "\n\n${magentaFG}Hauptwirkende ~ Main-coder$resetFG" +
                "\n${blueFG}Nico Merzky$resetFG mit der Programmierung an ${blueFG}der Main$resetFG, \n${blueFG}Den Pokemon$resetFG, ${blueFG}dem Recoden und bereitstellen des farbsystems ${greenFG}feat. Christian Wietzke$resetFG." +
                "\n${blueFG}Die Programmierung der Spieler$resetFG, ${blueFG}der Typen$resetFG, ${blueFG}der Readme$resetFG, ${blueFG}der Rivalen$resetFG, ${blueFG}der Attacken$resetFG." +
                "\n\nDanke an alle die daran mitgearbeitet ~ Mitgeholfen haben!")
)

fun getTextColorForPokemonTypes(pokemonTypes: List<Types>): String {
    return when {
        Types.Wasser in pokemonTypes -> blueFG
        Types.Pflanze in pokemonTypes -> greenFG
        Types.Feuer in pokemonTypes -> brightRedFG
        else -> resetFG
    }
}

fun listStarter() {
    println("Welches Pokemon wählst du?")
    for (pokemon in starterPokemon) {
        val textColor = getTextColorForPokemonTypes(pokedex[pokemon.pokedexId]?.get("Types") as List<Types>)
        println("$magentaFG${starterPokemon.indexOf(pokemon) + 1}. $textColor${pokemon.getName()}$resetFG")
    }
}

fun chooseAttack(pokemon: Pokemon): Attacke{
    var input: Int
    var choosed: Attacke? = null
    do{
        println("Welche attacke soll ${pokemon.getName()} benutzen?")
        for (attack in pokemon.attacks) {
            println("${pokemon.attacks.indexOf(attack)+1}. $whiteFG${attack.name}$resetFG")
        }
        try {
            input = readln().toInt()
            if (input <= 0) {
                throw Exception("Muss über 0 sein.")
            } else if (input > pokemon.attacks.size) {
                throw Exception("Deine eingabe ist zu hoch.")
            } else {
                choosed = pokemon.attacks[input-1]
            }
        } catch (e: Exception){
            println("Fehlerhafte eingabe: ${e.message}")
        }
    } while (choosed == null)
    return choosed
}

fun kampf(spieler: Player, rivale: Rivale){
    while (spieler.pokemon.count { it.getHealth() > 0 } > 0 && rivale.pokemon.count{it.getHealth() > 0} > 0){
        val spielerPokemon = spieler.pokemon.first{ it.getHealth() > 0 }
        val rivalenPokemon = rivale.pokemon.first{ it.getHealth() > 0 }
        spielerPokemon.gegner = rivalenPokemon
        rivalenPokemon.gegner = spielerPokemon
        if (spielerPokemon.init >= rivalenPokemon.init) {
            chooseAttack(spielerPokemon).attack(spielerPokemon)
            rivalenPokemon.attacks.random().attack(rivalenPokemon)
        } else if (rivalenPokemon.init > spielerPokemon.init) {
            rivalenPokemon.attacks.random().attack(rivalenPokemon)
            chooseAttack(spielerPokemon).attack(spielerPokemon)
        }
    }
    if (spieler.pokemon.count { it.getHealth() > 0 } > 0) {
        println(spieler.name + " hat den Kampf gewonnen!")
    } else if (rivale.pokemon.count { it.getHealth() > 0 } > 0) {
        println(spieler.name + " hat keine kampffähige Pokemon mehr, ihm wird schwarz vor augen und begibt sich zum nächsten Pokecenter.")
    }
    spieler.pokemon.forEach{it.setKP(it.maxHealth)}
    rivale.pokemon.forEach{it.setKP(it.maxHealth)}
}

fun main() {
    val daniel = Rivale("Daniel", "Männlich")
    val marlene = Rivale("Marlene", "Weiblich")

    dialoge("Szene1", dialogScenes["Szene1"]!!)
    dialoge("Szene2", dialogScenes["Szene2"]!!)
    dialoge("Szene3", dialogScenes["Szene3"]!!)
    dialoge("Szene4", dialogScenes["Szene4"]!!)

    do {
        listStarter()
        val selectedPokemon: Pokemon
        val input: Int
        try {
            input = readln().toInt() - 1
            selectedPokemon = starterPokemon.removeAt(input)
            player.pokemon.add(selectedPokemon)
            if (selectedPokemon.getName() == "Schiggy") {
                starterPokemon.forEach { if (it.getName() == "Bisasam") daniel.pokemon.add(it) else if (it.getName() == "Glumanda") marlene.pokemon.add(it) }
            } else if (selectedPokemon.getName() == "Bisasam") {
                starterPokemon.forEach { if (it.getName() == "Glumanda") daniel.pokemon.add(it) else if (it.getName() == "Schiggy") marlene.pokemon.add(it) }
            } else if (selectedPokemon.getName() == "Glumanda") {
                starterPokemon.forEach { if (it.getName() == "Schiggy") daniel.pokemon.add(it) else if (it.getName() == "Bisasam") marlene.pokemon.add(it) }
            }
        } catch (e: Exception) {
            println("Fehlerhafte eingabe: ${e.message}")
        }
    }while (player.pokemon.isEmpty())

    println("${player.name} hat das Pokemon ${player.pokemon.first().getName()} ausgewählt.")
    println("${daniel.name} hat das Pokemon ${daniel.pokemon.first().getName()} ausgewählt.")
    println("${marlene.name} hat das Pokemon ${marlene.pokemon.first().getName()} ausgewählt.")

    dialoge("Szene5", dialogScenes["Szene5"]!!)

    kampf(player, daniel)

    dialoge("Szene6", dialogScenes["Szene6"]!!)

    kampf(player, marlene)

    dialoge("Szene7", dialogScenes["Szene7"]!!)

}