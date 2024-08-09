package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import com.kotlin1.spring.domain.service.ProviderService
import com.kotlin1.spring.global.annotation.AllOpen
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@AllOpen
@Entity(name = "providers")
class Provider(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val providerId: Long,

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
    val state: State
){
    companion object Mapper{
        fun toEntity(
            providerId: Long,
            email: String,
            birth: LocalDate,
            gender: Gender,
            city: String,
            street: String,
            zipcode: String,
            state: State,
        ): Provider {
            return Provider(
                providerId = providerId, email = email, birth = birth, gender = gender,
                city = city, street = street, zipcode = zipcode, state = state
            )
        }
    }
}