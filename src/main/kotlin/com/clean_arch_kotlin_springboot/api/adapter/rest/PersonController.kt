package com.clean_arch_kotlin_springboot.api.adapter.rest

import com.clean_arch_kotlin_springboot.api.application.useCase.PersonUseCase
import com.clean_arch_kotlin_springboot.api.domain.model.Person
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/person")
class PersonController(private val useCase: PersonUseCase) {

    @GetMapping
    fun listPersons(): ResponseEntity<List<Person>> {
        return ResponseEntity.ok(useCase.listPersons())
    }
}