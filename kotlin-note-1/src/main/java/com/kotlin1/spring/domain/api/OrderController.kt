package com.kotlin1.spring.domain.api

import com.kotlin1.spring.domain.dto.*
import com.kotlin1.spring.domain.service.OrderService
import com.kotlin1.spring.domain.service.UserService
import com.sun.net.httpserver.HttpsServer
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController(private val orderService: OrderService){
    @GetMapping("/user")
    fun readOrderByUserId(@RequestParam id: Long) : ResponseEntity<ReadOrderOutDTOS>{
        return ResponseEntity.status(HttpStatus.OK).body(orderService.readOrderByUserId(id))
    }
    @GetMapping()
    fun readOrderById(@RequestParam orderId: Long): ResponseEntity<ReadOrderOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(orderService.readOrderById(orderId))
    }
    @GetMapping("/all")
    fun readOrderAll(@RequestParam page: Long, @RequestParam size: Long): ResponseEntity<ReadOrderOutDTOS>{
        return ResponseEntity.status(HttpStatus.OK).body(orderService.readOrderAll(page, size))
    }
    @PostMapping()
    fun createOrder(@RequestBody createOrderInDTO: CreateOrderInDTO): ResponseEntity<CreateOrderOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(orderService.createOrder(createOrderInDTO))
    }
}

