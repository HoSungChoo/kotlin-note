package com.kotlin1.spring.domain.api

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class userController{
    @GetMapping("/")
    fun printUser(): String{
        return "hello"
    }

}

