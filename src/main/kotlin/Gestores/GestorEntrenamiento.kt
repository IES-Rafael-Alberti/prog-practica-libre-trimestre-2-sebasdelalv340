package Gestores

import Consola.Consola
import Entrenamiento.Ciclismo
import Entrenamiento.Entrenamiento
import Entrenamiento.Natacion
import Entrenamiento.Running
import Usuario.Usuario

/**
 * Clase que gestiona la entrada de datos y la creación de entrenamientos.
 */
class GestorEntrenamiento {

    /**
     * Solicita al usuario que decida si desea registrar la actividad.
     *
     * @return true si el usuario decide registrar la actividad, false de lo contrario.
     */
    fun pedirRegistro(): Boolean {
        Consola.enviar("¿Quieres registrar la actividad? (s/n): \n")
        var opcion: String
        var continuar = true
        do {
            opcion = Consola.leerString().lowercase()
            if (opcion == "s") {
                continuar = false
                return true
            } else if (opcion == "n") {
                continuar = false
                return false
            }
        } while (continuar)
        return true
    }

    /**
     * Solicita al usuario los datos para un entrenamiento de ciclismo y crea un objeto Ciclismo.
     *
     * @param usuario El usuario que realizó el entrenamiento.
     * @return Un objeto de tipo Ciclismo con los datos proporcionados por el usuario.
     */
    fun pedirDatosCiclismo(usuario: Usuario): Entrenamiento {
        Consola.enviar("Introduce la distancia\n")
        Consola.enviar("Kilómetros: ")
        val km = pedirDistancia()
        Consola.enviar("Metros: ")
        val metros = pedirDistancia()
        Consola.enviar("Introduce el tiempo\n")
        Consola.enviar("Horas: ")
        val horas = pedirTiempo()
        Consola.enviar("Minutos: ")
        val minutos = pedirTiempo()
        Consola.enviar("Segundos: ")
        val segundos = pedirTiempo()

        return Ciclismo(km, metros, horas, minutos, segundos, usuario)
    }

    /**
     * Solicita al usuario los datos para un entrenamiento de running y crea un objeto Running.
     *
     * @param usuario El usuario que realizó el entrenamiento.
     * @return Un objeto de tipo Running con los datos proporcionados por el usuario.
     */
    fun pedirDatosRunning(usuario: Usuario): Entrenamiento {
        Consola.enviar("Introduce la distancia\n")
        Consola.enviar("Kilómetros: ")
        val km = Consola.leerEntero()
        Consola.enviar("Metros: ")
        val metros = pedirDistancia()
        Consola.enviar("Introduce el tiempo\n")
        Consola.enviar("Horas: ")
        val horas = pedirTiempo()
        Consola.enviar("Minutos: ")
        val minutos = pedirTiempo()
        Consola.enviar("Segundos: ")
        val segundos = pedirTiempo()

        return Running(km, metros, horas, minutos, segundos, usuario)
    }

    /**
     * Solicita al usuario los datos para un entrenamiento de natación y crea un objeto Natacion.
     *
     * @param usuario El usuario que realizó el entrenamiento.
     * @return Un objeto de tipo Natacion con los datos proporcionados por el usuario.
     */
    fun pedirDatosNatacion(usuario: Usuario): Entrenamiento {
        Consola.enviar("Introduce la distancia\n")
        Consola.enviar("Kilómetros: ")
        val km = Consola.leerEntero()
        Consola.enviar("Metros: ")
        val metros = Consola.leerEntero()
        Consola.enviar("Introduce el tiempo\n")
        Consola.enviar("Horas: ")
        val horas = Consola.leerEntero()
        Consola.enviar("Minutos: ")
        val minutos = Consola.leerEntero()
        Consola.enviar("Segundos: ")
        val segundos = Consola.leerEntero()

        return Natacion(km, metros, horas, minutos, segundos, usuario)
    }

    /**
     * Solicita al usuario la distancia de un entrenamiento.
     *
     * @return La distancia del entrenamiento.
     */
    private fun pedirDistancia(): Int {
        var continuar = true
        var km = 0
        do {
            try {
                km = Consola.leerEntero()
                continuar = false
            } catch (e: NumberFormatException) {
                Consola.enviar("El número introducido no es una opción válida.")
            }
        } while (continuar)
        return km
    }

    /**
     * Solicita al usuario el tiempo de un entrenamiento.
     *
     * @return El tiempo del entrenamiento.
     */
    private fun pedirTiempo(): Int {
        var continuar = true
        var tiempo = 0
        do {
            tiempo = Consola.leerEntero()
            if (tiempo in 0..59) {
                continuar = false
            } else {
                Consola.enviar("Por favor, introduce un valor entre 0 y 59")
            }
        } while (continuar)
        return tiempo
    }
}