package com.kotlin1.spring.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderId: Long = 0L

    @Column(nullable = false)
    val date: LocalDateTime = LocalDateTime.now()

    @ManyToOne(fetch = FetchType.LAZY)
    val userId: Long = 0L
}