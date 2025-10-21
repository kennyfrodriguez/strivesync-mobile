package com.strivesync.health.wear.presentation.theme

import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Colors

val PrimaryBlue = Color(0xFF4F46E5)
val PrimaryBlueLight = Color(0xFF818CF8)
val SecondaryTeal = Color(0xFF06B6D4)
val AccentPurple = Color(0xFF8B5CF6)

val HealthExcellent = Color(0xFF10B981)
val HealthGood = Color(0xFF3B82F6)
val HealthWarning = Color(0xFFF59E0B)
val HealthDanger = Color(0xFFEF4444)

internal val wearColorPalette: Colors = Colors(
    primary = PrimaryBlue,
    primaryVariant = PrimaryBlueLight,
    secondary = SecondaryTeal,
    secondaryVariant = AccentPurple,
    error = HealthDanger,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onError = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = Color(0xFF1E293B),
    onSurface = Color.White,
    onSurfaceVariant = Color(0xFF94A3B8)
)

