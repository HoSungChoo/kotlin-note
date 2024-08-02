package com.kotlin1.spring.domain.dto

import com.kotlin1.spring.domain.entity.User
import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import java.time.LocalDateTime

data class ReadUserOutDTO (
    val userId: Long?,
    val email: String?,
    val birth: LocalDateTime?,
    val gender: Gender?,
    val city: String?,
    val street: String?,
    val zipcode: String?,
    val state: State?

){
    companion object Mapper {
        fun toReadUserOutDTO(user: User): ReadUserOutDTO {
            return ReadUserOutDTO(
                userId = user.userId,
                email = user.email,
                birth = user.birth,
                gender = user.gender,
                city = user.city,
                street = user.street,
                zipcode = user.zipcode,
                state = user.state
            )
        }
    }
}

data class CreateUserInDTO(
    val email: String?,
    val birth: LocalDateTime?,
    val gender: Gender?,
    val city: String?,
    val street: String?,
    val zipcode: String?,
    val state: State?
){
    companion object Mapper{
        fun toUser(createUserInDTO: CreateUserInDTO): User {
            return User(
                userId = null,
                email = createUserInDTO.email ?: throw IllegalArgumentException(),
                birth = createUserInDTO.birth ?: throw IllegalArgumentException(),
                gender = createUserInDTO.gender ?: throw IllegalArgumentException(),
                city = createUserInDTO.city ?: throw IllegalArgumentException(),
                street = createUserInDTO.street ?: throw IllegalArgumentException(),
                zipcode = createUserInDTO.zipcode ?: throw IllegalArgumentException(),
                state = createUserInDTO.state ?: throw IllegalArgumentException()
            )
        }
    }
}

data class CreateUserOutDTO(
    val userId: Long?,
    val email: String?,
    val birth: LocalDateTime?,
    val gender: Gender?,
    val city: String?,
    val street: String?,
    val zipcode: String?,
    val state: State?
){
    companion object Mapper {
        fun toCreateUserOutDTO(user: User): CreateUserOutDTO {
            return CreateUserOutDTO(
                userId = user.userId,
                email = user.email,
                birth = user.birth,
                gender = user.gender,
                city = user.city,
                street = user.street,
                zipcode = user.zipcode,
                state = user.state
            )
        }
    }
}