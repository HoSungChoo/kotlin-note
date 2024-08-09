package com.kotlin1.spring.domain.entity

import com.kotlin1.spring.domain.enumerate.ItemType
import com.kotlin1.spring.global.annotation.AllOpen
import jakarta.persistence.*

@AllOpen
@Entity(name = "items")
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val itemId: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val type: ItemType,

    @Column(nullable = false)
    val price: Long,

    @Column(nullable = false)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    val provider: Provider,
) {
    companion object Mapper {
        fun toEntity(
            itemId: Long,
            name: String,
            type: ItemType,
            price: Long,
            content: String,
            provider: Provider,
        ): Item {
            return Item(
                itemId = itemId,
                name = name,
                type = type,
                price = price,
                content = content,
                provider = provider
            )
        }
    }
}