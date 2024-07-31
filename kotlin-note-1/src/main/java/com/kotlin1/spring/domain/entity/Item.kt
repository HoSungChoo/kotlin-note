package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.domain.enumerate.ItemType
import jakarta.persistence.*
@Entity(name = "items")
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val itemId: Long = 0L

    @Column(nullable = false)
    val name: String = "empty"

    @Column(nullable = false)
    val type: ItemType = ItemType.CON

    @Column(nullable = false)
    val price: Long = 0L

    @Column(nullable = false)
    val content: String = "empty"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    var provider: Provider? = null
}