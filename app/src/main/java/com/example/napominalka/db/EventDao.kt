package com.example.napominalka.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EventDao {
    @Insert
    fun insert(event: Event)

    @Update
    fun update(event: Event)

    @Delete
    fun delete(event: Event)

    @Query("DELETE FROM event_table")
    fun deleteAllEvent()

    @Query("SELECT * FROM event_table ORDER BY priority DESC")
    fun getAllEvents(): LiveData<List<Event>>
}