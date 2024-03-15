package Entrenamiento

import Usuario.Usuario

/**
 * Clase que representa un entrenamiento de ciclismo.
 *
 * @property km La cantidad de kilómetros del entrenamiento.
 * @property metros La cantidad de metros del entrenamiento.
 * @property horas La cantidad de horas del entrenamiento.
 * @property minutos La cantidad de minutos del entrenamiento.
 * @property segundos La cantidad de segundos del entrenamiento.
 * @property usuario El usuario que realizó el entrenamiento.
 */
class Ciclismo(km: Int,
               metros: Int,
               horas: Int,
               minutos: Int,
               segundos: Int,
               usuario: Usuario
): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {

    private var vatios: Double = calcularVatios(usuario).redondear()

    companion object {
        const val ACELERACION_GRAVITATORIA = 9.81
        // Constante que solo sirve en ciclismo.
    }

    /**
     * Calcula la velocidad media del entrenamiento.
     *
     * @return La velocidad media del entrenamiento en km/h.
     */
    fun calcularVelocidadMedia(): Double {
        return (calcularDistancia() / (calcularTiempo() / TIEMPO)).redondear()
    }

    /**
     * Calcula los vatios generados durante el entrenamiento.
     *
     * @param usuario El usuario que realizó el entrenamiento.
     * @return Los vatios generados durante el entrenamiento.
     */
    fun calcularVatios(usuario: Usuario): Double {
        val distancia = calcularDistancia() * Entrenamiento.Companion.KM
        val tiempo = calcularTiempo() * Entrenamiento.Companion.TIEMPO
        val fuerza = usuario.peso * ACELERACION_GRAVITATORIA
        val trabajo = fuerza * distancia
        vatios = trabajo / tiempo
        return vatios.redondear()
    }

    /**
     * Convierte el objeto Ciclismo a una representación de cadena de caracteres.
     *
     * @return Una cadena de caracteres que representa el entrenamiento de ciclismo.
     */
    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()} min, distancia: ${calcularDistancia()} km, ritmo: ${formatoRitmo(calcularRitmo())} min/km, velocidad media: $vatios W y calorías quemadas: $caloriasQuemadas kcal"
    }

}