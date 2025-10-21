package com.strivesync.health.data.models

data class HealthMetric(
    val type: MetricType,
    val value: String,
    val unit: String,
    val status: HealthStatus,
    val timestamp: Long = System.currentTimeMillis()
)

enum class MetricType {
    HEART_RATE,
    STEPS,
    SLEEP,
    BLOOD_PRESSURE,
    OXYGEN,
    CALORIES,
    DISTANCE,
    ACTIVE_MINUTES
}

enum class HealthStatus {
    EXCELLENT,
    GOOD,
    WARNING,
    DANGER
}

data class HealthSummary(
    val overallStatus: HealthStatus,
    val statusText: String,
    val heartRate: HealthMetric,
    val steps: HealthMetric,
    val sleep: HealthMetric?,
    val aiInsight: String
)

data class SymptomReport(
    val symptoms: List<String>,
    val severity: Int, // 1-10
    val duration: String,
    val aiAnalysis: String?,
    val timestamp: Long = System.currentTimeMillis()
)

data class Medication(
    val id: String,
    val name: String,
    val dosage: String,
    val frequency: String,
    val times: List<String>,
    val isActive: Boolean = true
)

data class EmergencyContact(
    val name: String,
    val phone: String,
    val relationship: String
)

