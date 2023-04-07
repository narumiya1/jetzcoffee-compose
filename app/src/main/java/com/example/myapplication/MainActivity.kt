package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.JetzCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetzCoffeeTheme {
                JetCoffeeApps()
                // A surface container using the 'background' color from the theme
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
                */
            }
        }
    }
}
@Composable
fun JetCoffeeApps(){

}
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeAppPreview(){
    JetzCoffeeTheme {
        JetCoffeeApps()
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetzCoffeeTheme {
        Greeting("Android")
    }
}