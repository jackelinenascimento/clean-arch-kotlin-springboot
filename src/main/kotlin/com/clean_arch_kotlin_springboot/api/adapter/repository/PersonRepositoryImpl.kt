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

    override fun findById(id: UUID): Person {
        val sql = "SELECT id, name, email, age FROM person WHERE id = ?"
        val persons = jdbcTemplate.query(sql, { ps -> ps.setObject(1, id) }) { rs, _ ->
            Person(
                id = rs.getObject("id", UUID::class.java),
                name = rs.getString("name"),
                email = rs.getString("email"),
                age = rs.getInt("age")
            )
        }
        return persons.firstOrNull() ?: throw Exception("Person not found")
    }

    override fun save(person: Person): Person {
        val sql = "INSERT INTO person (id, name, email, age) VALUES (?, ?, ?, ?)"
        jdbcTemplate.update(sql, person.id, person.name, person.email, person.age)
        return person
    }

    override fun delete(id: UUID) {
        val sql = "DELETE FROM person WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }
}