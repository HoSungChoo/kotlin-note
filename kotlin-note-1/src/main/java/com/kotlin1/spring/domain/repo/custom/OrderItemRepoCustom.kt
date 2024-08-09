package com.kotlin1.spring.domain.repo.custom

import com.kotlin1.spring.domain.dto.ReadOrderItemOutDTO
import org.springframework.stereotype.Repository

interface OrderItemRepoCustom {
    fun findAllByOrderId(orderId: Long): List<ReadOrderItemOutDTO>
    fun findAllByUserId(userId: Long): List<ReadOrderItemOutDTO>
    fun findAllByItemId(itemId: Long): List<ReadOrderItemOutDTO>
}