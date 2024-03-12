
interface GestorInformacion {
    var historial: MutableMap<String, MutableMap<String, String>>
    fun mostrarInfoUsuario(usuario: Usuario)
    fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento)
}


class GestorInfoEntrenamiento: GestorInformacion {

    override var historial: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
    private var historialRitmoRunning = mutableMapOf<String, Pila<Double>>()
    private var historialVatiosCiclismo = mutableMapOf<String, Pila<Double>>()
    private var historialRitmoNatacion = mutableMapOf<String, Pila<Double>>()
    private var listaRitmoRunning = Pila<Double>()
    private var listaVatiosCiclismo = Pila<Double>()
    private var listaRitmoNatacion = Pila<Double>()

    override fun mostrarInfoUsuario(usuario: Usuario) {

        println("\n* DATOS DEL USUARIO *")
        println("Nombre: ${usuario.nombre}.")
        println("Edad: ${usuario.edad}.")
        println("Peso: ${usuario.peso} kg.")
        println("Altura: ${usuario.altura} cm.")
    }

    override fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> {
                println("\n* Datos de tu salida en bici *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Velocidad media: ${entrenamiento.calcularVelocidadMedia()} km/h.")
                println("Vatios: ${entrenamiento.calcularVatios(usuario)} W.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
            is Running -> {
                println("\n* Datos de tu carrera *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Ritmo: ${entrenamiento.formatoRitmo()} min/km.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
            is Natacion -> {
                println("\n* Datos de tu natación *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Ritmo: ${entrenamiento.formatoRitmo()} min/km.")
                println("Brazadas: ${entrenamiento.calcularBrazadas(usuario)}.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
        }
    }

    fun registrarEntrenamiento(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> historial[usuario.nombre] = mutableMapOf("Ciclismo" to entrenamiento.toString())
            is Running -> historial[usuario.nombre] = mutableMapOf("Running" to entrenamiento.toString())
            is Natacion -> historial[usuario.nombre] = mutableMapOf("Natación" to entrenamiento.toString())
        }
    }

    fun mostrarHistorialRunning(usuario: Usuario) {
        val entrenamientosRunning = (historial[usuario.nombre]?.filterKeys { it == "Running" }?.values)

        println("\n* Running *")
        if (entrenamientosRunning != null) {
            entrenamientosRunning.forEach { println(it) }
        } else {
            println("No se encontraron entrenamientos de Running.")
        }
    }

    fun mostrarHistorialCiclismo(usuario: Usuario) {
        limpiarConsola()
        val entrenamientosCiclismo = historial[usuario.nombre]?.filterKeys { it == "Ciclismo" }?.values

        println("\n* Ciclismo *")
        if (entrenamientosCiclismo != null) {
            entrenamientosCiclismo.forEach { println(it) }
        } else {
            println("No se encontraron entrenamientos de Ciclismo.")
        }
    }

    fun mostrarHistorialNatacion(usuario: Usuario) {
        limpiarConsola()
        val entrenamientosNatacion = historial[usuario.nombre]?.filterKeys { it == "Natación" }?.values

        println("\n* Natación *")
        if (entrenamientosNatacion != null) {
            entrenamientosNatacion.forEach { println(it) }
        } else {
            println("No se encontraron entrenamientos de Natación.")
        }
    }

    fun actualizarHistorialMejoras(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> {
                listaVatiosCiclismo.push(entrenamiento.calcularVatios(usuario))
                historialVatiosCiclismo[usuario.nombre] = listaVatiosCiclismo
            }
            is Running -> {
                listaRitmoRunning.push(entrenamiento.calcularRitmo())
                historialRitmoRunning[usuario.nombre] = listaRitmoRunning
            }
            is Natacion -> {
                listaRitmoNatacion.push(entrenamiento.calcularRitmo())
                historialRitmoNatacion[usuario.nombre] = listaRitmoNatacion
            }
        }
    }

    fun compararMejoras(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> {
                val pilaCiclismo = historialVatiosCiclismo[usuario.nombre]
                val ultimoRegistro = pilaCiclismo?.top()
                if ( ultimoRegistro != null) {
                    if (ultimoRegistro < entrenamiento.calcularVatios(usuario)) {
                        println("Has mejorado respecto a tu registro anterior.")
                    } else {
                        println("Has empeorado respecto a tu registro anterior.")
                    }
                }
            }
            is Running -> {
                val pilaRunning = historialRitmoRunning[usuario.nombre]
                val ultimoRegistro = pilaRunning?.top()
                if ( ultimoRegistro != null) {
                    if (ultimoRegistro < entrenamiento.calcularRitmo()) {
                        println("Has mejorado respecto a tu registro anterior.")
                    } else {
                        println("Has empeorado respecto a tu registro anterior.")
                    }
                }
            }
            is Natacion -> {
                val pilaNatacion = historialRitmoNatacion[usuario.nombre]
                val ultimoRegistro = pilaNatacion?.top()
                if ( ultimoRegistro != null) {
                    if (ultimoRegistro < entrenamiento.calcularRitmo()) {
                        println("Has mejorado respecto a tu registro anterior.")
                    } else {
                        println("Has empeorado respecto a tu registro anterior.")
                    }
                }
            }
        }
    }

}


