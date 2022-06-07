package com.test.googlemap.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun MapScreen(
   onMarkerClick: (String) -> Unit,
   openDrawer: () -> Unit
) {
   Column(modifier = Modifier.fillMaxSize()) {
      TopAppBar(
         title = {
            Text(
               text = "Map"
            )
         },
         navigationIcon = {
            IconButton(onClick = { openDrawer() } ) {
               Icon(Icons.Filled.Menu, contentDescription = "")
            }
         },
         backgroundColor = MaterialTheme.colors.primaryVariant
      )

      GoogleMap {
         Marker(
            state = MarkerState(LatLng(0.0, 0.0)),
            title = "Hello Marker",
            onClick = { marker ->
               onMarkerClick(marker.title ?: "")
               true
            }
         )
      }
   }
}