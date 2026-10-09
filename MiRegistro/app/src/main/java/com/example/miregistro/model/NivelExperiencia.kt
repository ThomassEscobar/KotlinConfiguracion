package com.example.miregistro.model

enum class NivelExperiencia(val etiqueta: String){
    PRINCIPIANTE("Principiante"),
    INTERMEDIO("Intermedio"),
    AVANZADO("Avanzado")

}
//estructura de datos
data class FormularioUistate(
    val nombre: String = "",
    val correo: String = "",
    val constrasena: String = "",
    val nivel: NivelExperiencia = NivelExperiencia.PRINCIPIANTE,
    val recibirNoticias: Boolean = false,
    val aceptarTerminos: Boolean = false,

    //estado visual de la clave
    val constrasenaVisible: Boolean = false,

    //errores de los campos
    val errorNombre: String? = null,
    val errorCorreo: String? = null,
    val errorConstrasena: String? = null,
    val errorTerminos: String? = null

    //resultados del formulario
    val registroExitoso: Boolean = false
)