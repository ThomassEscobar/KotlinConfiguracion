package com.example.miregistro.viewmodel

import androidx.lifecycle.ViewModel
import com.example.miregistro.model.FormularioUistate
import com.example.miregistro.model.NivelExperiencia
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormularioViewModel: ViewModel(){
    //privada y mutable
    private val _uistate = MutableStateFlow(FormularioUistate())

    val uistate: StateFlow<FormularioUistate> = _uistate.asStateFlow()

    //Eventos de los campos
    fun onNombreCambia(valor: String){
        _uistate.update { it.copy(nombre = valor, errorNombre = null, registroExitoso = false) }
    }
    fun onCorreoCambia(valor: String){
        _uistate.update { it.copy(correo = valor, errorCorreo = null, registroExitoso = false) }
    }
    fun onConstrasenaCambia(valor: String){
        _uistate.update { it.copy(constrasena = valor, errorConstrasena = null, registroExitoso = false) }
    }
    fun onAlternarVisibilidad(){
        _uistate.update { it.copy(constrasenaVisible = !it.constrasenaVisible) }
    }

    //eventos para los controles de seleccion
    fun onNivelSeleccionado(nivel: NivelExperiencia){
        _uistate.update { it.copy(nivel = nivel) }
    }
    fun onNoticiasCambio(valor: Boolean){
        _uistate.update { it.copy(aceptarTerminos = valor, errorTerminos = null) }
    }
    fun onTerminosCambio(valor: Boolean){
        _uistate.update { it.copy(aceptarTerminos = valor, errorTerminos = null) }
    }


    //botones

    //boton limpiar
    fun onLimpiar(){
        _uistate.value = FormularioUistate()
    }
    //boton registrar
    fun onRegistrar(){
        val estado = _uistate.value
        //validar los campos
        val errorNombre = if (estado.nombre.isBlank())"El nombre es obligatorio" else null
        val errorContrasena = if (estado.constrasena.length <6)"Minimo 6 caracteres" else null
        val errorcorreo = if(estado.correo.contains("@")|| !estado.correo.contains("."))
            "Ingrese un correo valido" else null
        val errorTerminos = if(!estado.aceptarTerminos)"Debes aceptar los terminos" else null

        //verificar si existen errores

        val hayErrores = listOf(errorNombre,errorContrasena,errorcorreo,errorTerminos).any { it!= null }
        _uistate.update { it.copy(
            errorNombre = errorNombre,
            errorConstrasena = errorContrasena,
            errorCorreo = errorcorreo,
            errorTerminos = errorTerminos,
            registroExitoso = !hayErrores
        ) }
    }
}