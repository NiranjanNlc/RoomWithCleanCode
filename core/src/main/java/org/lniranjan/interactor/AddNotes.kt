package org.lniranjan.interactor

import org.lniranjan.data.NotesRepo
import org.lniranjan.domain.Notes

class AddNotes (private val  notesRepo: NotesRepo ) {
    suspend operator fun invoke(notes: Notes) = notesRepo.addNotes(notes)
}