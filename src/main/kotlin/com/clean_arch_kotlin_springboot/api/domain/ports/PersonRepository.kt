package com.clean_arch_kotlin_springboot.api.domain.ports

import com.clean_arch_kotlin_springboot.api.domain.model.Person
import java.util.*

interface PersonRepository {
    fun findAll(): List<Person>
    fun findById(id: UUID): Person
    fun save(person: Person): Person
    fun delete(id: UUID)
}