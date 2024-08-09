package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.domain.dto.CreateUserInDTO
import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import com.kotlin1.spring.global.annotation.AllOpen
import jakarta.persistence.*
import java.time.LocalDate

@AllOpen
@Entity(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long = 0L,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val birth: LocalDate,

    @Column(nullable = false)
    val gender: Gender,

    @Column(nullable = false)
    val city: String,

    @Column(nullable = false)
    val street: String,

    @Column(nullable = false)
    val zipcode: String,

    @Column(nullable = false)
    val state: State,
) {
    companion object Mapper {
        fun toEntity(
            userId: Long,
            email: String,
            birth: LocalDate,
            gender: Gender,
            city: String,
            street: String,
            zipcode: String,
            state: State,
        ): User {
            return User(
                userId = userId, email = email, birth = birth, gender = gender,
                city = city, street = street, zipcode = zipcode, state = state
            )
        }
    }
}