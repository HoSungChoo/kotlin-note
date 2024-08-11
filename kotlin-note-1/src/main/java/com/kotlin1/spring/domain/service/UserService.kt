package com.kotlin1.spring.domain.service

import com.kotlin1.spring.domain.dto.CreateUserInDTO
import com.kotlin1.spring.domain.dto.CreateUserOutDTO
import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.dto.ReadUserOutDTOS
import org.springframework.stereotype.Service

@Service
interface UserService{
    fun readUser(userId: Long): ReadUserOutDTO
    fun createUser(createUserInDTO: CreateUserInDTO): CreateUserOutDTO
    fun readUserUsingProvider(userId: Long): ReadUserOutDTOS
}