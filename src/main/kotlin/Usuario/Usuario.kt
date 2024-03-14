package Usuario

/**
 * Enumeración que representa los tipos de género.
 *
 * @property sexo El nombre del género.
 */
enum class TipoGenero(val sexo: String) {
    HOMBRE("Hombre"), MUJER("Mujer")
}


/**
 * Clase que representa un usuario.
 *
 * @property nombre El nombre del usuario.
 * @property genero El género del usuario.
 * @property edad La edad del usuario (debe estar entre 0 y 100).
 * @property altura La altura del usuario (debe estar entre 0 y 250).
 * @property peso El peso del usuario (debe estar entre 0 y 200).
 * @property password La contraseña del usuario.
 */
data class Usuario(
    val nombre: String,
    val genero: TipoGenero,
    var edad: Int,
    val altura: Int,
    var peso: Double,
    val password: Int
) {

    init {
        require(edad in 0..100) {"La edad debe ser un valor entre 0 y 100."}
        require(altura in 0..250) {"La altura debe ser un valor entre 0 y 250."}
        require(peso in 0.0..200.0) {"El peso debe ser un valor entre 0 y 200."}
    }

}