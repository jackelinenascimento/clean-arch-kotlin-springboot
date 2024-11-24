package com.clean_arch_kotlin_springboot.api.domain.model

import java.util.UUID

data class Person(
    val id: UUID,
    val name: String,
    val email: String,
    val age: Int
)
