package com.clean_arch_kotlin_springboot.api.adapter.rest

import com.clean_arch_kotlin_springboot.api.adapter.rest.dto.PersonRequest
import com.clean_arch_kotlin_springboot.api.adapter.rest.dto.PersonResponse
import com.clean_arch_kotlin_springboot.api.application.useCase.PersonUseCase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/person")
class PersonController(private val useCase: PersonUseCase) {

    @GetMapping
    fun listPersons(): ResponseEntity<List<PersonResponse>> {
        try{
            val persons = useCase.listPersons()
            return ResponseEntity.ok(persons.map { PersonResponse.fromDomain(it) })
        } catch (e: Exception){
            return ResponseEntity.status(500).build()
        }
    }

    @GetMapping("/{id}")
    fun getPerson(@PathVariable id: UUID): ResponseEntity<PersonResponse>{
        try{
            val person = useCase.getPerson(id)
            return ResponseEntity.ok(PersonResponse.fromDomain(person))
        } catch (e: Exception){
            return ResponseEntity.status(500).build()
        }
    }

    @PostMapping
    fun savePerson(@Valid @RequestBody person: PersonRequest): ResponseEntity<PersonResponse>{
        try{
            val savedPerson = useCase.savePerson(person.toDomain())
            return ResponseEntity.ok(PersonResponse.fromDomain(savedPerson))
        } catch (e: Exception){
            return ResponseEntity.status(500).build()
        }
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: UUID): ResponseEntity<Unit>{
        try{
            useCase.deletePerson(id)
            return ResponseEntity.ok().build()
        } catch (e: Exception){
            return ResponseEntity.status(500).build()
        }
    }
}