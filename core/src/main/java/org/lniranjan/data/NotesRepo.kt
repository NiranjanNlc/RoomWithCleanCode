package org.lniranjan.data

import org.lniranjan.domain.Notes

class NotesRepo(
        private val noteDataSource: NotesDataSource) {

        suspend fun addNotes(document: Notes) =noteDataSource.add(document)

        suspend fun getNotess() =noteDataSource.readAll()

        suspend fun removeNotes(document: Notes) =noteDataSource.remove(document)
    }

