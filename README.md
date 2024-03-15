[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/NBVXLiSy)
# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2324_PRO_u4u5u6_libre

**Agrupamiento de la actividad**: Individual 

---

### Descripción:

La actividad consiste en el desarrollo de un proyecto software en Kotlin, permitiendo al estudiante elegir la temática. Este proyecto debe demostrar la comprensión y aplicación de los conceptos de programación orientada a objetos (POO), incluyendo la definición y uso de clases, herencia, interfaces, genericos, principios SOLID y el uso de librerías externas.

**Objetivo:**

- Demostrar comprensión de los fundamentos de POO mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas, e interfaces.
- Crear y usar clases que hagan uso de genéricos. 
- Aplicar principios SOLID.
- Integrar y utilizar librerías de clases externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

**Trabajo a realizar:**

1. **Selección de la Temática:** Elige un tema de tu interés que pueda ser abordado mediante una aplicación software. Esto podría ser desde una aplicación de gestión para una pequeña empresa, una herramienta para ayudar en la educación, hasta un juego simple. Define claramente el problema que tu aplicación pretende resolver.

2. **Planificación:** Documenta brevemente cómo tu aplicación solucionará el problema seleccionado, incluyendo las funcionalidades principales que desarrollarás.

3. **Desarrollo:**
   - **Instancia de Objetos:** Tu aplicación debe crear y utilizar objetos, demostrando tu comprensión de la instanciación y el uso de constructores, métodos, y propiedades.
   - **Métodos Estáticos:** Define y utiliza al menos un método estático, explicando por qué es necesario en tu aplicación.
   - **Uso de IDE:** Desarrolla tu proyecto utilizando un IDE, aprovechando sus herramientas para escribir, compilar, y probar tu código.
   - **Definición de Clases:** Crea clases personalizadas con sus respectivas propiedades, métodos, y constructores.
   - **Clases con genéricos:** Define y utiliza al menos una clase que haga uso de genéricos en tu aplicación.
   - **Herencia y Polimorfismo:** Implementa herencia y/o interfaces en tu proyecto para demostrar la reutilización de código y la flexibilidad de tu diseño.  **Usa los principios SOLID:** Ten presente durante el desarrollo los principios SOLID y úsalos durante el diseño para mejorar tu aplicación.
   - **Librerías de Clases:** Integra y utiliza una o más librerías externas que enriquezcan la funcionalidad de tu aplicación.
   - **Documentación:** Comenta tu código de manera efectiva, facilitando su comprensión y mantenimiento.

4. **Prueba y Depuración:** Realiza pruebas para asegurarte de que tu aplicación funciona como se espera y depura cualquier error encontrado.
5. **Contesta a las preguntas** ver el punto **Preguntas para la Evaluación**

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rubrica**: Mas adelante se mostrará la rubrica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse en este fichero, README.md


# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, **asegúrate de hacer referencia y enlazar al código relevante** en tu `README.md`, facilitando así la evaluación de tu trabajo.


#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.

Los objetos instanciados en el funcionamiento principal son los relativos a las clases que se encargan de la gestión, registro, input/output de datos, así como el menu de usuario.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/9419710aa22bd407aa2674b217e939aa228fd963/src/main/kotlin/Main.kt#L8-L14

Los objetos relativos a los datos en sí (usuario y entrenamientos) se instancian dentro de los métodos de las clases anteriormente mencionadas, puesto que sus propiedades son introducidas por consola por el usuario.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/9419710aa22bd407aa2674b217e939aa228fd963/src/main/kotlin/Gestores/RegistroUsuario.kt#L238-L249

En cuanto a los constructores, se han utilizado constructores primarios, ya que las propiedades tanto de usuario como de entrenamiento son todas necesarias y de tipo muy concreto. Por lo tanto no existía la necesidad de incorporar constructores secundarios que permitieran instanciar objetos con alguna propiedad menos o de un tipo distinto.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/9419710aa22bd407aa2674b217e939aa228fd963/src/main/kotlin/Usuario/Usuario.kt#L23-L38

Respecto a los métodos, existen múltiples ejemplos diferentes, ya que reciben tanto propiedades, la salida de otro método como objetos.
Por ejemplo, aquí recibe el resultado de otro método para transformar el formato de salida antes de mostrarlo.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/9419710aa22bd407aa2674b217e939aa228fd963/src/main/kotlin/Entrenamiento/Entrenamiento.kt#L74-L88


#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

  Se ha definido diversas propiedades estáticas, declaradas como constantes, puesto que ciertas clases necesitan realizar cálculos matemáticos y el uso de estas constantes facilita la tarea para no repetir mucho código, y en el caso de necesitar modificar esos datos solo realizar dicha modificación en un único lugar.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/9419710aa22bd407aa2674b217e939aa228fd963/src/main/kotlin/Entrenamiento/Entrenamiento.kt#L35-L49

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

Para el desarrollo del presente proyecto se ha utilizado IntelliJ y la base en Gradle como sistema constructor.

El IDE junto con Github, para almacenar en un repositorio los avances del proyecto, ha permitido guardar diferentes versiones del proyecto a medida que avanzaba en su desarrollo. Al respecto, el IDE facilita mucho la tarea pues nos permite gestionar estos avances sin necesidad de usar la terminal. Si se ha notado, respecto a otros sistemas constructores, que Gradle es más lento a la hora de compilar.

Otro punto que aporta el IDE es la depuración de código mediante el debuger. Insertando puntos de ruptura en las líneas de código donde creemos que puede estar el problema por el cual el resultado obtenido no es el esperado.

Dentro del debuger contamos con una herramienta 'Watchlist' que nos muestra los valores asignados a las variables mientras vamos avanzando en la depuración del código donde tenemos el problema. Esto nos permite ir siguiendo el flujo del programa e identificar los errores.

Personalmente me fui muy útil, en concreto, me ayudo a resolver un problema con un método que se encargaba de buscar a un usuario dentro de un mapa de Usuarios y siempre me devolvía nulo.

Las pruebas del programas se realizan mediante pruebas unitarias a través de JUnit5.


#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

**Expondré dos ejemplos:**

El primero es la clase **Ciclismo** que hereda de la clase **Entrenamiento**, en la que además de contar con las propiedades de su superclase, hemos añadido la propiedad **vatios**, que la usaremos para comparar nuestras sesiones en bici.

Como se puede ver en el ejemplo, esta clase tiene todas sus propiedades abiertas, excepto **vatios** que solo es relativa a esta clase en concreto, y los métodos también están abiertos puesto que se llaman desde otras clases y necesitamos mantenerlos así.

Tanto esta clase como el resto que heredan de **Entrenamiento** nos permiten diferenciar entre los tipos de entrenamiento lo que nos facilita su gestión en otras clases.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/0ad90277ceb1c7c1f675f141e498ac1b49eeed5f/src/main/kotlin/Entrenamiento/Ciclismo.kt#L15-L63

El segundo es la clase **RegistroUsuario**, que se encarga de registrar los usuarios nuevos, permitir el acceso a usuarios ya registrados y eliminar usuarios.

Las propiedades que contiene esta clase es una lista que contiene el registro de los distintos usuarios y otra propiedad estática que mantiene un registro de los nombres usados por los usuarios e impide que un usuario se registre con un nombre ya existente.

La mayoría de sus métodos son privados, ya que su uso es exclusivo de su clase. Solo dicha clase podrá pedir los datos relativos a los usuarios permitiéndome centrar esta función en una sola clase.

Los métodos **registrarUsuario** y **eliminarUsuario** no son privados puesto que se llaman desde otra clase, pero los datos que reciben son retornados por las propiedades y el resto de métodos privados de la clase que si son privados, lo que mantiene la funcionalidad cerrada.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/9419710aa22bd407aa2674b217e939aa228fd963/src/main/kotlin/Gestores/RegistroUsuario.kt#L11-L273


#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?

Como se ha podido ver en algún estracto de código anterior, la clase **Entrenamiento** es abstracta, ya que las clases que heredan de ellan deben implementar sus propiedades y métodos, aunque luego a las subclases se les extienda su funcionalidad.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/84203acd8ad50fae0367fd5eca67d68415a34830/src/main/kotlin/Entrenamiento/Entrenamiento.kt#L25-L31

**En cuanto a interfaces:**

La clase **GestorInfoEntrenamiento** se encarga de gestionar la información relativa a los diferentes tipos de entrenamientos e implementa la interfaz **GestorInformación** que contiene una mapa para almacenar un historial por cada usuario y para cada usuario un mapa con el historial de cada entrenamiento **'MutableMap<String, MutableMap<String, String>>'**.

La idea principal era crear dos interfaces, una para gestionar la información del usuario y otra para la información de los entrenamientos, pero la función destinaada al usuario era tan reducida que se incluyó las dos en la misma interfaz, por lo que la clase **GestorInfoEntrenamiento** contiene un método que muestra la información relativa al usuario.
Incumplimos lso principios de responsabilidad única y segregación de interfaces pero con conocimiento de ello.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/9419710aa22bd407aa2674b217e939aa228fd963/src/main/kotlin/Gestores/GestorInfo.kt#L12-L34

Un ejemplo de todo lo contrario es el objeto **Consola, que se encarga de input/ouput de datos por consola. La idea de que sea un objeto es para que pueda ser usada en cualquier parte del programa sin necesidad de ser intanciada y no queremos crear ningún objeto a partir de ella.

Aquí creamos dos interfaces **Notificador** y **EntradaDatos** e implementamos ambas en el objeto **Consola**. Esto nos permite dividir la funcionalidad y si quisieramos, crear dos consolas diferentes, una para los inputs y otra para los ouputs.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/84203acd8ad50fae0367fd5eca67d68415a34830/src/main/kotlin/Consola/Consola.kt#L6-L25


#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

El proyecto dispone de varias clases que se encargan de la gestión de los datos, información de otras clases, etc...pero no se realiza ningún tipo de herencia a partir de ellas, pero estas clases si extienden su funcionalidad a partir de las interfaces que implementan.

Como la clase **Usuario** es una data class, no realizamos ninguna herencia, pero es lo que buscamos porque el usuario solo va a almacenar sus datos.

En la clase **Entrenamiento vemos una especialización respecto a sus subclases **Running**, **Ciclismo** y **Natacion**, ya que representan una más específica de su clase base. Además de heredar las propiedades y métodos de su clase base introducen otras características como el cálculo de vatios en **Ciclismo y del número de brazadas en **Natacion**.

Por último, se ha creado una clase genérica **Pila**, de la que se hablará más detenidamente en el 'Criterio 9', que no cumple exactamente con una herencia de construcción porque no hereda de otra clase génerica, sino que se usa en listas que se instancian como **Pila.


#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

La única librería incorporada realmente es la de JUnit5 para realizar un test sobre la función **buscarUsuario**.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-sebasdelalv340/blob/9419710aa22bd407aa2674b217e939aa228fd963/src/main/kotlin/Test/RegistroUsuarioTest.kt#L3-L21

En algún momento existió la incorporación de una librería para limpiar la consola, pero no se consiguió los resultados esperados y fue eliminada. Y otra para mostrar el texto por consola con colores, pero esta funcionalidad ya se incluye en kotlin, por lo que también fué eliminada.

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

El lenguaje utilizado para la documentación del proyecto es **KDoc**

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

