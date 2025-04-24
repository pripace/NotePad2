package com.example.notepad2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notepad2.ui.theme.NotePad2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaNota(navController: NavController, modifier: Modifier = Modifier) {

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Crea tu nueva Nota")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column( modifier = Modifier
                .padding(16.dp)
                .padding(padding)
                .fillMaxSize()
        ) {
            var titulo by remember { mutableStateOf("") }
            var texto by remember { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = titulo,
                label = {
                    Text("Ingresar titulo")
                },
                onValueChange = {
                    value ->
                    titulo = value
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                value = texto,
                label = {
                    Text("Ingresar nota")
                },
                onValueChange = {
                        value ->
                    texto = value
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                navController.popBackStack()
            },
                modifier = Modifier.align(Alignment.End),
                ) {
                Text("Crear nota")
            }
        }}
}

@Preview(showBackground = true)
@Composable
fun NuevaNotaPreview() {
    NotePad2Theme {
        NuevaNota(
            rememberNavController()
        )
    }
}