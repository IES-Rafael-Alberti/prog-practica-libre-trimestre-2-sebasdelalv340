package Gestores

import Consola.Consola
import Usuario.TipoGenero
import Usuario.Usuario

/**
 * Clase que gestiona el registro de usuarios y operaciones relacionadas con los usuarios.
 * @property registroUsuarios Lista mutable de usuarios registrados.
 */
class RegistroUsuario(private var registroUsuarios: MutableList<Usuario> = mutableListOf()) {

    companion object {
        // Almacena los nombres de los usuarios registrados para evitar duplicados.
        var registroNombresUsuarios = mutableSetOf<String>()
    }

    /**
     * Comprueba si el nombre de usuario ya existe en el registro.
     * @param nombre El nombre de usuario a comprobar.
     * @return true si el nombre de usuario ya existe, false de lo contrario.
     */
    private fun comprobarUsuario(nombre: String): Boolean {
        val nombreAComprobar = nombre.trim()
        return if (registroNombresUsuarios.contains(nombreAComprobar)) {
            true
        } else {
            registroNombresUsuarios.add(nombreAComprobar)
            false
        }
    }

    /**
     * Solicita al usuario ingresar su nombre.
     * @return El nombre ingresado por el usuario.
     */
    private fun pedirNombreUsuarioRegistrado(): String {
        Consola.enviar("Introduzca su nombre: ")
        return Consola.leerString().lowercase().trim()
    }

    /**
     * Solicita al usuario nuevo ingresar su nombre.
     * @return El nombre ingresado por el usuario.
     */
    private fun pedirNombreUsuarioNuevo(): String {
        var nombre = ""
        var continuar = true
        do {
            Consola.enviar("Introduzca su nombre: ")
            try {
                nombre = readln().lowercase().trim()
                if (comprobarUsuario(nombre)) {
                    Consola.enviar("El nombre ya existe.\n")
                } else {
                    continuar = false
                }
            } catch (e: IllegalArgumentException) {
                Consola.enviar("El número introducido no es una opción válida.\n")
            }
        } while (continuar)
        return nombre
    }

    /**
     * Solicita el género del usuario.
     * @return TipoGenero El tipo de sexo del usuario.
     */
    private fun pedirGenero(): TipoGenero {
        var genero: TipoGenero = TipoGenero.MUJER
        var sexo: String
        var continuar = true
        do {
            Consola.enviar("Sexo (H/M): ")
            try {
                sexo = readln().uppercase()
                if (sexo == "H") {
                    genero = TipoGenero.HOMBRE
                    continuar = false
                } else if (sexo == "M") {
                    genero = TipoGenero.MUJER
                    continuar = false
                }
            } catch (e: IllegalArgumentException) {
                Consola.enviar("La entrada introducida no es una opción válida.\n")
            }
        } while (continuar)
        return genero
    }

    /**
     * Solicita la edad del usuario
     * @return edad Un número entero que corresponde a la edad.
     */
    private fun pedirEdad(): Int {
        var continuar = true
        var edad = 0
        do {
            Consola.enviar("Edad: ")
            try {
                edad = readln().toInt()
                continuar = false
            } catch (e: NumberFormatException) {
                Consola.enviar("El número introducido no es una opción válida.\n")
            }
        } while (continuar)
        return edad
    }

    /**
     * Solicita la altura en centímetros al usuario.
     * @return altura Un número entero que corresponde a la altura.
     */
    private fun pedirAltura(): Int {

        var continuar = true
        var altura = 0
        do {
            Consola.enviar("Altura (cm): ")
            try {
                altura = readln().toInt()
                continuar = false
            } catch (e: NumberFormatException) {
                Consola.enviar("La entrada introducida no es una opción válida.\n")
            }
        } while (continuar)
        return altura
    }

    /**
     * Solicita el peso en kilogramos al usuario.
     * @return peso Un número con decimales que corresponde al peso.
     */
    private fun pedirPeso(): Double {
        var continuar = true
        var altura = 0.0
        do {
            Consola.enviar("Peso (kg): ")
            try {
                altura = readln().toDouble()
                continuar = false
            } catch (e: NumberFormatException) {
                Consola.enviar("La entrada introducida no es una opción válida.\n")
            }
        } while (continuar)
        return altura
    }

    /**
     * Solicita la contraseña al usuario.
     * @return pass Un número entero que corresponde a la contraseña.
     */
    private fun pedirPassword(): Int {
        var continuar = true
        var pass = 0
        do {
            Consola.enviar("Contraseña (6 dígitos): ")
            try {
                pass = readln().toInt()
                if (pass.toString().length != 6) {
                    Consola.enviar("La contraseña debe tener 6 dígitos.\n")
                } else {
                    continuar = false
                }
            } catch (e: NumberFormatException) {
                Consola.enviar("La entrada introducida no es una opción válida.\n")
            }
        } while (continuar)
        return pass
    }

    /**
     * Solicita la contraseña dos veces.
     * @return pass1 La contraseña si son iguales.
     */
    private fun pedirPasswordNueva(): Int {
        var continuar = true
        var pass1 = 0
        var pass2 = 0
        do {
            do {
                Consola.enviar("Contraseña (6 dígitos): ")
                try {
                    pass1 = readln().toInt()
                    if (pass1.toString().length != 6) {
                        Consola.enviar("La contraseña debe tener 6 dígitos.\n")
                    } else {
                        continuar = false
                    }
                } catch (e: NumberFormatException) {
                    Consola.enviar("El número introducido no es una contraseña válida.\n")
                }
            } while (continuar)

            do {
                Consola.enviar("Repite la contraseña (6 dígitos): ")
                try {
                    pass2 = readln().toInt()
                    if (pass2.toString().length != 6) {
                        Consola.enviar("La contraseña debe tener 6 dígitos.\n")
                    } else {
                        continuar = false
                    }
                } catch (e: NumberFormatException) {
                    Consola.enviar("La contraseña es distinta.\n")
                }
            } while (continuar)

            continuar = if (pass1 == pass2) {
                false
            } else {
                true
            }
        } while (continuar)
        return pass1
    }

    /**
     * Realiza el proceso de inicio de sesión del usuario.
     * @return El usuario que ha iniciado sesión, o null si no se encontró ningún usuario.
     */
    fun loginUsuario(): Usuario? {
        Consola.enviar("\n* Login *\n")
        val usuario = buscarUsuario(pedirNombreUsuarioRegistrado(), pedirPassword())
        if (usuario != null){
            return usuario
        } else {
            Consola.enviar("Usuario no registrado.\n")
            null
        }
        return null
    }

    /**
     * Registra un nuevo usuario.
     * @return El usuario registrado.
     */
    fun registrarUsuario(): Usuario {
        Consola.enviar("\n* NUEVO USUARIO *\n")
        val nombre = pedirNombreUsuarioNuevo()
        val pass = pedirPasswordNueva()
        val sexo = pedirGenero()
        val edad = pedirEdad()
        val altura = pedirAltura()
        val peso = pedirPeso()
        val user = Usuario(nombre, sexo, edad, altura, peso, pass)
        registroUsuarios.add(user)
        return user
    }

    /**
     * Busca un usuario registrado por su nombre y contraseña.
     * @param nombre El nombre de usuario a buscar.
     * @param pass La contraseña del usuario a buscar.
     * @return El usuario encontrado, o null si no se encontró ningún usuario con los datos proporcionados.
     */
    fun buscarUsuario(nombre: String, pass: Int): Usuario? {
        return registroUsuarios.find { it.nombre == nombre && it.password == pass }
    }

    /**
     * Elimina un usuario registrado.
     */
    fun eliminarUsuario() {
        val usuarioEliminar = buscarUsuario(pedirNombreUsuarioRegistrado(), pedirPassword())
        if (usuarioEliminar != null) {
            registroUsuarios.remove(usuarioEliminar)
            Consola.enviar("Usuario eliminado.\n")
        } else {
            Consola.enviar("No se encontrado ningún usuario.\n")
        }
    }
}