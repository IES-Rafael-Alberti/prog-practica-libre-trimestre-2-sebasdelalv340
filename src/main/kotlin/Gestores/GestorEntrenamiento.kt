package Gestores

import Consola.Consola
import Entrenamiento.Ciclismo
import Entrenamiento.Entrenamiento
import Entrenamiento.Natacion
import Entrenamiento.Running
import Usuario.Usuario

class GestorEntrenamiento {

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

    private fun pedirDistancia(): Int {
        var continuar = true
        var km = 0
        do {
            try {
                km = Consola.leerEntero()
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
            tiempo = Consola.leerEntero()
            if (tiempo in 0..59) {
                continuar = false
            } else {
                println("Por favor, introduce un valor entre 0 y 59")
            }
        } while (continuar)
        return tiempo
    }


}