
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

        Consola.enviar("\n* DATOS DEL USUARIO *\n")
        Consola.enviar("Nombre: ${usuario.nombre}.\n")
        Consola.enviar("Edad: ${usuario.edad}.\n")
        Consola.enviar("Peso: ${usuario.peso} kg.\n")
        Consola.enviar("Altura: ${usuario.altura} cm.\n")
    }

    override fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> {
                Consola.enviar("\n* Datos de tu salida en bici *\n")
                Consola.enviar("\nDistancia: ${entrenamiento.calcularDistancia()} km.\n")
                Consola.enviar("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.\n")
                Consola.enviar("Velocidad media: ${entrenamiento.calcularVelocidadMedia()} km/h.\n")
                Consola.enviar("Vatios: ${entrenamiento.calcularVatios(usuario)} W.\n")
                Consola.enviar("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.\n")
            }
            is Running -> {
                Consola.enviar("\n* Datos de tu carrera *\n")
                Consola.enviar("\nDistancia: ${entrenamiento.calcularDistancia()} km.\n")
                Consola.enviar("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.\n")
                Consola.enviar("Ritmo: ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km.\n")
                Consola.enviar("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.\n")
            }
            is Natacion -> {
                Consola.enviar("\n* Datos de tu natación *\n")
                Consola.enviar("\nDistancia: ${entrenamiento.calcularDistancia()} km.\n")
                Consola.enviar("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.\n")
                Consola.enviar("Ritmo: ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km.\n")
                Consola.enviar("Brazadas: ${entrenamiento.calcularBrazadas(usuario)}.\n")
                Consola.enviar("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.\n")
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

        Consola.enviar("\n* Running *\n")
        if (entrenamientosRunning != null) {
            entrenamientosRunning.forEach { Consola.enviar("$it\n") }
        } else {
            Consola.enviar("No se encontraron entrenamientos de Running.\n")
        }
    }

    fun mostrarHistorialCiclismo(usuario: Usuario) {
        limpiarConsola()
        val entrenamientosCiclismo = historial[usuario.nombre]?.filterKeys { it == "Ciclismo" }?.values

        Consola.enviar("\n* Ciclismo *\n")
        if (entrenamientosCiclismo != null) {
            entrenamientosCiclismo.forEach { Consola.enviar("$it\n") }
        } else {
            Consola.enviar("No se encontraron entrenamientos de Ciclismo.\n")
        }
    }

    fun mostrarHistorialNatacion(usuario: Usuario) {
        limpiarConsola()
        val entrenamientosNatacion = historial[usuario.nombre]?.filterKeys { it == "Natación" }?.values

        Consola.enviar("\n* Natación *\n")
        if (entrenamientosNatacion != null) {
            entrenamientosNatacion.forEach { Consola.enviar("$it\n") }
        } else {
            Consola.enviar("No se encontraron entrenamientos de Natación.\n")
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
                        Consola.enviar("Has mejorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar("   $ultimoRegistro W   ->   ${entrenamiento.calcularVatios(usuario)}W\n")
                    } else {
                        Consola.enviar("Has empeorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar("   $ultimoRegistro W   ->   ${entrenamiento.calcularVatios(usuario)}W\n")
                    }
                }
            }
            is Running -> {
                val pilaRunning = historialRitmoRunning[usuario.nombre]
                val ultimoRegistro = pilaRunning?.top()
                if ( ultimoRegistro != null) {
                    if (ultimoRegistro > entrenamiento.calcularRitmo()) {
                        Consola.enviar("Has mejorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar("   ${entrenamiento.formatoRitmo(ultimoRegistro)} min/km   ->   ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km\n")
                    } else {
                        Consola.enviar("Has empeorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar("   ${entrenamiento.formatoRitmo(ultimoRegistro)} min/km   ->   ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km\n")
                    }
                }
            }
            is Natacion -> {
                val pilaNatacion = historialRitmoNatacion[usuario.nombre]
                val ultimoRegistro = pilaNatacion?.top()
                if ( ultimoRegistro != null) {
                    if (ultimoRegistro > entrenamiento.calcularRitmo()) {
                        Consola.enviar("Has mejorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar("   ${entrenamiento.formatoRitmo(ultimoRegistro)} min/km   ->   ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km\n")
                    } else {
                        Consola.enviar("Has empeorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar("   ${entrenamiento.formatoRitmo(ultimoRegistro)} min/km   ->   ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km\n")
                    }
                }
            }
        }
    }

}


