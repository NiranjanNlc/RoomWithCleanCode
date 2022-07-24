package org.lniranjan.data

import org.lniranjan.domain.Notes

interface NotesDataSource {
        suspend fun add(notes: Notes)

        suspend fun readAll(): List<Notes>

        suspend fun remove(notes: Notes)
    }

