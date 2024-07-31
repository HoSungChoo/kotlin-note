package com.kotlin1.spring.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

class OrderItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderItemId: Long = 0L

    @Column(nullable = false)
    val count: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    val orderId: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    val itemId: Long = 0L
}