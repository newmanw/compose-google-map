package com.test.googlemap.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GreenScreen(
   openDrawer: () -> Unit
) {
   Column(modifier = Modifier.fillMaxSize()) {
      TopAppBar(
         title = {
            Text(
               text = "Green"
            )
         },
         navigationIcon = {
            IconButton(onClick = { openDrawer() } ) {
               Icon(Icons.Filled.Menu, contentDescription = "")
            }
         },
         backgroundColor = MaterialTheme.colors.primaryVariant
      )

      Box(Modifier.fillMaxSize().background(Color.Green)) {

      }
   }
}