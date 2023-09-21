var playerName: String = ""

val dialogScenes = mutableMapOf(
    "Szene1" to listOf(
        "[Mysteriöser Mann]: Hallo Abenteurer! Wenn ich mich vorstellen darf, ich bin Prof. Eich.",
        "[Prof. Eich]: In diese Welt in der wir reisen gibt es eine unzählige art verschiedener Pokémon.",
        "[Prof. Eich]: Lass mich dich also mitnehmen in die Wundervolle welt der Pokémon.",
        "[Prof. Eich]: Zunächst möchte ich aber gerne wissen wie du heißt.",
        "[Prof. Eich]: Du heißt also ",
        "[Prof. Eich]: Was ein Schöner Name, also dann lass uns in die Wunderschöne welt der Pokemon eintauchen."),
)
fun main() {
    dialoge("Szene1")
}

fun dialoge(szene: String){

    for (text in dialogScenes[szene]!!){
        if (dialogScenes[szene]?.indexOf(text) == 4) {
            println(text + playerName + ".")
        }
    }
}