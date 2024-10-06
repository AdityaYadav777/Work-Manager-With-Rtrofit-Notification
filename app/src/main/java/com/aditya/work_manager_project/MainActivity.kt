package com.aditya.work_manager_project

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.aditya.work_manager_project.ui.theme.WorkManagerProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        requestPermission()

        setContent {
       val  viewModel=ViewModelProvider(this)[MainViewModel::class.java]

            WorkManagerProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(modifier = Modifier.padding(innerPadding)) {

                        Button(onClick = {
                            Intent(this@MainActivity,MainService::class.java).also {
                                it.action=MainService.Controller.START.name
                                startService(it)
                            }
                        }) {
                            Text(text = "Start")
                        }
                        Button(onClick = {
                            Intent(this@MainActivity,MainService::class.java).also {
                                it.action=MainService.Controller.STOP.name
                                startService(it)
                            }
                        }) {
                            Text(text = "Start")
                        }


                    }
                }
            }
        }
    }


    fun requestPermission(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                100
            )
        }

    }

}
