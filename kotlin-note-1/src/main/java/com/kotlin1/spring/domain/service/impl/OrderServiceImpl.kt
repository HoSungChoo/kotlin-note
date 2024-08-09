package com.kotlin1.spring.domain.service.impl

import com.kotlin1.spring.domain.dto.CreateOrderInDTO
import com.kotlin1.spring.domain.dto.CreateOrderOutDTO
import com.kotlin1.spring.domain.dto.ReadOrderOutDTO
import com.kotlin1.spring.domain.dto.ReadOrderOutDTOS
import com.kotlin1.spring.domain.entity.Order
import com.kotlin1.spring.domain.repo.origin.OrderRepo
import com.kotlin1.spring.domain.repo.origin.UserRepo
import com.kotlin1.spring.domain.repo.custom.OrderRepoCustom
import com.kotlin1.spring.domain.service.OrderService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class OrderServiceImpl(
    private val orderRepo: OrderRepo,
    private val orderRepoCustom: OrderRepoCustom,
    private val userRepo: UserRepo,
) : OrderService {
    override fun readOrderByUserId(userId: Long): ReadOrderOutDTOS {
        val results: List<ReadOrderOutDTO> = orderRepoCustom.findAllByUserId(userId)

        return ReadOrderOutDTOS(results)
    }

    override fun readOrderById(orderId: Long): ReadOrderOutDTO {
        val order = orderRepo.findByIdOrNull(orderId) ?: throw NoSuchElementException()

        return ReadOrderOutDTO(
            orderId = order.orderId,
            date = order.date,
            userId = order.user.userId
        )
    }

    override fun readOrderAll(page: Long, size: Long): ReadOrderOutDTOS {
        require(size in 1..100) { "size should be 100 or less" }
        val results: List<ReadOrderOutDTO> = orderRepoCustom.findAllUsingPage(page, size)

        return ReadOrderOutDTOS(results)
    }

    override fun createOrder(createOrderInDTO: CreateOrderInDTO): CreateOrderOutDTO {
        val user = userRepo.findByIdOrNull(createOrderInDTO.userId) ?: throw NoSuchElementException()

        val order = Order.toEntity(
            orderId = 0L,
            date = LocalDate.now(),
            user = user
        )

        return CreateOrderOutDTO.toDTO(orderRepo.save(order))
    }
}