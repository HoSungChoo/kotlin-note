package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.global.annotation.AllOpen
import jakarta.persistence.*
import java.time.LocalDate
@AllOpen
@Entity(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderId: Long = 0L,

    @Column(nullable = false)
    val date: LocalDate,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
){
    companion object Mapper{
        fun toEntity(orderId: Long, date: LocalDate, user: User): Order{
            return Order(orderId = orderId, date = date, user = user)
        }
    }
}