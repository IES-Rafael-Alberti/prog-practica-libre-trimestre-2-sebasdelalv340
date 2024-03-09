enum class TipoGenero(val sexo: String) {
    HOMBRE("Hombre"), MUJER("Mujer")
}

class Usuario(nombre: String, val genero: TipoGenero, var edad: Int, val altura: Int, var peso: Double) {

    var nombre: String = comprobarNombre(nombre)
        get() = capitalizar(field)

    init {
        require(edad in 0..100) {"La edad debe ser un valor entre 0 y 100."}
        require(altura in 0..250) {"La altura debe ser un valor entre 0 y 250."}
        require(peso in 0.0..200.0) {"El peso debe ser un valor entre 0 y 200."}
    }

    companion object {
        private var listaNombre: MutableSet<String> = mutableSetOf()
    }

    override fun toString(): String {
        return "$nombre, género: ${genero.sexo}, edad: $edad, altura: $altura y peso: $peso."
    }


    private fun comprobarNombre(nombre: String): String {
        val nombreAComprobar = nombre.lowercase().trim()
        require(nombre.isNotEmpty()) {"El $nombre no puede estar vacío."}
        listaNombre.add(nombreAComprobar)
        return nombreAComprobar
    }

    private fun capitalizar(nombre: String): String {
        return nombre.split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase()} }
    }
}