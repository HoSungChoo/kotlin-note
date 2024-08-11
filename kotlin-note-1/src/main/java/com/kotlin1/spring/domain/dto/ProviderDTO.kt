package com.kotlin1.spring.domain.dto

import com.kotlin1.spring.domain.entity.Provider
import com.kotlin1.spring.domain.enumerate.Gender
import com.kotlin1.spring.domain.enumerate.State
import java.time.LocalDate

class ProviderDTO {
    data class ReadProviderOutDTO(
        val providerId: Long,
        val email: String, val birth: LocalDate,
        val gender: Gender,
        val city: String,
        val street: String,
        val zipcode: String,
        val state: State
    ){
        companion object Mapper{
            fun toDTO(provider: Provider): ReadProviderOutDTO {
                return ReadProviderOutDTO(
                    providerId = provider.providerId,
                    email = provider.email,
                    birth = provider.birth,
                    gender = provider.gender,
                    city = provider.city,
                    street = provider.street,
                    zipcode = provider.zipcode,
                    state = provider.state
                )
            }
        }
    }
    data class ReadProviderSortByCountOutDTO(
        val providerId: Long,
        val email: String,
        val birth: LocalDate,
        val gender: Gender,
        val city: String,
        val street: String,
        val zipcode: String,
        val state: State,
        val count: Long
    )

    data class ReadProviderSortByCountOutDTOS(val providers: List<ReadProviderSortByCountOutDTO>)

    data class CreateProviderInDTO(
        val providerId: Long,
        val email: String,
        val birth: LocalDate,
        val gender: Gender,
        val city: String,
        val street: String,
        val zipcode: String,
        val state: State,
    )

    data class CreateProviderOutDTO(
        val providerId: Long,
        val email: String,
        val birth: LocalDate,
        val gender: Gender,
        val city: String,
        val street: String,
        val zipcode: String,
        val state: State,
    ){
        companion object Mapper {
            fun toDTO(provider: Provider): CreateProviderOutDTO {
                return CreateProviderOutDTO(
                    providerId = provider.providerId,
                    email = provider.email,
                    birth = provider.birth,
                    gender = provider.gender,
                    city = provider.city,
                    street = provider.street,
                    zipcode = provider.zipcode,
                    state = provider.state
                )
            }
        }
    }
}