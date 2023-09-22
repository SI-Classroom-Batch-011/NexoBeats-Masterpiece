var playerName: String = ""

fun dialoge(szene: String, dialogs: MutableList<String>){
    for (text in dialogs) {
        val formatted = text.replace("@", playerName)
        if (dialogs.indexOf(text) == 4 && szene == "Szene1") {
            print("\r$formatted")
            readln()
        } else if (dialogs.indexOf(text) == 3 && szene == "Szene1") {
            print("\r$formatted")
            print("\nWie Heißt du: ")
            playerName = readln()
        } else {
            print("\r$formatted")
            if ("ü" in readln()) { //überspringen mit ü
                break
            }
        }
    }
}

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
)

fun main() {
    dialoge("Szene1", dialogScenes["Szene1"]!!)
    dialoge("Szene2", dialogScenes["Szene2"]!!)
    dialoge("Szene3", dialogScenes["Szene3"]!!)
}