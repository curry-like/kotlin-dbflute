package com.example.kotlinsplingboot.controller

import com.example.kotlinsplingboot.service.CustomerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("customers")
public class CustomerController() {

    private lateinit var customerService: CustomerService

    @GetMapping
    fun list(model: Model):String {
        val customers = customerService.findAll()
        model.addAttribute("customers", customers)
        return "customers/list"
    }

}