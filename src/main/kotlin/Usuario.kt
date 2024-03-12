enum class TipoGenero(val sexo: String) {
    HOMBRE("Hombre"), MUJER("Mujer")
}

class Usuario(val nombre: String, val genero: TipoGenero, var edad: Int, val altura: Int, var peso: Double, val password: Int) {


    init {
        require(edad in 0..100) {"La edad debe ser un valor entre 0 y 100."}
        require(altura in 0..250) {"La altura debe ser un valor entre 0 y 250."}
        require(peso in 0.0..200.0) {"El peso debe ser un valor entre 0 y 200."}
    }

}