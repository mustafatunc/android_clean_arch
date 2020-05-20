package com.mustafa.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mustafa.database.model.SampleEntity

@Dao
interface SampleDao {

    @Insert
    suspend fun addSample(sample: SampleEntity)

    @Delete
    suspend fun removeSample(sample: SampleEntity)

    @Query("SELECT * FROM sample WHERE name = :withName ")
    suspend fun getSample(withName: String): SampleEntity?

}