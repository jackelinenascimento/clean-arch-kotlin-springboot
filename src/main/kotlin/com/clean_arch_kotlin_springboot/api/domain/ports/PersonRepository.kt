package com.clean_arch_kotlin_springboot.api.domain.ports

import com.clean_arch_kotlin_springboot.api.domain.model.Person

interface PersonRepository {
    fun findAll(): List<Person>
}