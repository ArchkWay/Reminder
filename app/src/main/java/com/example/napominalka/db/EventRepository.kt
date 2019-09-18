package com.example.napominalka.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class EventRepository(application: Application) {
    val eventDao: EventDao
    val allEvents: LiveData<List<Event>>

    init {

        val database:EventDataBase = EventDataBase.getInstance(application)
        eventDao = database.eventDao
        allEvents = eventDao.getAllEvents()
    }

    fun insert(event: Event) {
        InsertEventAsyncTask(eventDao).execute(event)
    }

    fun update(event: Event) {
        UpdateEventAsyncTask(eventDao).execute(event)
    }

    fun delete(event: Event) {
        DeleteEventAsyncTask(eventDao).execute(event)
    }

    fun deleteAllEvents() {
        DeleteAllEventsAsyncTask(eventDao).execute()
    }

    class InsertEventAsyncTask(private val eventDao: EventDao) :
        AsyncTask<Event, Void, Void>() {

        override fun doInBackground(vararg events: Event): Void? {
            eventDao.insert(events[0])
            return null
        }
    }

    class UpdateEventAsyncTask(private val eventDao: EventDao) :
        AsyncTask<Event, Void, Void>() {

        override fun doInBackground(vararg events: Event): Void? {
            eventDao.update(events[0])
            return null
        }
    }

    class DeleteEventAsyncTask(private val eventDao: EventDao) :
        AsyncTask<Event, Void, Void>() {

        override fun doInBackground(vararg events: Event): Void? {
            eventDao.delete(events[0])
            return null
        }
    }

    class DeleteAllEventsAsyncTask(private val eventDao: EventDao) :
        AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg voids: Void): Void? {
            eventDao.deleteAllEvent()
            return null
        }
    }
}