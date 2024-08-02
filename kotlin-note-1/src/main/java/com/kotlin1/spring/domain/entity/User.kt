package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import com.kotlin1.spring.global.annotation.AllOpen
import jakarta.persistence.*
import java.time.LocalDateTime

@AllOpen
@Entity(name = "users")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long = 0L

    @Column(nullable = false)
    val email: String = "empty"

    @Column(nullable = false)
    open val birth: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    val gender: Gender = Gender.M

    @Column(nullable = false)
    val city: String = "empty"

    @Column(nullable = false)
    val street: String = "empty"

    @Column(nullable = false)
    val zipcode: String = "empty"

    @Column(nullable = false)
    val state: State = State.U

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