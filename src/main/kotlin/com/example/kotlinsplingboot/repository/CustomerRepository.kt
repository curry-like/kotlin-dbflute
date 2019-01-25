package com.example.kotlinsplingboot.repository

import com.example.dbflute.exbhv.CustomerBhv
import com.example.dbflute.exentity.Customer
import org.springframework.stereotype.Repository
import javax.annotation.Resource

@Repository
class CustomerRepository() {

    @Resource
    private lateinit var customerBhv: CustomerBhv

    fun list(): List<Customer> {
        val list = customerBhv.selectList{}
        return list.toList()
    }
}