package com.example.napominalka.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.provider.ContactsContract.CommonDataKinds.Note
import com.example.napominalka.NoteDatabase
import android.os.AsyncTask
import androidx.sqlite.db.SupportSQLiteDatabase
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.support.annotation.NonNull


@Database(entities = [Event::class], version = 1)
abstract class EventDataBase : RoomDatabase() {
    abstract var eventDao: EventDao

    companion object {
        lateinit var instance: EventDataBase
        @Synchronized
        fun getInstance(context: Context): EventDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    EventDataBase::class.java, "event_database")
                    .addCallback(roomCallback)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
        val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance).execute()
            }
        }
    }



    private class PopulateDbAsyncTask(db: EventDataBase) : AsyncTask<Void, Void, Void>() {
        private val noteDao: EventDao

        init {
            noteDao = db.eventDao
        }

        override fun doInBackground(vararg voids: Void): Void? {
            noteDao.insert(Event("Title 1",  1, 1,1, 1, 1, 1 ))
            noteDao.insert(Event("Title 2",  2, 2,2, 2, 2, 2 ))
            noteDao.insert(Event("Title 3",  3, 3,3, 3, 3, 3 ))
            return null
        }
    }
}