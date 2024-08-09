package com.kotlin1.spring.domain.service.impl

import com.kotlin1.spring.domain.dto.CreateUserInDTO
import com.kotlin1.spring.domain.dto.CreateUserOutDTO
import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.entity.User
import com.kotlin1.spring.domain.repo.origin.UserRepo
import com.kotlin1.spring.domain.service.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepo: UserRepo): UserService {
    override fun readUser(userId: Long): ReadUserOutDTO {
        val user = userRepo.findByIdOrNull(userId) ?: throw NoSuchElementException()

        return ReadUserOutDTO.toDTO(user)
    }

    override fun createUser(createUserInDTO: CreateUserInDTO): CreateUserOutDTO {
        val user = User.toEntity(
            userId = 0L,
            email = createUserInDTO.email,
            birth = createUserInDTO.birth,
            gender = createUserInDTO.gender,
            city = createUserInDTO.city,
            street = createUserInDTO.street,
            zipcode = createUserInDTO.zipcode,
            state = createUserInDTO.state
        )

        return CreateUserOutDTO.toDTO(userRepo.save(user))
    }
}