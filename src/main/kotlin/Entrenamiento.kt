abstract class Entrenamiento(val km: Int, val metros: Int, val horas: Int, val minutos: Int, val segundos: Int, usuario: Usuario){

    var caloriasQuemadas: Double = calcularCalorias(usuario)

    companion object {
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

    fun calcularTiempo(): Double {
        return (horas * TIEMPO) + minutos + (segundos / TIEMPO).toDouble() //Devuelve el tiempo en minutos
    }

    fun calcularDistancia(): Double {
        return km + (metros / KM).toDouble() //Devuelve la distancia en km
    }

    fun calcularRitmo(): Double {
        return (calcularTiempo() / calcularDistancia()) //Devuelve el ritmo en min/km
    }

    fun calcularCalorias(usuario: Usuario): Double { //Devuelve kcal
        if (usuario.genero == TipoGenero.HOMBRE) {
            val metabolismoBasal = MB_HOMBRES + (MB_PESO_HOMBRES * usuario.peso) + (MB_ALTURA_HOMBRE * usuario.altura) + (MB_EDAD_HOMBRE * usuario.edad)
            return ((metabolismoBasal * MET) / HORAS_DIA) * (calcularTiempo() / TIEMPO)
        } else if (usuario.genero == TipoGenero.MUJER) {
            val metabolismoBasal = MB_MUJER + (MB_PESO_MUJER * usuario.peso) + (MB_ALTURA_MUJER * usuario.altura) + (MB_EDAD_MUJER * usuario.edad)
            return ((metabolismoBasal * MET) / HORAS_DIA) * (calcularTiempo() / TIEMPO)
        }
        return 0.0
    }

    override fun toString(): String {
        return "Entrenamiento(Tiempo total: ${calcularTiempo()}, distancia: ${calcularDistancia()}, ritmo: ${calcularRitmo()} y calorias quemadas: $caloriasQuemadas)."
    }
}





