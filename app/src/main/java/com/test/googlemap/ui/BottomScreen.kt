package com.test.googlemap.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun BottomScreen(name: String) {
   Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier
         .fillMaxWidth()
         .height(200.dp)
   ) {
      Text("hello $name")
   }
}