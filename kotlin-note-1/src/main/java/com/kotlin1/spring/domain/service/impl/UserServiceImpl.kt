package com.kotlin1.spring.domain.service.impl

import com.kotlin1.spring.domain.dto.CreateUserInDTO
import com.kotlin1.spring.domain.dto.CreateUserOutDTO
import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.entity.User
import com.kotlin1.spring.domain.repo.UserRepo
import com.kotlin1.spring.domain.service.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepo: UserRepo): UserService {
    override fun readUser(userId: Long): ReadUserOutDTO {
        val user = userRepo.findByIdOrNull(userId) ?: throw NoSuchElementException()

        return ReadUserOutDTO.toReadUserOutDTO(user)
    }

    override fun createUser(createUserInDTO: CreateUserInDTO): CreateUserOutDTO {
        val user = CreateUserInDTO.toUser(createUserInDTO)

        return CreateUserOutDTO.toCreateUserOutDTO(userRepo.save(user))
    }
}