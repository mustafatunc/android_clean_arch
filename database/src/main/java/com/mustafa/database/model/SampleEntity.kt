package com.mustafa.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sample")
data class SampleEntity(
    val name: String,
    val count: Int,
    val dateAdded: Long,
    val expires: Long
) {
    @PrimaryKey(autoGenerate = true)
    var sampleId: Int = 0
}