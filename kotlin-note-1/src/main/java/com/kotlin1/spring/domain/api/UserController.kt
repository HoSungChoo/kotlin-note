package com.kotlin1.spring.domain.api

import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService){
    @GetMapping("/{userId}")
    fun readUser(@PathVariable userId: Long) : ResponseEntity<ReadUserOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(userService.readUser(userId))
    }

}

