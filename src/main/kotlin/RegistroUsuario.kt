class RegistroUsuario {

    private var registroUsuarios = mutableMapOf<String, Int>()

    companion object {
        var registroNombresUsuarios = mutableSetOf<String>()
    }

    private fun comprobarUsuario(nombre: String): Boolean {
        val nombreAComprobar = nombre.trim()
        return if (registroNombresUsuarios.contains(nombreAComprobar)) {
            true
        } else {
            registroNombresUsuarios.add(nombreAComprobar)
            false
        }
    }

    private fun pedirNombreUsuarioRegistrado(): String {
        Consola.enviar("Introduzca su nombre: ")
        return Consola.leerString().lowercase().trim()
    }

    private fun pedirNombreUsuarioNuevo(): String {
        var nombre = ""
        var continuar = true
        do {
            print("Introduzca su nombre: ")
            try {
                nombre = readln().lowercase().trim()
                if (comprobarUsuario(nombre)) {
                    println("El nombre ya existe.")
                } else {
                    continuar = false
                }
            } catch (e: IllegalArgumentException) {
                println("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return nombre
    }

    private fun pedirGenero(): TipoGenero {
        var genero: TipoGenero = TipoGenero.MUJER
        var sexo: String
        var continuar = true
        do {
            print("Sexo (H/M): ")
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
                println("La entrada introducida no es una opción válida.")
            }
        } while (continuar)
        return genero
    }

    private fun pedirEdad(): Int {
        var continuar = true
        var edad = 0
        do {
            print("Edad: ")
            try {
                edad = readln().toInt()
                continuar = false
            } catch (e: NumberFormatException) {
                println("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return edad
    }

    private fun pedirAltura(): Int {

        var continuar = true
        var altura = 0
        do {
            print("Altura (cm): ")
            try {
                altura = readln().toInt()
                continuar = false
            } catch (e: NumberFormatException) {
                println("La entrada introducida no es una opción válida.")
            }
        } while (continuar)
        return altura
    }

    private fun pedirPeso(): Double {
        var continuar = true
        var altura = 0.0
        do {
            print("Peso (kg): ")
            try {
                altura = readln().toDouble()
                continuar = false
            } catch (e: NumberFormatException) {
                println("La entrada introducida no es una opción válida.")
            }
        } while (continuar)
        return altura
    }

    private fun pedirPassword(): Int {
        var continuar = true
        var pass = 0
        do {
            print("Contraseña (6 dígitos): ")
            try {
                pass = readln().toInt()
                if (pass.toString().length != 6) {
                    println("La contraseña debe tener 6 dígitos.")
                } else {
                    continuar = false
                }
            } catch (e: NumberFormatException) {
                println("La entrada introducida no es una opción válida.")
            }
        } while (continuar)
        return pass
    }

    private fun pedirPasswordNueva(): Int {
        var continuar = true
        var pass1 = 0
        var pass2 = 0
        do {
            do {
                print("Contraseña (6 dígitos): ")
                try {
                    pass1 = readln().toInt()
                    if (pass1.toString().length != 6) {
                        println("La contraseña debe tener 6 dígitos.")
                    } else {
                        continuar = false
                    }
                } catch (e: NumberFormatException) {
                    println("El número introducido no es una contraseña válida.")
                }
            } while (continuar)

            do {
                print("Repite la contraseña (6 dígitos): ")
                try {
                    pass2 = readln().toInt()
                    if (pass2.toString().length != 6) {
                        println("La contraseña debe tener 6 dígitos.")
                    } else {
                        continuar = false
                    }
                } catch (e: NumberFormatException) {
                    println("La contraseña es distinta.")
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


    fun loginUsuario(): MutableMap.MutableEntry<String, Int>? {
        limpiarConsola()
        println("* Login *")
        val usuario = buscarUsuario(pedirNombreUsuarioRegistrado(), pedirPassword())
        if (usuario != null){
            return usuario
        } else {
            Consola.enviar("Usuario no registrado.\n")
            null
        }
        return null
    }

    fun registrarUsuario(): Usuario {
        limpiarConsola()
        println("* NUEVO USUARIO *")
        val nombre = pedirNombreUsuarioNuevo()
        val pass = pedirPasswordNueva()
        val sexo = pedirGenero()
        val edad = pedirEdad()
        val altura = pedirAltura()
        val peso = pedirPeso()
        registroUsuarios[nombre] = pass
        return Usuario(nombre, sexo, edad, altura, peso, pass)
    }

    private fun buscarUsuario(nombre: String, password: Int): MutableMap.MutableEntry<String, Int>? {
        return registroUsuarios.entries.find { it.key == nombre && it.value == password}
    }

    fun eliminarUsuario() {
        val usuarioEliminar = buscarUsuario(pedirNombreUsuarioRegistrado(), pedirPassword())
        if (usuarioEliminar != null) {
            registroUsuarios.remove(usuarioEliminar.key)
            println("Usuario eliminado.")
        } else {
            println("No se encontrado ningún usuario.")
        }
    }
}