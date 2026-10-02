package com.example.miregistro.ui.styles


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.miregistro.ui.theme.Blanco
import com.example.miregistro.ui.theme.Dimens
import com.example.miregistro.ui.theme.GrisDeshabilitado
import com.example.miregistro.ui.theme.Primario

object EstilosBoton{
    val forma: Shape = RoundedCornerShape(size = Dimens.radioBoton)
    val relleno = PaddingValues(horizontal = 20.dp, vertical = 12.dp)

    //boton para el formulario = morado con texto blanco
    @Composable
    fun coloresPrincipales(): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Primario,//Backgroud Color
        contentColor = Blanco, //Color
        disabledContentColor = Blanco,
        disabledContainerColor = GrisDeshabilitado
    )

    //Botones Secundarios = transparente con texto del color del tema
    @Composable
    fun coloresSecundario(): ButtonColors = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.primary
    )

    //Sombra del boton (animacion el boton se hunde al presionar)
    @Composable
    fun elevacion(): ButtonElevation = ButtonDefaults.buttonElevation(
        defaultElevation = Dimens.elevacionBoton,
        pressedElevation = 1.dp
    )

    //Botones con bordes
    @Composable
    fun bordeSecundario(): BorderStroke = BorderStroke(
        Dimens.BordeBoton, color = MaterialTheme.colorScheme.primary
    )
}

//Selector Clase CSS
fun Modifier.estiloAltoBoton(): Modifier = this.height(Dimens.alturaBoton)