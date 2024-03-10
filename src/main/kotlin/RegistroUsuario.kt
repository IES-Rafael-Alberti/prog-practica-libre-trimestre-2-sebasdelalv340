class RegistroUsuario(usuario: Usuario) {

    private var registroUsuarios = mutableListOf<Usuario>()

    companion object {
        var registroNombresUsuarios = mutableSetOf<String>()
    }


    fun comprobarUsuario(nombre: String): Boolean {
        val nombreAComprobar = nombre.lowercase().trim()
        return if (registroNombresUsuarios.contains(nombreAComprobar)) {
            true
        } else {
            registroNombresUsuarios.add(nombreAComprobar)
            false
        }
    }

    private fun pedirNombre(): String {
        var nombre = ""
        var continuar = true
        do {
            print("Introduzca su nombre: ")
            try {
                nombre = readln()
                continuar = false
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
            println("Sexo (H/M): ")
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
                println("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return genero
    }

    private fun pedirEdad(): Int {
        var continuar = true
        var edad = 0
        do {
            println("Edad: ")
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
            println("Altura (cm): ")
            try {
                altura = readln().toInt()
                continuar = false
            } catch (e: NumberFormatException) {
                println("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return altura
    }

    private fun pedirPeso(): Double {
        var continuar = true
        var altura = 0.0
        do {
            println("Peso (kg): ")
            try {
                altura = readln().toDouble()
                continuar = false
            } catch (e: NumberFormatException) {
                println("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return altura
    }


    fun registrarUsuario(): Usuario? {
        val name = pedirNombre()
        return if (comprobarUsuario(name)) {
            println("Usuario registrado")
            buscarUsuario(name)
        } else {
            val nombre = pedirNombre()
            val sexo = pedirGenero()
            val edad = pedirEdad()
            val altura = pedirAltura()
            val peso = pedirPeso()
            val usuario = Usuario(nombre, sexo, edad, altura, peso)
            registroUsuarios.add(usuario)
            Usuario(nombre, sexo, edad, altura, peso)
        }
    }

    private fun buscarUsuario(nombre: String): Usuario? {
        return registroUsuarios.find { it.nombre == nombre }
    }

}