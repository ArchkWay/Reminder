package com.example.napominalka

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.napominalka.db.Event
import com.example.napominalka.db.EventRepository

class EventViewModel(application: Application) : AndroidViewModel(application) {
    var eventRepository = EventRepository(application)
    var allEvents  = eventRepository.allEvents

    fun insert(event: Event){
        eventRepository.insert(event)
    }

    fun update(event: Event){
        eventRepository.update(event)
    }
    fun delete(event: Event){
        eventRepository.delete(event)
    }

    fun deleteAllEvents(){
        eventRepository.deleteAllEvents()
    }
}