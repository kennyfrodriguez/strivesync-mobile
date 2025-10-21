package com.strivesync.health.data.repository

import com.strivesync.health.data.models.Medication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MedicationRepository {
    private val _medications = MutableStateFlow<List<Medication>>(
        listOf(
            Medication(
                id = "1",
                name = "Aspirin",
                dosage = "100mg",
                frequency = "Daily",
                times = listOf("08:00", "20:00"),
                isActive = true
            ),
            Medication(
                id = "2",
                name = "Vitamin D",
                dosage = "1000 IU",
                frequency = "Daily",
                times = listOf("09:00"),
                isActive = true
            ),
            Medication(
                id = "3",
                name = "Blood Pressure Med",
                dosage = "10mg",
                frequency = "Daily",
                times = listOf("08:00"),
                isActive = false
            )
        )
    )
    
    val medications: Flow<List<Medication>> = _medications.asStateFlow()
    
    fun addMedication(medication: Medication) {
        _medications.value = _medications.value + medication
    }
    
    fun updateMedication(medication: Medication) {
        _medications.value = _medications.value.map {
            if (it.id == medication.id) medication else it
        }
    }
    
    fun deleteMedication(medicationId: String) {
        _medications.value = _medications.value.filter { it.id != medicationId }
    }
    
    fun toggleMedicationActive(medicationId: String) {
        _medications.value = _medications.value.map {
            if (it.id == medicationId) it.copy(isActive = !it.isActive) else it
        }
    }
}

