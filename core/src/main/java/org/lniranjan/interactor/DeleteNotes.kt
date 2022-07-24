package org.lniranjan.interactor

import org.lniranjan.data.NotesRepo
import org.lniranjan.domain.Notes

class DeleteNotes  (private val  notesRepo: NotesRepo) {
    suspend operator fun invoke(notes: Notes) = notesRepo.removeNotes(notes)
}