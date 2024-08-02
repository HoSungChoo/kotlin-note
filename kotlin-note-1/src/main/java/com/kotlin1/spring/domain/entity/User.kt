package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import com.kotlin1.spring.global.annotation.AllOpen
import jakarta.persistence.*
import java.time.LocalDateTime

@AllOpen
@Entity(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long?,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val birth: LocalDateTime,

    @Column(nullable = false)
    val gender: Gender,

    @Column(nullable = false)
    val city: String,

    @Column(nullable = false)
    val street: String,

    @Column(nullable = false)
    val zipcode: String,

    @Column(nullable = false)
    val state: State
)