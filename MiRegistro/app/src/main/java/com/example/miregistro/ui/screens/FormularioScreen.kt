package com.example.miregistro.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.miregistro.R
import com.example.miregistro.model.FormularioUistate
import com.example.miregistro.model.NivelExperiencia
import com.example.miregistro.ui.components.BotonPrincipal
import com.example.miregistro.ui.components.BotonSecundario
import com.example.miregistro.ui.components.CampoContrasena
import com.example.miregistro.ui.components.CampoTexto
import com.example.miregistro.ui.components.CasillaConTexto
import com.example.miregistro.ui.components.GrupoRadio
import com.example.miregistro.ui.components.ImagenEncabezado
import com.example.miregistro.ui.components.InterruptorConTexto
import com.example.miregistro.ui.components.TarjetaSeccion
import com.example.miregistro.ui.theme.Dimens

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
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.titulo_formulario)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(
                    rememberScrollState()
                )
        ){
            ImagenEncabezado(
                imagen = R.drawable.banner_registro,
                descripcion = stringResource(R.string.cd_banner),
                titulo = stringResource(R.string.banner_titulo),
                subtitulo = stringResource(R.string.banner_subtitulo)
            )
            Column(
                modifier = Modifier.padding(Dimens.espacioPantalla),
                verticalArrangement = Arrangement.spacedBy(Dimens.espacioMedio)
            ){
                //Card 1 - Datos Personales
                TarjetaSeccion(titulo = stringResource(R.string.seccion_datos)) {
                    CampoTexto(
                        valor = uistate.nombre,
                        onValorCambia = onNombreCambia,
                        etiqueta = stringResource(R.string.campo_nombre),
                        icono = R.drawable.ic_persona,
                        error = uistate.errorNombre
                    )
                    CampoTexto(
                        valor = uistate.correo,
                        onValorCambia = onCorreoCambia,
                        etiqueta = stringResource(R.string.campo_correo),
                        icono = R.drawable.ic_correo,
                        error = uistate.errorCorreo,
                        tipoTeclado = KeyboardType.Email
                    )
                    CampoContrasena(
                        valor = uistate.constrasena,
                        onValorCambia = onContrasenaCambia,
                        etiqueta = stringResource(R.string.campo_contrasena),
                        visible = uistate.constrasenaVisible,
                        onAlternarVisible = onAlternarVisibilidad,
                        error = uistate.errorConstrasena
                    )
                }
                //Card 2 - Perferencias
                TarjetaSeccion(titulo = stringResource(R.string.seccion_preferencias)) {
                    Text(
                        text = stringResource(R.string.etiqueta_nivel),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    GrupoRadio(
                        opciones = NivelExperiencia.entries,
                        seleccionada = uistate.nivel,
                        onSeleccionar = onNivelSeleccionado,
                        textoDe = {it.etiqueta}
                    )
                    InterruptorConTexto(
                        texto = stringResource(R.string.opcion_noticias),
                        activado = uistate.recibirNoticias,
                        onCambio = onNoticiasCambia
                    )
                }
                //Termino
                Column{
                    CasillaConTexto(
                        texto = stringResource(R.string.opcionterminos),
                        marcado = uistate.aceptarTerminos,
                        onCambio = onTerminosCambia
                    )
                    uistate.errorTerminos?.let { mensaje ->
                        Text(
                            text = mensaje,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = Dimens.espacioChico)
                        )
                    }
                }
                //botton
                Row(horizontalArrangement = Arrangement.spacedBy(Dimens.espacioMedio)) {
                    BotonSecundario(
                        texto = stringResource(R.string.btn_limpiar),
                        onClick = onLimpiar,
                        modifier = Modifier.weight(1f)
                    )
                    BotonPrincipal(
                        texto = stringResource(R.string.btn_registro),
                        onClick = onRegistrar,
                        icono = R.drawable.ic_check,
                        modifier = Modifier.weight(1f)
                    )
                }
                //mensaje de exito
                if(uistate.RegistroExitoso){

                }
                Spacer(Modifier.height(Dimens.espacioGrande))
            }
        }
    }

}