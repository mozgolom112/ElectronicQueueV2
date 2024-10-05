package ru.mozgolom112.electronicqueue.features.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import ru.mozgolom112.electronicqueue.features.screen.authorization.AuthorizationScreen
import ru.mozgolom112.electronicqueue.ui.theme.ElectronicQueueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElectronicQueueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //screen here
                    AuthorizationScreen()
                }
            }
        }
    }
}
