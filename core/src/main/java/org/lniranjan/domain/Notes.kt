package org.lniranjan.domain

import java.io.Serializable


data class Notes(
    var id: Int?=null,
    var title: String?=null,
    var fidility: Fidility?=null,
    var description: String?=null,
    var dateCreated: String?=null
) : Serializable