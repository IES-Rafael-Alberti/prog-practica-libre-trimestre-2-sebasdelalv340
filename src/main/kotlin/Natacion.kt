class Natacion(km: Int, metros: Int, horas: Int, minutos: Int, segundos: Int, usuario: Usuario): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {
    var brazadas: Int = calcularBrazadas(usuario)

    companion object {
        const val PORCENTAJE_BRAZADA = 0.63
    }

    fun calcularBrazadas(usuario: Usuario): Int { // Devuelve número de brazadas
        val brazada = usuario.altura * PORCENTAJE_BRAZADA
        return ((calcularDistancia() / KM) / brazada).toInt()
    }

    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()} min, distancia: ${calcularDistancia()} km, ritmo: ${formatoRitmo()} min/km, nº de brazadas: $brazadas y calorías quemadas: $caloriasQuemadas kcal)."
    }
}


