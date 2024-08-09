package com.kotlin1.spring.domain.dto

import com.kotlin1.spring.domain.entity.User
import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import java.time.LocalDate


data class ReadUserOutDTO(
    val userId: Long, val email: String, val birth: LocalDate, val gender: Gender,
    val city: String, val street: String, val zipcode: String, val state: State
) {
    companion object Mapper {
        fun toDTO(user: User): ReadUserOutDTO {
            return ReadUserOutDTO(
                userId = user.userId, email = user.email, birth = user.birth, gender = user.gender,
                city = user.city, street = user.street, zipcode = user.zipcode, state = user.state
            )
        }
    }
}

data class CreateUserInDTO(
    val userId: Long,
    val email: String,
    val birth: LocalDate,
    val gender: Gender,
    val city: String,
    val street: String,
    val zipcode: String,
    val state: State,
) {
    companion object Mapper {

    }
}

data class CreateUserOutDTO(
    val userId: Long,
    val email: String,
    val birth: LocalDate,
    val gender: Gender,
    val city: String,
    val street: String,
    val zipcode: String,
    val state: State
) {
    companion object Mapper {
        fun toDTO(user: User): CreateUserOutDTO {
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
