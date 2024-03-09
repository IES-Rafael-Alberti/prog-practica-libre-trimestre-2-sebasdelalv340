class Running(km: Int, metros: Int, horas: Int, minutos: Int, segundos: Int, usuario: Usuario): Entrenamiento(km, metros, horas, minutos, segundos, usuario) {

    override fun toString(): String {
        return "Tiempo total: ${calcularTiempo()}, distancia: ${calcularDistancia()}, ritmo: ${calcularRitmo()} y calorias quemadas: $caloriasQuemadas."
    }
}