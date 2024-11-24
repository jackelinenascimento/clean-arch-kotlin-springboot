package com.clean_arch_kotlin_springboot.api

import com.clean_arch_kotlin_springboot.api.application.useCase.PersonUseCase
import com.clean_arch_kotlin_springboot.api.domain.ports.PersonRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class ApiKotlinSpringbootApplication

fun main(args: Array<String>) {
	runApplication<ApiKotlinSpringbootApplication>(*args)
}
