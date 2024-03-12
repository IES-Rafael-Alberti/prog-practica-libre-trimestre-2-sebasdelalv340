class ControlMenu {
    fun menuAcceso(registroUsuario: RegistroUsuario): Usuario? {
        var opcion: Int
        do {
            Consola.menuAcesso()
            Consola.enviar("Introduzca una opción: ")
            opcion = Consola.leerEntero()

            when (opcion) {
                1 -> {
                    val salida = registroUsuario.loginUsuario()
                    if (salida != null) {
                        return salida
                    } else {
                        opcion = 0
                    }
                }
                2 -> return registroUsuario.registrarUsuario()
                3 -> Consola.enviar("Hasta pronto.\n")
                else -> Consola.enviar("Opción no válida\n")
            }
        } while (opcion != 3)
        return null
    }


    private fun menuHistorial(usuario: Usuario, gestorInfoEntrenamiento: GestorInfoEntrenamiento) {
        var opcion: Int
        do {
            Consola.menuHistorial()
            opcion = Consola.leerEntero()

            when (opcion) {
                1 -> gestorInfoEntrenamiento.mostrarHistorialRunning(usuario)
                2 -> gestorInfoEntrenamiento.mostrarHistorialCiclismo(usuario)
                3 -> gestorInfoEntrenamiento.mostrarHistorialNatacion(usuario)
                4 -> {
                    gestorInfoEntrenamiento.mostrarHistorialRunning(usuario)
                    gestorInfoEntrenamiento.mostrarHistorialCiclismo(usuario)
                    gestorInfoEntrenamiento.mostrarHistorialNatacion(usuario)
                }
                5 -> Consola.enviar("Volviendo al menú principal.\n")
                else -> Consola.enviar("Opción no válida\n")
            }
        } while (opcion != 5)
    }

    private fun menuEntrenamiento(usuario: Usuario, gestorInfoEntrenamiento: GestorInfoEntrenamiento, gestorEntrenamiento: GestorEntrenamiento) {
        var opcion: Int
        do {
            Consola.menuEntrenamiento()
            opcion = Consola.leerEntero()

            when (opcion) {
                1 -> {
                    Consola.mostrarEntrenando()
                    if (gestorEntrenamiento.pedirRegistro()) {
                        val datosRunning = gestorEntrenamiento.pedirDatosRunning(usuario)
                        gestorInfoEntrenamiento.registrarEntrenamiento(usuario, datosRunning)
                        gestorInfoEntrenamiento.mostrarInfo(usuario, datosRunning)
                        gestorInfoEntrenamiento.compararMejoras(usuario, datosRunning)
                        gestorInfoEntrenamiento.actualizarHistorialMejoras(usuario, datosRunning)
                    }
                }
                2 -> {
                    Consola.mostrarEntrenando()
                    if (gestorEntrenamiento.pedirRegistro()) {
                        val datosCiclismo = gestorEntrenamiento.pedirDatosCiclismo(usuario)
                        gestorInfoEntrenamiento.registrarEntrenamiento(usuario, datosCiclismo)
                        gestorInfoEntrenamiento.mostrarInfo(usuario, datosCiclismo)
                        gestorInfoEntrenamiento.compararMejoras(usuario, datosCiclismo)
                        gestorInfoEntrenamiento.actualizarHistorialMejoras(usuario, datosCiclismo)
                    }
                }
                3 -> {
                    Consola.mostrarEntrenando()
                    if (gestorEntrenamiento.pedirRegistro()) {
                        val datosNatacion = gestorEntrenamiento.pedirDatosNatacion(usuario)
                        gestorInfoEntrenamiento.registrarEntrenamiento(usuario, datosNatacion)
                        gestorInfoEntrenamiento.mostrarInfo(usuario, datosNatacion)
                        gestorInfoEntrenamiento.compararMejoras(usuario, datosNatacion)
                        gestorInfoEntrenamiento.actualizarHistorialMejoras(usuario, datosNatacion)
                    }
                }
                4 -> Consola.enviar("Volviendo al menú principal.\n")
                else -> Consola.enviar("Opción no válida\n")
            }
        } while (opcion != 4)
    }

    fun menuPrincipal(usuario: Usuario, gestorInfoEntrenamiento: GestorInfoEntrenamiento, registroUsuario: RegistroUsuario, gestorEntrenamiento: GestorEntrenamiento) {
        var opcion: Int
        do {
            Consola.enviar("Hola ${usuario.nombre}\n")
            Consola.menuPrincipal()
            opcion = Consola.leerEntero()

            when (opcion) {
                1 -> menuEntrenamiento(usuario, gestorInfoEntrenamiento, gestorEntrenamiento)
                2 -> gestorInfoEntrenamiento.mostrarInfoUsuario(usuario)
                3 -> menuHistorial(usuario, gestorInfoEntrenamiento)
                4 -> registroUsuario.eliminarUsuario()
                5 -> Consola.enviar("Volviendo a inicio.\n")
                else -> Consola.enviar("Opción no válida\n")
            }
        } while (opcion != 5)
    }

    fun controlMenus(registroUsuario: RegistroUsuario, gestorEntrenamiento: GestorEntrenamiento, gestorInfoEntrenamiento: GestorInfoEntrenamiento): Usuario? {
        var continuar = true
        do {
            val salida = menuAcceso(registroUsuario)
            if (salida != null) {
                menuPrincipal(salida, gestorInfoEntrenamiento, registroUsuario, gestorEntrenamiento)
            } else {
                continuar = false
            }
        } while (continuar)
        return null
    }
}