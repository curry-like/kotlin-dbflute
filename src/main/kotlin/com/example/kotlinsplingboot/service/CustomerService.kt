package com.example.kotlinsplingboot.service

import com.example.dbflute.exentity.Customer
import com.example.kotlinsplingboot.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService () {

    private lateinit var customerRepository: CustomerRepository

    fun findAll(): List<Customer> {
        return customerRepository.list()
    }
}