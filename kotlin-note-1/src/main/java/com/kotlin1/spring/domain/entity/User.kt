package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class User(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null

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