package Gestores

import Consola.Consola
import Entrenamiento.*
import Pila.Pila
import Usuario.Usuario


/**
 * Interfaz que define métodos para gestionar la información de los entrenamientos.
 */
interface GestorInformacion {
    var historial: MutableMap<String, MutableMap<String, String>>

    /**
     * Muestra la información del usuario.
     *
     * @param usuario El usuario del cual se mostrará la información.
     */
    fun mostrarInfoUsuario(usuario: Usuario)

    /**
     * Muestra la información de un entrenamiento específico.
     *
     * @param usuario El usuario al cual pertenece el entrenamiento.
     * @param entrenamiento El entrenamiento del cual se mostrará la información.
     */
    fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento)
}

/**
 * Clase que implementa la interfaz GestorInformacion para gestionar la información de los entrenamientos.
 */
class GestorInfoEntrenamiento: GestorInformacion {

    // Mapas y pilas para almacenar información específica de cada tipo de entrenamiento.
    override var historial: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
    private var historialRitmoRunning = mutableMapOf<String, Pila<Double>>()
    private var historialVatiosCiclismo = mutableMapOf<String, Pila<Double>>()
    private var historialRitmoNatacion = mutableMapOf<String, Pila<Double>>()
    private var listaRitmoRunning = Pila<Double>()
    private var listaVatiosCiclismo = Pila<Double>()
    private var listaRitmoNatacion = Pila<Double>()

    companion object {
        const val ANSI_RED = "\u001B[31m"
        const val ANSI_GREEN = "\u001B[32m"
        const val ANSI_RESET = "\u001B[0m"
    }

    /**
     * Muestra la información del usuario.
     *
     * @param usuario El usuario del cual se mostrará la información.
     */
    override fun mostrarInfoUsuario(usuario: Usuario) {
        Consola.enviar("\n* DATOS DEL USUARIO *\n")
        Consola.enviar("Nombre: ${usuario.nombre}.\n")
        Consola.enviar("Edad: ${usuario.edad}.\n")
        Consola.enviar("Peso: ${usuario.peso} kg.\n")
        Consola.enviar("Altura: ${usuario.altura} cm.\n")
    }

    /**
     * Muestra la información de un entrenamiento específico.
     *
     * @param usuario El usuario al cual pertenece el entrenamiento.
     * @param entrenamiento El entrenamiento del cual se mostrará la información.
     */
    override fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> {
                Consola.enviar("\n* Datos de tu salida en bici *\n")
                Consola.enviar("\nDistancia: ${entrenamiento.calcularDistancia()} km.\n")
                Consola.enviar("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.\n")
                Consola.enviar("Velocidad media: ${entrenamiento.calcularVelocidadMedia().redondear()} km/h.\n")
                Consola.enviar("Vatios: ${entrenamiento.calcularVatios(usuario).redondear()} W.\n")
                Consola.enviar("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario).redondear()} calorías.\n")
            }
            is Running -> {
                Consola.enviar("\n* Datos de tu carrera *\n")
                Consola.enviar("\nDistancia: ${entrenamiento.calcularDistancia()} km.\n")
                Consola.enviar("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.\n")
                Consola.enviar("Ritmo: ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km.\n")
                Consola.enviar("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario).redondear()} calorías.\n")
            }
            is Natacion -> {
                Consola.enviar("\n* Datos de tu natación *\n")
                Consola.enviar("\nDistancia: ${entrenamiento.calcularDistancia()} km.\n")
                Consola.enviar("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.\n")
                Consola.enviar("Ritmo: ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km.\n")
                Consola.enviar("Brazadas: ${entrenamiento.calcularBrazadas(usuario)}.\n")
                Consola.enviar("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario).redondear()} calorías.\n")
            }
        }
    }

    /**
     * Función para registrar un entrenamiento en el historial del usuario.
     * @param usuario El usuario que realizó el entrenamiento.
     * @param entrenamiento El entrenamiento que se va a registrar.
     */
    fun registrarEntrenamiento(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> historial[usuario.nombre] = mutableMapOf("Entrenamiento.Ciclismo" to entrenamiento.toString())
            is Running -> historial[usuario.nombre] = mutableMapOf("Entrenamiento.Running" to entrenamiento.toString())
            is Natacion -> historial[usuario.nombre] = mutableMapOf("Natación" to entrenamiento.toString())
        }
    }

    /**
     * Función para mostrar el historial de entrenamientos de running de un usuario.
     * @param usuario El usuario del cual se mostrará el historial.
     */
    fun mostrarHistorialRunning(usuario: Usuario) {
        val entrenamientosRunning = (historial[usuario.nombre]?.filterKeys { it == "Entrenamiento.Running" }?.values)

        Consola.enviar("\n* Entrenamiento.Running *\n")
        if (entrenamientosRunning != null) {
            entrenamientosRunning.forEach { Consola.enviar("$it\n") }
        } else {
            Consola.enviar("No se encontraron entrenamientos de Entrenamiento.Running.\n")
        }
    }

    /**
     * Función para mostrar el historial de entrenamientos de ciclismo de un usuario.
     * @param usuario El usuario del cual se mostrará el historial.
     */
    fun mostrarHistorialCiclismo(usuario: Usuario) {
        val entrenamientosCiclismo = historial[usuario.nombre]?.filterKeys { it == "Entrenamiento.Ciclismo" }?.values

        Consola.enviar("\n* Entrenamiento.Ciclismo *\n")
        if (entrenamientosCiclismo != null) {
            entrenamientosCiclismo.forEach { Consola.enviar("$it\n") }
        } else {
            Consola.enviar("No se encontraron entrenamientos de Entrenamiento.Ciclismo.\n")
        }
    }

    /**
     * Función para mostrar el historial de entrenamientos de natación de un usuario.
     * @param usuario El usuario del cual se mostrará el historial.
     */
    fun mostrarHistorialNatacion(usuario: Usuario) {
        val entrenamientosNatacion = historial[usuario.nombre]?.filterKeys { it == "Natación" }?.values

        Consola.enviar("\n* Natación *\n")
        if (entrenamientosNatacion != null) {
            entrenamientosNatacion.forEach { Consola.enviar("$it\n") }
        } else {
            Consola.enviar("No se encontraron entrenamientos de Natación.\n")
        }
    }

    /**
     * Función para actualizar el historial de mejoras del usuario después de un entrenamiento.
     * @param usuario El usuario que realizó el entrenamiento.
     * @param entrenamiento El entrenamiento del cual se actualizará el historial.
     */
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

    /**
     * Función para comparar las mejoras del usuario después de un entrenamiento.
     * @param usuario El usuario que realizó el entrenamiento.
     * @param entrenamiento El entrenamiento del cual se compararán las mejoras.
     */
    fun compararMejoras(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> {
                val pilaCiclismo = historialVatiosCiclismo[usuario.nombre]
                val ultimoRegistro = pilaCiclismo?.top()
                if ( ultimoRegistro != null) {
                    if (ultimoRegistro < entrenamiento.calcularVatios(usuario)) {
                        Consola.enviar("\nHas mejorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar("   $ultimoRegistro W      ->   $ANSI_GREEN ${entrenamiento.calcularVatios(usuario)} W$ANSI_RESET\n")
                    } else {
                        Consola.enviar("\nHas empeorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar("   $ultimoRegistro W         ->   $ANSI_RED ${entrenamiento.calcularVatios(usuario)} W$ANSI_RESET\n")
                    }
                }
            }
            is Running -> {
                val pilaRunning = historialRitmoRunning[usuario.nombre]
                val ultimoRegistro = pilaRunning?.top()
                if ( ultimoRegistro != null) {
                    if (ultimoRegistro > entrenamiento.calcularRitmo()) {
                        Consola.enviar("\nHas mejorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar(
                            "   ${entrenamiento.formatoRitmo(ultimoRegistro)} min/km    ->    $ANSI_GREEN ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km$ANSI_RESET\n"
                        )
                    } else {
                        Consola.enviar("\nHas empeorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar(
                            "   ${entrenamiento.formatoRitmo(ultimoRegistro)} min/km    ->    $ANSI_RED ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km$ANSI_RESET\n"
                        )
                    }
                }
            }
            is Natacion -> {
                val pilaNatacion = historialRitmoNatacion[usuario.nombre]
                val ultimoRegistro = pilaNatacion?.top()
                if ( ultimoRegistro != null) {
                    if (ultimoRegistro > entrenamiento.calcularRitmo()) {
                        Consola.enviar("\nHas mejorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar(
                            "   ${entrenamiento.formatoRitmo(ultimoRegistro)} min/km    ->    $ANSI_GREEN ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km$ANSI_RESET\n"
                        )
                    } else {
                        Consola.enviar("\nHas empeorado respecto a tu registro anterior.\n")
                        Consola.enviar("Último registro   ->   Registro actual\n")
                        Consola.enviar(
                            "   ${entrenamiento.formatoRitmo(ultimoRegistro)} min/km    ->    $ANSI_RED ${entrenamiento.formatoRitmo(entrenamiento.calcularRitmo())} min/km$ANSI_RESET\n"
                        )
                    }
                }
            }
        }
    }
}


