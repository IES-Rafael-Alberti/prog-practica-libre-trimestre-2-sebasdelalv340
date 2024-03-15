import ControlMenus.ControlMenu
import Gestores.GestorEntrenamiento
import Gestores.GestorInfoEntrenamiento
import Gestores.RegistroUsuario



fun main() {
    val gestorEntrenamiento = GestorEntrenamiento()
    val gestorInformacion = GestorInfoEntrenamiento()
    val registroUsuario = RegistroUsuario()
    val controlMenu = ControlMenu()

    controlMenu.controlMenus(registroUsuario, gestorEntrenamiento, gestorInformacion)

}