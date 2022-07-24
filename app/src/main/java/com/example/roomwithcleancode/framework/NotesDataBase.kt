package com.example.roomwithcleancode.framework

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.lniranjan.domain.Fidility
import org.lniranjan.domain.Notes

@Database(entities = [Notes::class], version = 2)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun notesdDao(): NotesDao
    private class NotesDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    println(" coroutine scope initiation ...")
                    var notesDao = database.notesdDao()
                    initiseDb(notesDao)
                }
            }
        }

        private suspend fun initiseDb(notesDao: NotesDao) {
            var descriptionList = listOf<String>(" Niranjan lamichhane ",
                " ashmita thapa       ",
                " sashmita neupane    ",
                " rachana poudel ",
                " jharana bajracharya  ",
                " Ashma Baniya ",
                " ")
            descriptionList.forEach {
                println(it)
                insertData(it,notesDao)
            }
        }

        private suspend fun insertData(sesc: String, notesDao: NotesDao)
        {
            println(" $sesc inserting operation ...........")
            val notes = Notes ( title = "some thing",
                fidility = Fidility.IMPORTANT,
                description = sesc,
                dateCreated="some thing"
            )
            notesDao.insertData(notes)
        }
    }
    companion object {

        @Volatile
        private var INSTANCE:NotesDataBase? = null

        fun getDatabase(context: Context, scope: CoroutineScope):NotesDataBase {
            println("You have acces over here ")
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDataBase::class.java,
                    "note_db"
                ).addCallback(NotesDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}