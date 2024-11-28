package com.clean_arch_kotlin_springboot.api.adapter.rest.dto

import com.clean_arch_kotlin_springboot.api.domain.model.Person
import java.util.UUID

data class PersonResponse(
    val id: UUID,
    val name: String,
    val email: String,
    val age: Int
) {
    companion object{
        fun fromDomain(person: Person) = PersonResponse(
            id = person.id,
            name = person.name,
            email = person.email,
            age = person.age
        )
    }
}
