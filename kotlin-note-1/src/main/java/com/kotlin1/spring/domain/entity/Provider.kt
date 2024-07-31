package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

class Provider{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val providerId: Long = 0L

    @Column(nullable = false)
    val email: String = "empty"

    @Column(nullable = false)
    val birth: LocalDateTime = LocalDateTime.now()

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
}