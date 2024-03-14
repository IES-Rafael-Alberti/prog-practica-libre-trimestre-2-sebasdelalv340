package Entrenamiento

import Usuario.Usuario

class Ciclismo(km: Int, metros: Int, horas: Int, minutos: Int, segundos: Int, usuario: Usuario): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {
    private var vatios: Double = calcularVatios(usuario).redondear(2)

    companion object {
        const val ACELERACION_GRAVITATORIA = 9.81
    }

    fun calcularVelocidadMedia(): Double {
        return calcularDistancia() / (calcularTiempo() / Entrenamiento.Companion.TIEMPO)
    }

    fun calcularVatios(usuario: Usuario): Double {
        val distancia = calcularDistancia() * Entrenamiento.Companion.KM
        val tiempo = calcularTiempo() * Entrenamiento.Companion.TIEMPO
        val fuerza = usuario.peso * ACELERACION_GRAVITATORIA
        val trabajo = fuerza * distancia
        vatios = trabajo / tiempo
        return vatios
    }

    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()} min, distancia: ${calcularDistancia()} km, ritmo: ${formatoRitmo(calcularRitmo())} min/km, velocidad media: ${vatios.redondear(2)} W y calorías quemadas: ${caloriasQuemadas.redondear(2)} kcal"
    }

}