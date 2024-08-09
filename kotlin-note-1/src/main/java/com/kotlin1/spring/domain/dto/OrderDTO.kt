package com.kotlin1.spring.domain.dto

import com.kotlin1.spring.domain.entity.Order
import com.kotlin1.spring.domain.entity.User
import java.time.LocalDate

data class ReadOrderOutDTO(val orderId: Long = 0L, val date: LocalDate, val userId: Long)

data class ReadOrderOutDTOS(val orders: List<ReadOrderOutDTO>)

data class CreateOrderInDTO(val userId: Long = 0L)

data class CreateOrderOutDTO(val orderId: Long, val date: LocalDate, val userId: Long){
    companion object Mapper{
        fun toDTO(order: Order): CreateOrderOutDTO{
            return CreateOrderOutDTO(
                orderId = order.orderId,
                date = order.date,
                userId = order.user.userId
            )
        }
    }
}