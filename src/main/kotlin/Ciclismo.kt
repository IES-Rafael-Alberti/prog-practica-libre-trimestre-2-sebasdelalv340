class Ciclismo(km: Int, metros: Int, horas: Int, minutos: Int, segundos: Int, usuario: Usuario): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {
    private var vatios: Double = calcularVatios(usuario)

    companion object {
        const val ACELERACION_GRAVITATORIA = 9.81
    }

    fun calcularVelocidadMedia(): Double {
        return calcularDistancia() / (calcularTiempo() / TIEMPO) // Devuelve km/h
    }

    fun calcularVatios(usuario: Usuario): Double { //Devuelve vatios
        val distancia = calcularDistancia() * KM
        val tiempo = calcularTiempo() * TIEMPO
        val fuerza = usuario.peso * ACELERACION_GRAVITATORIA
        val trabajo = fuerza * distancia
        vatios = trabajo / tiempo
        return vatios
    }

    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()} min, distancia: ${calcularDistancia()} km, ritmo: ${formatoRitmo(calcularRitmo())} min/km, velocidad media: $vatios W y calorías quemadas: ${"%.2f".format(caloriasQuemadas)} kcal"
    }

}