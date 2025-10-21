package com.strivesync.health.wear.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Text

@Composable
fun QuickActionChip(
    label: String,
    icon: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Chip(
        onClick = onClick,
        label = {
            Text(
                text = label,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold
            )
        },
        icon = {
            Text(
                text = icon,
                fontSize = 20.sp
            )
        },
        colors = ChipDefaults.chipColors(
            backgroundColor = backgroundColor
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

