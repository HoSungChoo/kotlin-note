package com.kotlin1.spring.domain.service

import com.kotlin1.spring.domain.dto.*
import org.springframework.stereotype.Service

@Service
interface OrderService{
    fun readOrderByUserId(userId: Long): ReadOrderOutDTOS
    fun readOrderById(orderId: Long): ReadOrderOutDTO
    fun readOrderAll(page: Long, size: Long): ReadOrderOutDTOS
    fun createOrder(createOrderInDTO: CreateOrderInDTO): CreateOrderOutDTO
}