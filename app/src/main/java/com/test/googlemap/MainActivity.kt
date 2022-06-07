package com.test.googlemap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.test.googlemap.ui.HomeScreen
import com.test.googlemap.ui.theme.GoogleMapTheme

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         GoogleMapTheme {
            HomeScreen()
         }
      }
   }
}