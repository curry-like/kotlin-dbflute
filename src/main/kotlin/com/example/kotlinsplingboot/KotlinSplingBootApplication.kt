package com.example.kotlinsplingboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages= ["com.example.kotlinsplingboot", "com.example.dbflute"])
class KotlinSplingBootApplication

fun main(args: Array<String>) {
	runApplication<KotlinSplingBootApplication>(*args)
}

