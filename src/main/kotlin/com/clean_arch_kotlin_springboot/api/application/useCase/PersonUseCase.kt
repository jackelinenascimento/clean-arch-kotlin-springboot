package com.clean_arch_kotlin_springboot.api.application.useCase

import com.clean_arch_kotlin_springboot.api.domain.model.Person
import com.clean_arch_kotlin_springboot.api.domain.ports.PersonRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonUseCase(private val repository: PersonRepository) {

    fun listPersons(): List<Person> {
       return repository.findAll()
    }

    fun getPerson(id: UUID): Person {
        try {
            return repository.findById(id)
        } catch (e: Exception) {
            throw Exception("Person not found")
        }
    }

    fun savePerson(person: Person): Person {
        try {
            return repository.save(person)
        } catch (e: Exception) {
            throw Exception("Error saving person")
        }
    }

    fun deletePerson(id: UUID) {
        try {
            repository.delete(id)
        } catch (e: Exception) {
            throw Exception("Error deleting person")
        }
    }
}