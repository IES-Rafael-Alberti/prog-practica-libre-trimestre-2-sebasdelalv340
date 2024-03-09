class GestorEntrenamiento() {

    fun realizarEntrenamiento(){

    }

    private fun menuPrincipal(usuario: Usuario) {
        println("Hola ${usuario.nombre}")
        println("¿Qué desea hacer?")
        println("1. Realizar un entrenamiento.")
        println("2. Ver mi historial.")
        println("3. Salir.")
    }

    private fun menuHistorial() {
        var opcion: Int
        do {
            println("¿Qué entrenamiento vas a realizar?")
            println("1. Running")
            println("2. Ciclismo")
            println("3. Natación")
            println("4. Atrás.")
            opcion = obtenerOpcion()

            when (opcion) {
                1 -> println("Realizar entrenamiento de running.")
                2 -> println("Realizar entrenamiento de ciclismo.")
                3 -> println("Realizar entrenamiento de natación.")
                4 -> println("Volviendo al menú principal.")
                else -> println("Opción no válida")
            }
        } while (opcion != 4)
    }

    private fun menuEntrenamiento() {
        var opcion: Int
        do {
            println("¿Qué entrenamiento vas a realizar?")
            println("1. Running")
            println("2. Ciclismo")
            println("3. Natación")
            println("4. Atrás.")
            opcion = obtenerOpcion()

            when (opcion) {
                1 -> println("Realizar entrenamiento de running.")
                2 -> println("Realizar entrenamiento de ciclismo.")
                3 -> println("Realizar entrenamiento de natación.")
                4 -> println("Volviendo al menú principal.")
                else -> println("Opción no válida")
            }
        } while (opcion != 4)
    }

    fun controlMenus(usuario: Usuario) {
        var opcion: Int

        do {
            menuPrincipal(usuario)
            opcion = obtenerOpcion()

            when (opcion) {
                1 -> menuEntrenamiento()
                2 -> menuHistorial()
                3 -> println("Hasta luego!")
                else -> println("Opción no válida")
            }
        } while (opcion != 3)

    }

    private fun obtenerOpcion(): Int {
        var continuar = true
        var opcion = 0
        do {
            try {
                print("Introduce tu elección: ")
                opcion = readln().toInt()
                if (opcion in 1..5) {
                    continuar = false
                } else {
                    println("Por favor, introduce un número del 1 al 4.")
                }
            } catch (e: NumberFormatException) {
                println("La entrada no es una opción válida.")
            }
        } while (continuar)
        return opcion
    }

    fun recogerOpcion(usuario: Usuario, gestorInfoEntrenamiento: GestorInfoEntrenamiento) {
        val opcion = obtenerOpcion()

        when (opcion) {
            1 -> {
                mostrarEntrenando()
                if (pedirRegistro()) { // Devuelve boolean, tenerlo en cuenta
                    registrarEntrenamiento(pedirDatosCiclismo(usuario), gestorInfoEntrenamiento, usuario)
                }
                println("Seleccionaste Running")
            }

            2 -> {
                mostrarEntrenando()
                println("Seleccionaste Ciclismo")
            }

            3 -> {
                mostrarEntrenando()
                println("Seleccionaste Natación")
            }

            4 -> {
                println("Hasta luego!")
                // Aquí puedes añadir cualquier otra lógica de salida que necesites
            }
        }
    }

    fun pedirRegistro(): Boolean {
        print("¿Quieres registrar la actividad? (s/n): ")
        var opcion: String
        var continuar = true
        do {
            try {
                opcion = readln().lowercase()
                if (opcion == "s") {
                    continuar = false
                    return true
                } else if (opcion == "n") {
                    continuar = false
                    return false
                }
            } catch (e: IllegalArgumentException) {
                println("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return true
    }

    fun pedirDatosCiclismo(usuario: Usuario): Entrenamiento {
        println("Introduce la distancia")
        print("Kilómetros: ")
        val km = pedirDistancia()
        print("Metros: ")
        val metros = pedirDistancia()
        println("Introduce el tiempo")
        print("Horas: ")
        val horas = pedirTiempo()
        print("Minutos: ")
        val minutos = pedirTiempo()
        print("Segundos: ")
        val segundos = pedirTiempo()

        return Ciclismo(km, metros, horas, minutos, segundos, usuario)
    }

    private fun pedirDistancia(): Int {
        var continuar = true
        var km = 0
        do {
            try {
                km = readln().toInt()
                continuar = false
            } catch (e: NumberFormatException) {
                println("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return km
    }

    private fun pedirTiempo(): Int {
        var continuar = true
        var tiempo = 0
        do {
            try {
                tiempo = readln().toInt()
                if (tiempo in 0..59) {
                    continuar = false
                } else {
                    println("Por favor, introduce un valor entre 0 y 59")
                }
            } catch (e: NumberFormatException) {
                println("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return tiempo
    }




    fun registrarEntrenamiento(entrenamiento: Entrenamiento, gestorInfoEntrenamiento: GestorInfoEntrenamiento, usuario: Usuario) {
        when (entrenamiento) {
            is Ciclismo -> gestorInfoEntrenamiento.historial[usuario.nombre] = mutableMapOf("Ciclismo" to entrenamiento.toString())
            is Running -> gestorInfoEntrenamiento.historial[usuario.nombre] = mutableMapOf("Running" to entrenamiento.toString())
            is Natacion -> gestorInfoEntrenamiento.historial[usuario.nombre] = mutableMapOf("Natación" to entrenamiento.toString())
        }
    }

    fun mostrarEntrenando() {
        println("Entrenando...")
        println("Pulsa enter cuando hayas acabado")
        readln() // Espera a que el usuario pulse Enter
    }

}