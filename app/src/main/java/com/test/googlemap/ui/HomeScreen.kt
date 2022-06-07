package com.test.googlemap.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import kotlinx.coroutines.launch
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun HomeScreen() {
   val scope = rememberCoroutineScope()
   val bottomSheetNavigator = rememberBottomSheetNavigator()
   val navController = rememberNavController(bottomSheetNavigator)
   val drawerState = rememberDrawerState(DrawerValue.Closed)

   ModalBottomSheetLayout(bottomSheetNavigator) {
      val openDrawer = {
         scope.launch { drawerState.open() }
      }

      Surface(color = MaterialTheme.colors.background) {
         ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
               NavigationDrawer(
                  onDestinationClicked = { route ->
                     scope.launch {
                        drawerState.close()
                     }
                     navController.navigate(route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                           saveState = true
                        }
                        launchSingleTop = true
                     }
                  }
               )
            }
         ) {
            NavHost(
               navController = navController,
               startDestination = "map"
            ) {
               composable("map") {
                  MapScreen(
                     onMarkerClick = {
                        navController.navigate("map?name=$it")
                     },
                     openDrawer = { openDrawer() }
                  )
               }
               composable("green") {
                  GreenScreen(
                     openDrawer = { openDrawer() }
                  )
               }

               bottomSheet("map?name={name}") { backstackEntry ->
                  backstackEntry.arguments?.getString("name")?.let { name ->
                     BottomScreen(name)
                  }
               }
            }
         }
      }
   }
}