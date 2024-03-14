package Entrenamiento

import Usuario.Usuario

/**
 * Clase que representa un entrenamiento de running.
 *
 * @property km La cantidad de kilómetros del entrenamiento.
 * @property metros La cantidad de metros del entrenamiento.
 * @property horas La cantidad de horas del entrenamiento.
 * @property minutos La cantidad de minutos del entrenamiento.
 * @property segundos La cantidad de segundos del entrenamiento.
 * @property usuario El usuario que realizó el entrenamiento.
 */
class Running(km: Int,
              metros: Int,
              horas: Int,
              minutos: Int,
              segundos: Int,
              usuario: Usuario
): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {

    /**
     * Convierte el objeto Running a una representación de cadena de caracteres.
     *
     * @return Una cadena de caracteres que representa el entrenamiento de running.
     */
    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()} min, distancia: ${calcularDistancia()} km, ritmo: ${formatoRitmo(calcularRitmo())} min/km y calorías quemadas: $caloriasQuemadas. kcal."
    }
}