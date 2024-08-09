package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.global.annotation.AllOpen
import jakarta.persistence.*
import java.time.LocalDate
@AllOpen
@Entity(name = "order_items")
class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderItemId: Long,

    @Column(nullable = false)
    val count: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    val item: Item
){
    companion object Mapper{
        fun toEntity(
            orderItem: Long,
            count: Long,
            order: Order,
            item: Item
        ): OrderItem{
            return OrderItem(
                orderItemId = orderItem,
                count = count,
                order = order,
                item = item
            )
        }
    }
}