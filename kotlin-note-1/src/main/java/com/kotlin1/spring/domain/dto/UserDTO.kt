package com.kotlin1.spring.domain.dto

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
)