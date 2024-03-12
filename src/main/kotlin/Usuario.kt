enum class TipoGenero(val sexo: String) {
    HOMBRE("Hombre"), MUJER("Mujer")
}

class Usuario(nombre: String, val genero: TipoGenero, var edad: Int, val altura: Int, var peso: Double, val password: Int) {

    var nombre: String = nombre
        get() = capitalizar(field)
        private set

    init {
        require(edad in 0..100) {"La edad debe ser un valor entre 0 y 100."}
        require(altura in 0..250) {"La altura debe ser un valor entre 0 y 250."}
        require(peso in 0.0..200.0) {"El peso debe ser un valor entre 0 y 200."}
    }

    private fun capitalizar(nombre: String): String {
        return nombre.split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase()} }
    }
}