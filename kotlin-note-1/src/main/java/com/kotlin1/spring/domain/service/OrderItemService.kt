package com.kotlin1.spring.domain.service

import com.kotlin1.spring.domain.dto.CreateOrderItemInDTO
import com.kotlin1.spring.domain.dto.CreateOrderItemOutDTO
import com.kotlin1.spring.domain.dto.ReadOrderItemOutDTO
import com.kotlin1.spring.domain.dto.ReadOrderItemOutDTOS
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

interface OrderItemService {
    fun readOrderItemById(id: Long): ReadOrderItemOutDTO
    fun readOrderItemByOrderId(orderId: Long): ReadOrderItemOutDTOS
    fun readOrderItemByUserId(userId: Long): ReadOrderItemOutDTOS
    fun readOrderItemByItemId(itemId: Long): ReadOrderItemOutDTOS
    fun createOrderItemById(createOrderItemInDTO: CreateOrderItemInDTO): CreateOrderItemOutDTO
}