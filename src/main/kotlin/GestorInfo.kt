
interface GestorInformacion {
    val historial: MutableMap<String, MutableMap<String, String>>
    fun mostrarInfoUsuario(usuario: Usuario)
    fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento)
}


class GestorInfoEntrenamiento: GestorInformacion {

    override lateinit var historial: MutableMap<String, MutableMap<String, String>>

    override fun mostrarInfoUsuario(usuario: Usuario) {
        println("Hola ${usuario.nombre}.")
        println("Edad: ${usuario.edad}.")
        println("Peso: ${usuario.peso} kg.")
        println("Altura: ${usuario.altura} cm.")
    }

    override fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> {
                println("* Datos de tu salida en bici *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Velocidad media: ${entrenamiento.calcularVelocidadMedia()} km/h.")
                println("Vatios: ${entrenamiento.calcularVatios(usuario)} W.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
            is Running -> {
                println("* Datos de tu carrera *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Ritmo: ${entrenamiento.calcularRitmo()} min/km.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
            is Natacion -> {
                println("* Datos de tu natación *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Ritmo: ${entrenamiento.calcularRitmo()} min/km.")
                println("Brazadas: ${entrenamiento.calcularBrazadas(usuario)}.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
        }
    }

    fun registrarEntrenamiento(entrenamiento: Entrenamiento, usuario: Usuario) {
        when (entrenamiento) {
            is Ciclismo -> historial[usuario.nombre] = mutableMapOf("Ciclismo" to entrenamiento.toString())
            is Running -> historial[usuario.nombre] = mutableMapOf("Running" to entrenamiento.toString())
            is Natacion -> historial[usuario.nombre] = mutableMapOf("Natación" to entrenamiento.toString())
        }
    }

    fun mostrarHistorialRunning(usuario: Usuario) {
        val entrenamientosRunning = (historial[usuario.nombre]?.filterKeys { it == "Running" }?.values)

        println("* Running *")
        if (entrenamientosRunning != null) {
            entrenamientosRunning.forEach { println(it) }
        } else {
            println("No se encontraron entrenamientos de Running.")
        }
    }

    fun mostrarHistorialCiclismo(usuario: Usuario) {
        val entrenamientosCiclismo = (historial[usuario.nombre]?.filterKeys { it == "Running" }?.values)

        println("* Ciclismo *")
        if (entrenamientosCiclismo != null) {
            entrenamientosCiclismo.forEach { println(it) }
        } else {
            println("No se encontraron entrenamientos de Running.")
        }
    }

    fun mostrarHistorialNatacion(usuario: Usuario) {
        val entrenamientosNatacion = (historial[usuario.nombre]?.filterKeys { it == "Running" }?.values)

        println("* Natación *")
        if (entrenamientosNatacion != null) {
            entrenamientosNatacion.forEach { println(it) }
        } else {
            println("No se encontraron entrenamientos de Running.")
        }
    }
}


