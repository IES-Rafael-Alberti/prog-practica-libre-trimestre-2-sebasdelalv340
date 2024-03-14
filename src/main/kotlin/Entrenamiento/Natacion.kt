package Entrenamiento

import Usuario.Usuario

/**
 * Clase que representa un entrenamiento de natación.
 *
 * @property km La cantidad de kilómetros del entrenamiento.
 * @property metros La cantidad de metros del entrenamiento.
 * @property horas La cantidad de horas del entrenamiento.
 * @property minutos La cantidad de minutos del entrenamiento.
 * @property segundos La cantidad de segundos del entrenamiento.
 * @property usuario El usuario que realizó el entrenamiento.
 */
class Natacion(km: Int,
               metros: Int,
               horas: Int,
               minutos: Int,
               segundos: Int,
               usuario: Usuario
): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {

    private var brazadas: Int = calcularBrazadas(usuario)

    companion object {
        const val PORCENTAJE_BRAZADA = 0.63
        // Porcentajes de la altura para calcular las brazadas.
    }

    /**
     * Calcula el número de brazadas durante el entrenamiento.
     *
     * @param usuario El usuario que realizó el entrenamiento.
     * @return El número de brazadas durante el entrenamiento.
     */
    fun calcularBrazadas(usuario: Usuario): Int {
        val brazada = usuario.altura * PORCENTAJE_BRAZADA
        return ((calcularDistancia() / KM) / brazada).toInt()
    }

    /**
     * Convierte el objeto Natacion a una representación de cadena de caracteres.
     *
     * @return Una cadena de caracteres que representa el entrenamiento de natación.
     */
    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()} min, distancia: ${calcularDistancia()} km, ritmo: ${formatoRitmo(calcularRitmo())} min/km, nº de brazadas: $brazadas y calorías quemadas: $caloriasQuemadas kcal)."
    }
}


