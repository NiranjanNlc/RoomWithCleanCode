package com.example.roomwithcleancode.framework

import org.lniranjan.data.NotesDataSource
import org.lniranjan.domain.Notes

class NotesSourceImpl: NotesDataSource {
    override suspend fun add(notes: Notes) {
        TODO("Not yet implemented")
    }

    override suspend fun readAll(): List<Notes> {
        TODO("Not yet implemented")
    }

    override suspend fun remove(notes: Notes) {
        TODO("Not yet implemented")
    }
}