package com.clean_arch_kotlin_springboot.api.application.useCase

import com.clean_arch_kotlin_springboot.api.domain.model.Person
import com.clean_arch_kotlin_springboot.api.domain.ports.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonUseCase(private val repository: PersonRepository) {

    fun listPersons(): List<Person> = repository.findAll()
}