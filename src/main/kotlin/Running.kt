class Running(km: Int, metros: Int, horas: Int, minutos: Int, segundos: Int, usuario: Usuario): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {

    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()} min, distancia: ${calcularDistancia()} km, ritmo: ${formatoRitmo()} min/km y calorías quemadas: $caloriasQuemadas kcal."
    }
}