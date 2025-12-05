package com.strivesync.health.wear.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.*
import com.strivesync.health.wear.presentation.theme.HealthDanger
import com.strivesync.health.wear.presentation.theme.HealthExcellent
import com.strivesync.health.wear.presentation.theme.HealthGood
import kotlinx.coroutines.delay

@Composable
fun HeartRateScreen() {
    var heartRate by remember { mutableStateOf(72) }
    var isMonitoring by remember { mutableStateOf(false) }
    
    LaunchedEffect(isMonitoring) {
        if (isMonitoring) {
            while (true) {
                delay(1000)
                // Simulate heart rate changes
                heartRate = (68..76).random()
            }
        }
    }
    
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
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = listState,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ListHeader {
                    Text(
                        text = "Heart Rate",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.title2
                    )
                }
            }
            
            item {
                Card(
                    onClick = { /* Details */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "❤️",
                            fontSize = 32.sp
                        )
                        
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "$heartRate",
                                style = MaterialTheme.typography.display1,
                                fontWeight = FontWeight.Bold,
                                color = HealthExcellent
                            )
                            Text(
                                text = "BPM",
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.onSurfaceVariant,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                        
                        Text(
                            text = if (isMonitoring) "Monitoring..." else "Normal",
                            style = MaterialTheme.typography.caption1,
                            color = HealthExcellent
                        )
                    }
                }
            }
            
            item {
                Chip(
                    onClick = { isMonitoring = !isMonitoring },
                    label = {
                        Text(
                            text = if (isMonitoring) "Stop" else "Start Monitoring",
                            maxLines = 1
                        )
                    },
                    colors = ChipDefaults.chipColors(
                        backgroundColor = if (isMonitoring) HealthDanger else HealthExcellent
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            item {
                ListHeader {
                    Text(
                        text = "Recent Readings",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.caption1
                    )
                }
            }
            
            item {
                Card(
                    onClick = { /* Details */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "70 BPM",
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "2 hours ago",
                                style = MaterialTheme.typography.caption1,
                                color = MaterialTheme.colors.onSurfaceVariant
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    color = HealthGood,
                                    shape = androidx.compose.foundation.shape.CircleShape
                                )
                        )
                    }
                }
            }
            
            item {
                Card(
                    onClick = { /* Details */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "68 BPM",
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "4 hours ago",
                                style = MaterialTheme.typography.caption1,
                                color = MaterialTheme.colors.onSurfaceVariant
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    color = HealthGood,
                                    shape = androidx.compose.foundation.shape.CircleShape
                                )
                        )
                    }
                }
            }
        }
    }
}

