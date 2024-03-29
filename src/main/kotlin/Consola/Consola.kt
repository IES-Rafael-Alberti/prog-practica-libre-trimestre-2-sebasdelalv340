package Consola

/**
 * Interfaz para definir un notificador que puede enviar mensajes.
 */
interface Notificador {
    fun enviar(mensaje: String) {
    }
}

/**
 * Interfaz para definir métodos de entrada de datos.
 */
interface EntradaDatos {
    fun leerEntero(): Int

    fun leerDouble(): Double

    fun leerString(): String
}

/**
 * Objeto único que implementa las interfaces [Notificador] y [EntradaDatos] utilizando la entrada y salida estándar de la consola.
 */
object Consola: Notificador, EntradaDatos {

    /**
     * Printea el mensaje que pasamos por parámetro.
     *
     * @param mensaje El mensaje a enviar.
     */
    override fun enviar(mensaje: String) {
        print(mensaje)
    }

    /**
     * Lee un entero por consola.
     *
     * @return El entero leído.
     */
    override fun leerEntero(): Int {
        var continuar = true
        var entero = 0
        do {
            try {
                entero = readln().toInt()
                continuar = false
            } catch (e: NumberFormatException) {
                println("La entrada no es una opción válida.")
            }
        } while (continuar)
        return entero
    }

    /**
     * Lee un número en punto flotante por consola.
     *
     * @return El número en punto flotante leído.
     */
    override fun leerDouble(): Double{
        var continuar = true
        var double = 0.0
        do {
            try {
                double = readln().toDouble()
                continuar = false
            } catch (e: NumberFormatException) {
                println("La entrada no es una opción válida.")
            }
        } while (continuar)
        return double
    }

    /**
     * Lee una cadena de caracteres introducida por consola.
     *
     * @return La cadena de caracteres leída.
     */
    override fun leerString(): String {
        var continuar = true
        var string: String = ""
        do {
            try {
                string = readln()
                continuar = false
            } catch (e: IllegalArgumentException) {
                println("La entrada no es una opción válida.")
            }
        } while(continuar)
        return string
    }

    fun menuAcesso() {
        println("* BIENVENIDO *")
        println("1. Mi cuenta.")
        println("2. Registrarse.")
        println("3. Salir.")
    }

    fun menuHistorial() {
        println("* HISTORIALES *")
        println("1. Historial de running.")
        println("2. Historial de ciclismo.")
        println("3. Historial de natación.")
        println("4. Historial completo.")
        println("5. Atrás.")
        print("¿Qué historial desea ver?: ")
    }

    fun menuEntrenamiento() {
        println("\n* ACTIVIDADES *")
        println("1. Running")
        println("2. Ciclismo")
        println("3. Natación")
        println("4. Atrás.")
        print("¿Qué entrenamiento vas a realizar?: ")
    }

    fun mostrarEntrenando() {
        println("Entrenando...")
        println("Pulsa enter cuando hayas acabado")
        readln() // Espera a que el usuario pulse Enter
    }

    fun menuPrincipal() {
        println("* MI CUENTA *")
        println("1. Realizar un entrenamiento.")
        println("2. Ver mis datos.")
        println("3. Ver mi historial.")
        println("4. Eliminar usuario.")
        println("5. Atrás.")
        print("¿Qué desea hacer?: ")
    }

}