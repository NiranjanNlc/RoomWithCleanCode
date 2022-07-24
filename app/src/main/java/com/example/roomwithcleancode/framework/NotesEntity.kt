package com.example.roomwithcleancode.framework

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.lniranjan.domain.Fidility
import java.io.Serializable

@Entity(tableName = "notes_table")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null,
    var title: String?=null,
    var fidility: Fidility?=null,
    var description: String?=null,
    var dateCreated: String?=null
) : Serializable