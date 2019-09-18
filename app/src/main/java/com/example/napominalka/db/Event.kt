package com.example.napominalka.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_table")
data class Event (
    var name: String,
    var priority: Int,
    var minutes: Int,
    var hours: Int,
    var days: Int,
    var months:Int,
    var years: Int){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}