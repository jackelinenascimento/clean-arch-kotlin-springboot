package com.clean_arch_kotlin_springboot.api.adapter.repository

import com.clean_arch_kotlin_springboot.api.domain.model.Person
import com.clean_arch_kotlin_springboot.api.domain.ports.PersonRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class PersonRepositoryImpl(private val jdbcTemplate: JdbcTemplate): PersonRepository {

    override fun findAll(): List<Person> {
        val sql = "SELECT id, name, email, age FROM person"
        return jdbcTemplate.query(sql) { rs, _ ->
            Person(
                id = rs.getObject("id", UUID::class.java),
                name = rs.getString("name"),
                email = rs.getString("email"),
                age = rs.getInt("age")
            )
        }
    }
}