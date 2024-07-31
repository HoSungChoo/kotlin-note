package com.kotlin1.spring.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime
@Entity(name = "order_items")
class OrderItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderItemId: Long = 0L

    @Column(nullable = false)
    val count: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: Order? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    var item: Item? = null
}