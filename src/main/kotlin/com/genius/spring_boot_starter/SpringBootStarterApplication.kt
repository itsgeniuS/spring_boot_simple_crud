package com.genius.spring_boot_starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootStarterApplication

fun main(args: Array<String>) {
	runApplication<SpringBootStarterApplication>(*args)
}
