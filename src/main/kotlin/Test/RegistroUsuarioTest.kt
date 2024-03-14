package Test

import Gestores.RegistroUsuario
import Usuario.TipoGenero
import Usuario.Usuario
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class RegistroUsuarioTest {

    @Test
    fun buscarUsuario() {
        val usuario1 = Usuario("Pedro", TipoGenero.HOMBRE, 30, 180, 80.0, 123456)
        val usuario2 = Usuario("Maria", TipoGenero.MUJER, 25, 168, 60.0, 345276)
        val usuario3 = Usuario("Jose", TipoGenero.HOMBRE, 40, 176, 75.0, 769467)
        val listaUsuarios = mutableListOf(usuario1, usuario2, usuario3)
        val registroUsuario = RegistroUsuario(listaUsuarios)
        val usuarioEncontrado = registroUsuario.buscarUsuario("Pedro", 123456)

        assertEquals(usuario1, usuarioEncontrado)
    }
}