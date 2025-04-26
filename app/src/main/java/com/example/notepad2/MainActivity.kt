package com.example.notepad2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notepad2.ui.theme.NotePad2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            NotePad2Theme { //COMO SE ARMA LA NAVEGACION

                val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "lista"
                    ){
                        composable("lista") { ListaDeNotasView(navController) } //vistas
                        composable("nueva") { NuevaNota(navController) }
                    }
                }
            }
        }
    }


