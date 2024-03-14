package Pila

/**
 * Una clase genérica que representa una pila (stack) de elementos.
 * Puede contener elementos de cualquier tipo.
 * @param T el tipo de elementos que se almacenarán en la pila.
 */
class Pila<T> {
    private var lista: MutableList<T> = mutableListOf()

    /**
     * Retorna el elemento en la cima de la pila sin eliminarlo.
     * @return el elemento en la cima de la pila, o null si la pila está vacía.
     */
    fun top(): T? {
        return if (lista.isNotEmpty()) {
            lista[lista.size - 1]
        } else {
            null
        }
    }

    /**
     * Inserta un elemento en la cima de la pila.
     * @param elemento el elemento a insertar.
     */
    fun push(elemento: T) {
        lista.add(elemento)
    }

    /**
     * Elimina y retorna el elemento en la cima de la pila.
     * @return el elemento en la cima de la pila, o null si la pila está vacía.
     */
    fun pop(): T? {
        return if (lista.isNotEmpty()) {
            lista.removeAt(lista.size - 1)
        } else {
            null
        }
    }

    /**
     * Comprueba si la pila está vacía.
     * @return true si la pila está vacía, false de lo contrario.
     */
    fun isEmpty(): Boolean {
        return lista.isEmpty()
    }
}
