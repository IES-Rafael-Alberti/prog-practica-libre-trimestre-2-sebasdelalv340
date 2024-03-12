fun limpiarConsola() {
    for (i in 1..100) {
        println()
    }
}

fun main() {
    val gestorEntrenamiento = GestorEntrenamiento()
    val gestorInformacion = GestorInfoEntrenamiento()
    val registroUsuario = RegistroUsuario()
    val controlMenu = ControlMenu()

    controlMenu.controlMenus(registroUsuario, gestorEntrenamiento, gestorInformacion)

}