package com.kotlin1.spring.domain.service.impl

import com.kotlin1.spring.domain.dto.CreateOrderItemInDTO
import com.kotlin1.spring.domain.dto.CreateOrderItemOutDTO
import com.kotlin1.spring.domain.dto.ReadOrderItemOutDTO
import com.kotlin1.spring.domain.dto.ReadOrderItemOutDTOS
import com.kotlin1.spring.domain.entity.OrderItem
import com.kotlin1.spring.domain.repo.custom.OrderItemRepoCustom
import com.kotlin1.spring.domain.repo.custom.OrderRepoCustom
import com.kotlin1.spring.domain.repo.origin.ItemRepo
import com.kotlin1.spring.domain.repo.origin.OrderItemRepo
import com.kotlin1.spring.domain.repo.origin.OrderRepo
import com.kotlin1.spring.domain.service.OrderItemService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderItemServiceImpl(
    private var orderItemRepo: OrderItemRepo,
    private var orderItemRepoCustom: OrderItemRepoCustom,
    private var orderRepo: OrderRepo,
    private var itemRepo: ItemRepo
): OrderItemService {
    override fun readOrderItemById(id: Long): ReadOrderItemOutDTO {
        return ReadOrderItemOutDTO.toDTO(
            orderItemRepo.findByIdOrNull(id) ?: throw NoSuchElementException()
        )
    }
    override fun readOrderItemByOrderId(orderId: Long): ReadOrderItemOutDTOS {
        return ReadOrderItemOutDTOS(orderItemRepoCustom.findAllByOrderId(orderId))
    }
    override fun readOrderItemByUserId(userId: Long): ReadOrderItemOutDTOS {
        return ReadOrderItemOutDTOS(orderItemRepoCustom.findAllByUserId(userId))
    }
    override fun readOrderItemByItemId(itemId: Long): ReadOrderItemOutDTOS {
        return ReadOrderItemOutDTOS(orderItemRepoCustom.findAllByItemId(itemId))
    }
    override fun createOrderItemById(createOrderItemInDTO: CreateOrderItemInDTO): CreateOrderItemOutDTO {
        val order = orderRepo.findByIdOrNull(createOrderItemInDTO.orderId) ?: throw NoSuchElementException()
        val item = itemRepo.findByIdOrNull(createOrderItemInDTO.itemId) ?: throw NoSuchElementException()

        val orderItem = OrderItem.toEntity(
            orderItem = 0L,
            count = createOrderItemInDTO.count,
            order = order,
            item = item
        )

        return CreateOrderItemOutDTO.toDTO(orderItem)
    }
}
