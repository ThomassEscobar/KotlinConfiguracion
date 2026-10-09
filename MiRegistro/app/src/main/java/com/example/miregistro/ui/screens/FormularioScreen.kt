package com.example.miregistro.ui.screens

import androidx.compose.runtime.Composable
import com.example.miregistro.model.FormularioUistate
import com.example.miregistro.model.NivelExperiencia

@Composable
fun FormularioContent(
    uistate: FormularioUistate,
    onNombreCambia: (String) -> Unit,
    onCorreoCambia: (String) -> Unit,
    onContrasenaCambia: (String) -> Unit,
    onAlternarVisibilidad: () -> Unit,
    onNivelSeleccionado: (NivelExperiencia) -> Unit,
    onNoticiasCambia: (Boolean) -> Unit,
    onTerminosCambia: (Boolean) -> Unit,
    onLimpiar: () -> Unit,
    onRegistrar: () -> Unit

    ){

}