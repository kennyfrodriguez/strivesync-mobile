package com.strivesync.health.wear.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.*
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.strivesync.health.wear.presentation.screens.*

@Composable
fun WearApp() {
    val navController = rememberSwipeDismissableNavController()
    
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToHeartRate = { navController.navigate("heart_rate") },
                onNavigateToActivity = { navController.navigate("activity") },
                onNavigateToEmergency = { navController.navigate("emergency") }
            )
        }
        
        composable("heart_rate") {
            HeartRateScreen()
        }
        
        composable("activity") {
            ActivityScreen()
        }
        
        composable("emergency") {
            EmergencyScreen()
        }
    }
}

