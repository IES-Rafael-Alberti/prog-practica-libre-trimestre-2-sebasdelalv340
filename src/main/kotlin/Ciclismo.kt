class Ciclismo(km: Int, metros: Int, horas: Int, minutos: Int, segundos: Int, usuario: Usuario): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {
    private var vatios: Double = 0.0

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
        return "Tiempo total: ${calcularTiempo()}, distancia: ${calcularDistancia()}, ritmo: ${calcularRitmo()}, calorias quemadas: $caloriasQuemadas y velocidad media: $vatios."
    }

}