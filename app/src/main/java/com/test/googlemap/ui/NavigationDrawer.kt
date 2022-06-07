package com.test.googlemap.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val screens = listOf("map", "green")

@Composable
fun NavigationDrawer(
   modifier: Modifier = Modifier,
   onDestinationClicked: (route: String) -> Unit
) {
   Column(
      modifier
         .fillMaxSize()
         .padding(start = 24.dp, top = 48.dp)
   ) {
      screens.forEach { screen ->
         Spacer(Modifier.height(24.dp))
         Text(
            text = screen,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.clickable {
               onDestinationClicked(screen)
            }
         )
      }
   }
}