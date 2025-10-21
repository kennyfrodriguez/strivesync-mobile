package com.strivesync.health.wear.presentation.screens

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
import com.strivesync.health.wear.presentation.theme.*

@Composable
fun ActivityScreen() {
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
                        text = "Activity",
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
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "👟",
                            fontSize = 32.sp
                        )
                        
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "8,542",
                                style = MaterialTheme.typography.display2,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryBlue
                            )
                        }
                        
                        Text(
                            text = "steps today",
                            style = MaterialTheme.typography.caption1,
                            color = MaterialTheme.colors.onSurfaceVariant
                        )
                        
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Goal: 10,000",
                                    style = MaterialTheme.typography.caption2,
                                    color = MaterialTheme.colors.onSurfaceVariant
                                )
                                Text(
                                    text = "85%",
                                    style = MaterialTheme.typography.caption2,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryBlue
                                )
                            }
                            
                            Spacer(modifier = Modifier.height(4.dp))
                            
                            LinearProgressIndicator(
                                progress = 0.85f,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(4.dp),
                                color = PrimaryBlue
                            )
                        }
                    }
                }
            }
            
            item {
                ListHeader {
                    Text(
                        text = "Other Metrics",
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
                                text = "🔥 Calories",
                                style = MaterialTheme.typography.body1
                            )
                            Text(
                                text = "2,340 kcal",
                                style = MaterialTheme.typography.title3,
                                fontWeight = FontWeight.Bold,
                                color = HealthWarning
                            )
                        }
                        Text(
                            text = "94%",
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onSurfaceVariant
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
                                text = "⏱️ Active",
                                style = MaterialTheme.typography.body1
                            )
                            Text(
                                text = "45 min",
                                style = MaterialTheme.typography.title3,
                                fontWeight = FontWeight.Bold,
                                color = SecondaryTeal
                            )
                        }
                        Text(
                            text = "75%",
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onSurfaceVariant
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
                                text = "📏 Distance",
                                style = MaterialTheme.typography.body1
                            )
                            Text(
                                text = "6.2 km",
                                style = MaterialTheme.typography.title3,
                                fontWeight = FontWeight.Bold,
                                color = AccentPurple
                            )
                        }
                    }
                }
            }
        }
    }
}

