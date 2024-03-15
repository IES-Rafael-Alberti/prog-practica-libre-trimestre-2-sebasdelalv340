package Entrenamiento

import Usuario.TipoGenero
import Usuario.Usuario

/**
 * Redondea el número decimal a dos decimales.
 *
 * @return El número redondeado.
 */
fun Double.redondear(): Double {
    return (this * 100).toInt().toDouble() / 100
}

/**
 * Clase abstracta que representa un entrenamiento genérico.
 *
 * @property km La cantidad de kilómetros del entrenamiento.
 * @property metros La cantidad de metros del entrenamiento.
 * @property horas La cantidad de horas del entrenamiento.
 * @property minutos La cantidad de minutos del entrenamiento.
 * @property segundos La cantidad de segundos del entrenamiento.
 * @property usuario El usuario que realizó el entrenamiento.
 */
abstract class Entrenamiento(private val km: Int,
                             private val metros: Int,
                             val horas: Int,
                             val minutos: Int,
                             val segundos: Int,
                             usuario: Usuario
){

    var caloriasQuemadas: Double = calcularCalorias(usuario).redondear()

    companion object {
        // Constantes relacionadas con los cálculos de entrenamiento.
        const val TIEMPO = 60
        const val KM = 1000
        const val MET = 8
        const val HORAS_DIA = 24
        const val MB_HOMBRES = 88.362
        const val MB_PESO_HOMBRES = 13.397
        const val MB_ALTURA_HOMBRE = 4.799
        const val MB_EDAD_HOMBRE = 5.677
        const val MB_MUJER = 447.593
        const val MB_PESO_MUJER = 9.247
        const val MB_ALTURA_MUJER = 3.098
        const val MB_EDAD_MUJER = 4.330
    }

    /**
     * Calcula el tiempo total del entrenamiento en minutos.
     *
     * @return El tiempo total del entrenamiento en minutos.
     */
    fun calcularTiempo(): Double {
        return (horas * TIEMPO) + minutos + (segundos / TIEMPO).toDouble()
    }

    /**
     * Calcula la distancia total del entrenamiento en kilómetros.
     *
     * @return La distancia total del entrenamiento en kilómetros.
     */
    fun calcularDistancia(): Double {
        return km + (metros / KM).toDouble()
    }

    /**
     * Calcula el ritmo del entrenamiento en minutos por kilómetro.
     *
     * @return El ritmo del entrenamiento en minutos por kilómetro.
     */
    fun calcularRitmo(): Double {
        return calcularTiempo() / calcularDistancia()
    }

    /**
     * Formatea el tiempo en minutos a un formato de minutos y segundos.
     *
     * @param tiempoEnMinutos El tiempo en minutos a formatear.
     * @return El tiempo formateado en minutos y segundos.
     */
    fun formatoRitmo(tiempoEnMinutos: Double): String {
        val minutos = tiempoEnMinutos.toInt()
        val segundos = ((tiempoEnMinutos - minutos) * TIEMPO).toInt()
        return "$minutos:$segundos"
    }

    /**
     * Calcula las calorías quemadas durante el entrenamiento.
     *
     * @param usuario El usuario que realizó el entrenamiento.
     * @return Las calorías quemadas durante el entrenamiento.
     */
    fun calcularCalorias(usuario: Usuario): Double {
        if (usuario.genero.sexo == TipoGenero.HOMBRE.sexo) {
            val metabolismoBasal = MB_HOMBRES + (MB_PESO_HOMBRES * usuario.peso) + (MB_ALTURA_HOMBRE * usuario.altura) + (MB_EDAD_HOMBRE * usuario.edad)
            return ((metabolismoBasal * MET) / HORAS_DIA) * (calcularTiempo() / TIEMPO)
        } else if (usuario.genero.sexo == TipoGenero.MUJER.sexo) {
            val metabolismoBasal = MB_MUJER + (MB_PESO_MUJER * usuario.peso) + (MB_ALTURA_MUJER * usuario.altura) + (MB_EDAD_MUJER * usuario.edad)
            return ((metabolismoBasal * MET) / HORAS_DIA) * (calcularTiempo() / TIEMPO)
        }
        return 0.0
    }

    /**
     * Convierte el objeto Entrenamiento a una representación de cadena de caracteres.
     *
     * @return Una cadena de caracteres que representa el entrenamiento.
     */
    override fun toString(): String {
        return "Entrenamiento(Tiempo total: ${calcularTiempo()}, distancia: ${calcularDistancia()}, ritmo: ${calcularRitmo()} y calorias quemadas: $caloriasQuemadas kcal)."
    }
}





