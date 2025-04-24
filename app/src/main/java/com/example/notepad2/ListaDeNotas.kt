package com.example.notepad2

import android.R.attr.contentDescription
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notepad2.ui.theme.NotePad2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeNotasView( navController: NavController, modifier: Modifier = Modifier) { //SIEMPRE QUE CREAMOS VISTA PONER MODIFIER
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(//USUALMENTE CUANDO USAMOS ALGUN ELEMENTO TE PIDE QUE PONGAS EL PRIMER PARAMETRO DE SU LISTADO DE COMPONENTES
                onClick = {
                    //Navegar
                    navController.navigate("nueva")
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Agregar"
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text("Lista de Notas")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        )
        {
            Text("Soy una lista de notas")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaDeNotasPreview(){
    NotePad2Theme {
        ListaDeNotasView(
            rememberNavController()
        )
    }
}