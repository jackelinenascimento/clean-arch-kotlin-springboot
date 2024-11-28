package com.clean_arch_kotlin_springboot.api.adapter.rest.dto

import com.clean_arch_kotlin_springboot.api.domain.model.Person
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.util.UUID

data class PersonRequest(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    val email: String,

    @field:Positive
    val age: Int
){
    fun toDomain() = Person(UUID.randomUUID(), name, email, age)
}
