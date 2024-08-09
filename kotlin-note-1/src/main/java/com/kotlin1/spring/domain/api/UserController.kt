package com.kotlin1.spring.domain.api

import com.kotlin1.spring.domain.dto.CreateUserInDTO
import com.kotlin1.spring.domain.dto.CreateUserOutDTO
import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
@ResponseBody
class UserController(private val userService: UserService){
    @GetMapping()
    fun readUser(@RequestParam id: Long) : ResponseEntity<ReadUserOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(userService.readUser(id))
    }

    @PostMapping()
    fun createUser(@RequestBody createUserInDTO: CreateUserInDTO): ResponseEntity<CreateUserOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(createUserInDTO))
    }
}

