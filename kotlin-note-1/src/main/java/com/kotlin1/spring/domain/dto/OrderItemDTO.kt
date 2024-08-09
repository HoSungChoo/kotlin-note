package com.kotlin1.spring.domain.dto

import com.kotlin1.spring.domain.entity.OrderItem

data class ReadOrderItemOutDTO(
    val orderItemId: Long,
    val count: Long,
    val orderId: Long,
    val itemId: Long,
) {
    companion object Mapper {
        fun toDTO(orderItem: OrderItem): ReadOrderItemOutDTO {
            return ReadOrderItemOutDTO(
                orderItemId = orderItem.orderItemId,
                count = orderItem.count,
                orderId = orderItem.order.orderId,
                itemId = orderItem.item.itemId
            )
        }
    }
}

data class ReadOrderItemOutDTOS(val orderItems: List<ReadOrderItemOutDTO>) {

}

data class CreateOrderItemInDTO(
    val orderItemId: Long,
    val count: Long,
    val orderId: Long,
    val itemId: Long,
) {

}

data class CreateOrderItemOutDTO(
    val orderItemId: Long,
    val count: Long,
    val orderId: Long,
    val itemId: Long,
) {
    companion object Mapper {
        fun toDTO(orderItem: OrderItem): CreateOrderItemOutDTO {
            return CreateOrderItemOutDTO(
                orderItemId = orderItem.orderItemId,
                count = orderItem.count,
                orderId = orderItem.order.orderId,
                itemId = orderItem.item.itemId
            )
        }
    }
}