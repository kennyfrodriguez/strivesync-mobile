package com.strivesync.health.wear.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.*
import com.strivesync.health.wear.presentation.components.MetricCard
import com.strivesync.health.wear.presentation.components.QuickActionChip
import com.strivesync.health.wear.presentation.theme.*

@Composable
fun HomeScreen(
    onNavigateToHeartRate: () -> Unit,
    onNavigateToActivity: () -> Unit,
    onNavigateToEmergency: () -> Unit
) {
    val listState = rememberScalingLazyListState()
    
    Scaffold(
        timeText = {
            TimeText()
        },
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        },
        positionIndicator = {
            PositionIndicator(scalingLazyListState = listState)
        }
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = 32.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 32.dp
            ),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            state = listState
        ) {
            item {
                ListHeader {
                    Text(
                        text = "StriveSync",
                        textAlign = TextAlign.Center,
                        color = PrimaryBlueLight,
                        style = MaterialTheme.typography.title2
                    )
                }
            }
            
            item {
                Card(
                    onClick = { /* Refresh */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Health Status",
                            style = MaterialTheme.typography.caption1,
                            color = MaterialTheme.colors.onSurfaceVariant
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(
                                        color = HealthExcellent,
                                        shape = androidx.compose.foundation.shape.CircleShape
                                    )
                            )
                            Text(
                                text = "Excellent",
                                style = MaterialTheme.typography.title3,
                                fontWeight = FontWeight.Bold,
                                color = HealthExcellent
                            )
                        }
                    }
                }
            }
            
            item {
                MetricCard(
                    icon = "❤️",
                    label = "Heart Rate",
                    value = "72",
                    unit = "BPM",
                    color = HealthExcellent,
                    onClick = onNavigateToHeartRate
                )
            }
            
            item {
                MetricCard(
                    icon = "👟",
                    label = "Steps",
                    value = "8,542",
                    unit = "steps",
                    color = PrimaryBlue,
                    onClick = onNavigateToActivity
                )
            }
            
            item {
                MetricCard(
                    icon = "🔥",
                    label = "Calories",
                    value = "2,340",
                    unit = "kcal",
                    color = HealthWarning,
                    onClick = { /* Navigate to calories */ }
                )
            }
            
            item {
                ListHeader {
                    Text(
                        text = "Quick Actions",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.caption1
                    )
                }
            }
            
            item {
                QuickActionChip(
                    label = "Emergency SOS",
                    icon = "🚨",
                    backgroundColor = HealthDanger,
                    onClick = onNavigateToEmergency
                )
            }
            
            item {
                QuickActionChip(
                    label = "AI Advice",
                    icon = "🤖",
                    backgroundColor = PrimaryBlue,
                    onClick = { /* Open AI */ }
                )
            }
            
            item {
                QuickActionChip(
                    label = "Medications",
                    icon = "💊",
                    backgroundColor = AccentPurple,
                    onClick = { /* Open medications */ }
                )
            }
        }
    }
}

