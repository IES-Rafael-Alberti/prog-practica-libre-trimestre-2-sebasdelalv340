package Entrenamiento

import Usuario.Usuario

class Natacion(km: Int, metros: Int, horas: Int, minutos: Int, segundos: Int, usuario: Usuario): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {

    private var brazadas: Int = calcularBrazadas(usuario)

    companion object {
        const val PORCENTAJE_BRAZADA = 0.63
    }

    fun calcularBrazadas(usuario: Usuario): Int {
        val brazada = usuario.altura * PORCENTAJE_BRAZADA
        return ((calcularDistancia() / KM) / brazada).toInt()
    }

    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()} min, distancia: ${calcularDistancia()} km, ritmo: ${formatoRitmo(calcularRitmo())} min/km, nº de brazadas: $brazadas y calorías quemadas: ${caloriasQuemadas.redondear(2)} kcal)."
    }
}


