class GestorEntrenamiento() {

    private fun menuPrincipal(usuario: Usuario) {
        println("Hola ${usuario.nombre}")
        println("¿Qué desea hacer?")
        println("1. Realizar un entrenamiento.")
        println("2. Ver mi historial.")
        println("3. Salir.")
    }

    private fun menuHistorial(usuario: Usuario, gestorInfoEntrenamiento: GestorInfoEntrenamiento) {
        var opcion: Int
        do {
            println("¿Qué historial desea ver?")
            println("1. Historial de running.")
            println("2. Historial de ciclismo.")
            println("3. Historial de natación.")
            println("4. Historial completo.")
            println("5. Atrás.")
            opcion = obtenerOpcion()

            when (opcion) {
                1 -> gestorInfoEntrenamiento.mostrarHistorialRunning(usuario)
                2 -> gestorInfoEntrenamiento.mostrarHistorialCiclismo(usuario)
                3 -> gestorInfoEntrenamiento.mostrarHistorialNatacion(usuario)
                4 -> {
                    gestorInfoEntrenamiento.mostrarHistorialRunning(usuario)
                    gestorInfoEntrenamiento.mostrarHistorialCiclismo(usuario)
                    gestorInfoEntrenamiento.mostrarHistorialNatacion(usuario)
                }
                5 -> println("Volviendo al menú principal.")
                else -> println("Opción no válida")
            }
        } while (opcion != 5)
    }

    private fun menuEntrenamiento(usuario: Usuario, gestorInfoEntrenamiento: GestorInfoEntrenamiento) {
        var opcion: Int
        do {
            println("¿Qué entrenamiento vas a realizar?")
            println("1. Running")
            println("2. Ciclismo")
            println("3. Natación")
            println("4. Atrás.")
            opcion = obtenerOpcion()

            when (opcion) {
                1 -> {
                    mostrarEntrenando()
                    if (pedirRegistro()) {
                        val datosRunning = pedirDatosRunning(usuario)
                        registrarEntrenamiento(datosRunning, gestorInfoEntrenamiento, usuario)
                    }
                }
                2 -> {
                    mostrarEntrenando()
                    if (pedirRegistro()) {
                        val datosCiclismo = pedirDatosCiclismo(usuario)
                        registrarEntrenamiento(datosCiclismo, gestorInfoEntrenamiento, usuario)
                    }
                }
                3 -> {
                    mostrarEntrenando()
                    if (pedirRegistro()) {
                        val datosNatacion = pedirDatosNatacion(usuario)
                        registrarEntrenamiento(datosNatacion, gestorInfoEntrenamiento, usuario)
                    }
                }
                4 -> println("Volviendo al menú principal.")
                else -> println("Opción no válida")
            }
        } while (opcion != 4)
    }

    fun controlMenus(usuario: Usuario, gestorInfoEntrenamiento: GestorInfoEntrenamiento) {
        var opcion: Int

        do {
            menuPrincipal(usuario)
            opcion = obtenerOpcion()

            when (opcion) {
                1 -> menuEntrenamiento(usuario, gestorInfoEntrenamiento)
                2 -> menuHistorial(usuario, gestorInfoEntrenamiento)
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

    fun pedirDatosRunning(usuario: Usuario): Entrenamiento {
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

        return Running(km, metros, horas, minutos, segundos, usuario)
    }

    fun pedirDatosNatacion(usuario: Usuario): Entrenamiento {
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

        return Natacion(km, metros, horas, minutos, segundos, usuario)
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