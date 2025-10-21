package com.strivesync.health.wear.presentation.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.*
import com.strivesync.health.wear.presentation.theme.HealthDanger
import com.strivesync.health.wear.presentation.theme.HealthWarning
import kotlinx.coroutines.delay

@Composable
fun EmergencyScreen() {
    val listState = rememberScalingLazyListState()
    val context = LocalContext.current
    var countdown by remember { mutableStateOf(0) }
    
    LaunchedEffect(countdown) {
        if (countdown > 0) {
            delay(1000)
            countdown -= 1
            if (countdown == 0) {
                // Trigger emergency call
                val intent = Intent(Intent.ACTION_CALL).apply {
                    data = Uri.parse("tel:911")
                }
                context.startActivity(intent)
            }
        }
    }
    
    Scaffold(
        timeText = {
            if (countdown == 0) {
                TimeText()
            }
        },
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        },
        positionIndicator = {
            PositionIndicator(scalingLazyListState = listState)
        }
    ) {
        if (countdown > 0) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "🚨",
                    fontSize = 48.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Calling Emergency",
                    style = MaterialTheme.typography.title2,
                    color = HealthDanger
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$countdown",
                    style = MaterialTheme.typography.display1,
                    fontWeight = FontWeight.Bold,
                    color = HealthDanger
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { countdown = 0 },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = HealthWarning
                    )
                ) {
                    Text("Cancel")
                }
            }
        } else {
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
                            text = "Emergency",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.title2,
                            color = HealthDanger
                        )
                    }
                }
                
                item {
                    Card(
                        onClick = { /* Info */ },
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
                                text = "🚨",
                                fontSize = 32.sp
                            )
                            Text(
                                text = "Emergency SOS",
                                style = MaterialTheme.typography.title3,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Press button to call emergency services",
                                style = MaterialTheme.typography.caption1,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colors.onSurfaceVariant
                            )
                        }
                    }
                }
                
                item {
                    Chip(
                        onClick = { countdown = 5 },
                        label = {
                            Text(
                                text = "Call 911",
                                maxLines = 1,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        colors = ChipDefaults.chipColors(
                            backgroundColor = HealthDanger
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                
                item {
                    ListHeader {
                        Text(
                            text = "Emergency Contacts",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.caption1
                        )
                    }
                }
                
                item {
                    Chip(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:+1234567890")
                            }
                            context.startActivity(intent)
                        },
                        label = {
                            Text("Dr. Sarah Smith", maxLines = 1)
                        },
                        secondaryLabel = {
                            Text("Primary Care", maxLines = 1)
                        },
                        icon = {
                            Text("👨‍⚕️")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                
                item {
                    Chip(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:+1234567891")
                            }
                            context.startActivity(intent)
                        },
                        label = {
                            Text("Jane Doe", maxLines = 1)
                        },
                        secondaryLabel = {
                            Text("Emergency Contact", maxLines = 1)
                        },
                        icon = {
                            Text("👤")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                
                item {
                    ListHeader {
                        Text(
                            text = "Medical Info",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.caption1
                        )
                    }
                }
                
                item {
                    Card(
                        onClick = { /* View details */ },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "Blood Type: O+",
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = "Allergies: None",
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = "Current Meds: Aspirin",
                                style = MaterialTheme.typography.body2
                            )
                        }
                    }
                }
            }
        }
    }
}

