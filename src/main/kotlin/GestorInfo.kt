
interface GestorInformacion {
    var historial: MutableMap<String, MutableMap<String, String>>
    fun mostrarInfoUsuario(usuario: Usuario)
    fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento)
}


class GestorInfoEntrenamiento(override var historial: MutableMap<String, MutableMap<String, String>>): GestorInformacion {


    override fun mostrarInfoUsuario(usuario: Usuario) {
        println("Hola ${usuario.nombre}.")
        println("Edad: ${usuario.edad}.")
        println("Peso: ${usuario.peso} kg.")
        println("Altura: ${usuario.altura} cm.")
    }

    override fun mostrarInfo(usuario: Usuario, entrenamiento: Entrenamiento) {
        when (entrenamiento) {
            is Ciclismo -> {
                println("* Datos de tu salida en bici *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Velocidad media: ${entrenamiento.calcularVelocidadMedia()} km/h.")
                println("Vatios: ${entrenamiento.calcularVatios(usuario)} W.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
            is Running -> {
                println("* Datos de tu carrera *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Ritmo: ${entrenamiento.calcularRitmo()} min/km.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
            is Natacion -> {
                println("* Datos de tu natación *")
                println("\nDistancia: ${entrenamiento.calcularDistancia()} km.")
                println("Tiempo total: ${entrenamiento.horas} horas, ${entrenamiento.minutos} minutos y ${entrenamiento.segundos} segundos.")
                println("Ritmo: ${entrenamiento.calcularRitmo()} min/km.")
                println("Brazadas: ${entrenamiento.calcularBrazadas(usuario)}.")
                println("Calorías quemadas: ${entrenamiento.calcularCalorias(usuario)} calorías.")
            }
        }
    }
}