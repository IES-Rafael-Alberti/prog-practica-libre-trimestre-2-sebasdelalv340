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
        val km = pedirKilometros()
        val metros = pedirMetros()

        Consola.enviar("Introduce el tiempo\n")
        val horas = pedirHoras()
        val minutos = pedirMinutos()
        val segundos = pedirSegundos()

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
        val km = pedirKilometros()
        val metros = pedirMetros()

        Consola.enviar("Introduce el tiempo\n")
        val horas = pedirHoras()
        val minutos = pedirMinutos()
        val segundos = pedirSegundos()

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
        val km = pedirKilometros()
        val metros = pedirMetros()

        Consola.enviar("Introduce el tiempo\n")
        val horas = pedirHoras()
        val minutos = pedirMinutos()
        val segundos = pedirSegundos()

        return Natacion(km, metros, horas, minutos, segundos, usuario)
    }

    /**
     * Solicita al usuario los kilómetros de un entrenamiento.
     *
     * @return Los kilómetros del entrenamiento.
     */
    private fun pedirKilometros(): Int {
        var continuar = true
        var km = 0
        do {
            Consola.enviar("Kilómetros: ")
            try {
                km = Consola.leerEntero()
                continuar = false
            } catch (e: NumberFormatException) {
                Consola.enviar("El número introducido no es una opción válida.\n")
            }
        } while (continuar)
        return km
    }

    /**
     * Solicita al usuario los metros de un entrenamiento.
     *
     * @return Los metros del entrenamiento.
     */
    private fun pedirMetros(): Int {
        var continuar = true
        var km = 0
        do {
            Consola.enviar("Metros: ")
            try {
                km = Consola.leerEntero()
                continuar = false
            } catch (e: NumberFormatException) {
                Consola.enviar("El número introducido no es una opción válida.\n")
            }
        } while (continuar)
        return km
    }

    /**
     * Solicita al usuario las horas de un entrenamiento.
     *
     * @return Las horas del entrenamiento.
     */
    private fun pedirHoras(): Int {
        var continuar = true
        var tiempo = 0
        do {
            Consola.enviar("Horas: ")
            tiempo = Consola.leerEntero()
            if (tiempo in 0..59) {
                continuar = false
            } else {
                Consola.enviar("Por favor, introduce un valor entre 0 y 59\n")
            }
        } while (continuar)
        return tiempo
    }

    /**
     * Solicita al usuario los minutos de un entrenamiento.
     *
     * @return Los minutos del entrenamiento.
     */
    private fun pedirMinutos(): Int {
        var continuar = true
        var tiempo = 0
        do {
            Consola.enviar("Minutos: ")
            tiempo = Consola.leerEntero()
            if (tiempo in 0..59) {
                continuar = false
            } else {
                Consola.enviar("Por favor, introduce un valor entre 0 y 59\n")
            }
        } while (continuar)
        return tiempo
    }

    /**
     * Solicita al usuario los segundos de un entrenamiento.
     *
     * @return Los segundos del entrenamiento.
     */
    private fun pedirSegundos(): Int {
        var continuar = true
        var tiempo = 0
        do {
            Consola.enviar("Segundos: ")
            tiempo = Consola.leerEntero()
            if (tiempo in 0..59) {
                continuar = false
            } else {
                Consola.enviar("Por favor, introduce un valor entre 0 y 59\n")
            }
        } while (continuar)
        return tiempo
    }
}