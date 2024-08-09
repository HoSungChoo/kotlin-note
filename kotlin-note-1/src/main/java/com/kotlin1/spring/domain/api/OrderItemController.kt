package com.kotlin1.spring.domain.api

import com.kotlin1.spring.domain.dto.*
import com.kotlin1.spring.domain.service.OrderItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order-item")
class OrderItemController(private var orderItemService: OrderItemService) {
    @GetMapping()
    fun readOrderItemById(@RequestParam id: Long): ResponseEntity<ReadOrderItemOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.readOrderItemById(id))
    }
    @GetMapping("/order")
    fun readOrderItemByOrderId(@RequestParam orderId: Long): ResponseEntity<ReadOrderItemOutDTOS>{
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.readOrderItemByOrderId(orderId))
    }
    @GetMapping("/user")
    fun readOrderItemByUserId(@RequestParam userId: Long): ResponseEntity<ReadOrderItemOutDTOS>{
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.readOrderItemByUserId(userId))
    }
    @GetMapping("/item")
    fun readOrderItemByItemId(@RequestParam itemId: Long): ResponseEntity<ReadOrderItemOutDTOS>{
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.readOrderItemByItemId(itemId))
    }
    @PostMapping()
    fun createOrderItemById(@RequestBody createOrderItemInDTO: CreateOrderItemInDTO): ResponseEntity<CreateOrderItemOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.createOrderItemById(createOrderItemInDTO))
    }
}